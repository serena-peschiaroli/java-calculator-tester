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

    @Test
    public void calculatePriceSenior(){
        Ticket ticket = new Ticket(70, 100);
        BigDecimal expected = new BigDecimal("12.60");
        assertEquals(expected, ticket.calculatePrice());
    }

    //test per le eccezioni in caso di inserimento dati errati

    @Test
    @DisplayName("Ticket with invalid parameters")
    public void testInvalidKmException(){
        assertThrows(IllegalArgumentException.class, () -> new Ticket(34, -100));
        assertThrows(IllegalArgumentException.class, () -> new Ticket(-23, 34));


    }
}
