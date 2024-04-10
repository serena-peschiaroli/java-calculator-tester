package experiscalculator;

public class Calculator {

    //metodi pubblici per i calcoli
    public float add(float num1, float num2){
        return num1 + num2;
    }

    public float subtract(float num1, float num2){
        return num1 - num2;
    }

    public float multiply(float num1, float num2){
        return num1 * num2;
    }

    public float divide(float num1, float num2){
        if(num2  == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }

}
