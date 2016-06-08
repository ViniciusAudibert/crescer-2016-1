package br.com.crescer.exerciciostema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MeuStringUtilTest {

    public MeuStringUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testIsEmptyStringVazia() {
        System.out.println("isEmpty");
        String string = "";
        boolean expResult = true;
        boolean result = MeuStringUtil.isEmpty(string);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsEmptyStringComEspaco() {
        System.out.println("isEmpty");
        String string = "                    ";
        boolean expResult = true;
        boolean result = MeuStringUtil.isEmpty(string);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsEmptyComCaracteres() {
        System.out.println("isEmpty");
        String string = "asd asd";
        boolean expResult = false;
        boolean result = MeuStringUtil.isEmpty(string);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsEmptyNull() {
        System.out.println("isEmpty");
        String string = null;
        boolean expResult = true;
        boolean result = MeuStringUtil.isEmpty(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of numVogais method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testNumVogais() {
        System.out.println("numVogais");
        String string = "1a2baseioOoU";
        int expResult = 8;
        int result = MeuStringUtil.numVogais(string);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testNumVogaisStringVazia() {
        System.out.println("numVogais");
        String string = "";
        int expResult = 0;
        int result = MeuStringUtil.numVogais(string);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testNumVogaisStringNull() {
        System.out.println("numVogais");
        String string = null;
        int expResult = 0;
        int result = MeuStringUtil.numVogais(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of inverter method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testInverter() {
        System.out.println("inverter");
        String string = "123";
        String expResult = "321";
        String result = MeuStringUtil.inverter(string);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testInverterComEspacos() {
        System.out.println("inverter");
        String string = "crescer 2016/1 - AB";
        String expResult = "BA - 1/6102 recserc";
        String result = MeuStringUtil.inverter(string);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testInverterNull() {
        System.out.println("inverter");
        String string = null;
        String expResult = null;
        String result = MeuStringUtil.inverter(string);
        assertNull(result);
    }
    
    /**
     * Test of isPalindromo method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testIsPalindromoTrue() {
        System.out.println("isPalindromo");
        String string = "ana";
        boolean expResult = true;
        boolean result = MeuStringUtil.isPalindromo(string);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsPalindromoFalse() {
        System.out.println("isPalindromo");
        String string = "anas";
        boolean expResult = false;
        boolean result = MeuStringUtil.isPalindromo(string);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsPalindromoEmpty() {
        System.out.println("isPalindromo");
        String string = "    ";
        boolean expResult = false;
        boolean result = MeuStringUtil.isPalindromo(string);
        assertEquals(expResult, result);
    }

    @org.junit.Test
    public void testIsPalindromoNull() {
        System.out.println("isPalindromo");
        String string = null;
        boolean expResult = false;
        boolean result = MeuStringUtil.isPalindromo(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class MeuStringUtil.
     */
    @org.junit.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MeuStringUtil.main(args);
    }

}
