package experis.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class CalculatorTest {

    //Istanza Calculator che verrà usata nei metodi del test
    Calculator calculator;

    //before indica che il metodo setUp dovrà essere eseguito prima di ogni test
    @Before
    public void setUp(){
        /* setUp inizializza una nuova istanza Calculator prima di ogni
        test, assicurandosi che i test siano indipendenti
        * */
        calculator = new Calculator();

    }


    @Test
    //assertEquals (expected, actual, delta) : il delta è usato perchè i floating point possono avvere errori di arrotondamento

    public void testAdd(){
        assertEquals(3.0, calculator.add(1,2), 0.001);
        assertEquals(-3.0, calculator.add(-1, -2), 0.001);
        assertEquals(0.0, calculator.add(-1,1), 0.001);
    }

    @Test
    public void testSubtract(){
        assertEquals(2.0, calculator.subtract(5,3), 0.001);
        assertEquals(1.0, calculator.subtract(-1, -2), 0.001);
        assertEquals(-3.0, calculator.subtract(-1,2), 0.001);

    }

    @Test
    public void testMultiply(){
        assertEquals(12.0, calculator.multiply(3,4), 0.001);
        assertEquals(0.0, calculator.multiply(10,0), 0.001);
        assertEquals(-2.0, calculator.multiply(-1,2), 0.001);

    }

    @Test
    public void testDivide(){
        assertEquals(5.0, calculator.divide(10,2), 0.001);
        assertEquals(-0.5, calculator.divide(-1,2), 0.001);
        assertEquals(0.0, calculator.divide(0,1), 0.001);
    }

    //test per l'exception
    /*
    * la notazione indica che il test specifico si aspetta un exception
    * Junit passerà il test se l'eccezione specifica viene lanciata durante
    * l'esecuzione del test */
    @Test
    @DisplayName("Cannot divide by zero")
    public void testExceptionDivideByZero(){
        assertThrows(ArithmeticException.class, () ->calculator.divide(1,0) );

    }

    //edge cases


    //testa come si comporta il metodo quando uno degli operandi è NaN
    @Test
    public void testMultiplyWithNaN() {
        assertTrue(Float.isNaN(calculator.multiply(Float.NaN, 5)));
    }

    //testa il metodo subtract e come si comporta con numeri estremamente piccoli

    @Test
    public void testSubtractNearZero() {
        assertTrue(0.0 != calculator.subtract(1e-40f, 1e-40f));
    }

    // verifica il comportamento di multiply() quando l'operazione risulta in overflow

    @Test
    public void testMultiplyOverflow() {
        assertEquals(Float.POSITIVE_INFINITY, calculator.multiply(Float.MAX_VALUE, 2), 0);
    }

    @Test
    public void testSubtractUnderflow() {
        // l'underflow può perdere precisione o risultare zero
        assertEquals(0, calculator.subtract(1e-40f, 2e-40f), 0);
    }



}
