package experis.ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticket {
    //Attributi
    private int age;
    private final BigDecimal pricePerKm = new BigDecimal("0.21");
    private int kilometers;

    //costrutture
    public Ticket(int age, int kilometers) {
        this.age = age;
        this.kilometers = kilometers;
        validateKilometers();
        validateAge();
    }
    //metodi per validare age e Kilometri che lanciano eccezioni

    private void validateKilometers(){
        if(kilometers < 0){
            throw new IllegalArgumentException("Kilometers must be a positive numbers");

        }
    }

    private void validateAge(){
        if(age < 0){
            throw new IllegalArgumentException("Age must be a positive numbers");

        }
    }

    //metodo per cacolare il prezzo totale

    public BigDecimal calculatePrice(){
        BigDecimal total = pricePerKm.multiply(new BigDecimal(kilometers));
        BigDecimal discountRate = BigDecimal.ZERO;
        if(age < 18){
            discountRate = new BigDecimal("0.20");
        }else if(age > 65){
            discountRate = new BigDecimal("0.40");
        }

        if (discountRate.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal discountAmount = total.multiply(discountRate);
            total = total.subtract(discountAmount);
        }
        // arrotondamento
        return total.setScale(2, RoundingMode.HALF_EVEN);
    }




}
