package experis.ticket;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TicketTest {


    /**
    *BigDecimal bd1 = new BigDecimal("1000.00");
    *BigDecimal bd2 = new BigDecimal("1000");
    *org.junit.Assert.assertTrue(bd1.compareTo(bd2) == 0);
     * **********************************************
     * BigDecimal bd = new BigDecimal("0");
     * assertThat(BigDecimal.ZERO.equals(bd)).isTrue();
    **/
    @Test
    public void calculatePriceAdult(){
        Ticket ticket = new Ticket(30,100);
        BigDecimal expected = new BigDecimal("21.00").setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expected, ticket.calculatePrice());
    }

    //test con confronto diretto usando assertEquals (senza setScale)
    @Test
    public void calculatePriceAdultDirectComparingBigDecimal(){
        Ticket ticket = new Ticket(30, 100);
        BigDecimal expected = new BigDecimal("21.00");
        BigDecimal actual = ticket.calculatePrice();
        assertEquals(expected, actual);

    }

    /***
    //test con compareTo
        @Test
        public void calculatePriceAdultCompareTo(){
            Ticket ticket = new Ticket(30, 75);
            BigDecimal expected = new BigDecimal("15.75");
            BigDecimal actual = ticket.calculatePrice();
            //compare to == 0 indica uguaglianza
            assertTrue(expected.compareTo(actual) == 0);
        }


     @Test
     public void testBigDecimalValueStrippingZeros() {
     BigDecimal expected = new BigDecimal("10.00");
     BigDecimal actual = someMethodThatReturnsBigDecimal().stripTrailingZeros();
     assertEquals(expected.stripTrailingZeros(), actual);
     }
    ***/

    //test per sconto minori

    @Test
    public void calculatePriceUnderage(){
        Ticket ticket = new Ticket(16, 89);
        BigDecimal expected = new BigDecimal("14.95");
        assertEquals(expected, ticket.calculatePrice());

    }

    //test su zero Km
    @Test
    public void calculatePriceForZeroKm(){
        Ticket ticket = new Ticket(18, 0);
        BigDecimal expected = new BigDecimal("0.00");
        assertEquals(expected, ticket.calculatePrice());

    }

    //test sui decimali

    @Test
    public void calculatePriceScale(){
        Ticket ticket = new Ticket(25, 50);
        BigDecimal price = ticket.calculatePrice();
        /* il primo argomento è il valore che ci si aspetta per la scale, il secondo
        * argomento è il valore che viene testato, il terzo argomento è un messaggio
        * opzionale che jUnit mostrerà in caso di fallimento del test*/
        assertEquals(2, price.scale(), "The scale should be 2");
    }

    /*Test idempotenza -->  chiamare questo metodo più volte con lo stesso insieme di parametri di input
     produrrà lo stesso risultato ogni volta senza modificare lo stato dell'oggetto
     */

    @Test
    public void calculatePriceIdempotency(){
        Ticket ticket = new Ticket(70, 100);
        BigDecimal firstCall = ticket.calculatePrice();
        BigDecimal secondCall = ticket.calculatePrice();

        assertEquals(firstCall, secondCall, "calculatePrice should return same result on successive calls");
    }

    @Test
    public void calculatePriceSenior(){
        Ticket ticket = new Ticket(70, 100);
        BigDecimal expected = new BigDecimal("12.60");
        assertEquals(expected, ticket.calculatePrice());
    }

    //test per le eccezioni in caso di inserimento dati errati

    @Test
    @DisplayName("Ticket with invalid parameters")
    public void testInvalidParametersException(){
        assertThrows(IllegalArgumentException.class, () -> new Ticket(34, -100));
        assertThrows(IllegalArgumentException.class, () -> new Ticket(-23, 34));


    }
}
