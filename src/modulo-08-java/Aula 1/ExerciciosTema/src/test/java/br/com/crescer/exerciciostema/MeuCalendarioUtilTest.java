package br.com.crescer.exerciciostema;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MeuCalendarioUtilTest {

    public MeuCalendarioUtilTest() {
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
     * Test of getDiaDaSemana method, of class MeuCalendarioUtil.
     */
    @Test
    public void testGetDiaDaSemanaDomingo() {
        System.out.println("getDiaDaSemana");
        int dia = 12;
        int mes = 6;
        int ano = 2016;
        String expResult = "Domingo";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDiaDaSemanaSabado() {
        System.out.println("getDiaDaSemana");
        int dia = 11;
        int mes = 6;
        int ano = 2016;
        String expResult = "Sábado";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDiaDaSemanaSegunda() {
        System.out.println("getDiaDaSemana");
        int dia = 6;
        int mes = 6;
        int ano = 2016;
        String expResult = "Segunda-feira";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDiaDaSemanaTerca() {
        System.out.println("getDiaDaSemana");
        int dia = 7;
        int mes = 6;
        int ano = 2016;
        String expResult = "Terça-feira";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDiaDaSemanaQuarta() {
        System.out.println("getDiaDaSemana");
        int dia = 8;
        int mes = 6;
        int ano = 2016;
        String expResult = "Quarta-feira";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDiaDaSemanaQuinta() {
        System.out.println("getDiaDaSemana");
        int dia = 9;
        int mes = 6;
        int ano = 2016;
        String expResult = "Quinta-feira";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDiaDaSemanaSexta() {
        System.out.println("getDiaDaSemana");
        int dia = 10;
        int mes = 6;
        int ano = 2016;
        String expResult = "Sexta-feira";
        String result = MeuCalendarioUtil.getDiaDaSemana(dia, mes, ano);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTempoDecorrido method, of class MeuCalendarioUtil.
     */
    @Test
    public void testGetTempoDecorridoZero() {
        System.out.println("getTempoDecorrido");
        Date data = new Date();
        String expResult = "0 ano(s), 0 mes(es) e 0 dia(s)";
        String result = MeuCalendarioUtil.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempoDecorrido10Dias() {
        System.out.println("getTempoDecorrido");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date data = calendar.getTime();
        String expResult = "0 ano(s), 0 mes(es) e 10 dia(s)";
        String result = MeuCalendarioUtil.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempoDecorrido10Meses() {
        System.out.println("getTempoDecorrido");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 10);
        Date data = calendar.getTime();
        String expResult = "0 ano(s), 10 mes(es) e 0 dia(s)";
        String result = MeuCalendarioUtil.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTempoDecorrido8Anos() {
        System.out.println("getTempoDecorrido");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 8);
        Date data = calendar.getTime();
        String expResult = "8 ano(s), 0 mes(es) e 0 dia(s)";
        String result = MeuCalendarioUtil.getTempoDecorrido(data);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class MeuCalendarioUtil.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MeuCalendarioUtil.main(args);
    }

}
