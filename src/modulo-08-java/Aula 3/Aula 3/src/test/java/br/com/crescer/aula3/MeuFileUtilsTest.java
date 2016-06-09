package br.com.crescer.aula3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MeuFileUtilsTest {
    
    public MeuFileUtilsTest() {
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
     * Test of mk method, of class MeuFileUtils.
     */
    @Test
    public void testMk() throws Exception {
        System.out.println("mk");
        String path = "";
        MeuFileUtils.mk(path);
        assertEquals(path, path);
    }

    /**
     * Test of rm method, of class MeuFileUtils.
     */
    @Test
    public void testRm() throws Exception {
        System.out.println("rm");
        String path = "";
        MeuFileUtils.rm(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ls method, of class MeuFileUtils.
     */
    @Test
    public void testLs() {
        System.out.println("ls");
        String path = "";
        MeuFileUtils.ls(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mv method, of class MeuFileUtils.
     */
    @Test
    public void testMv() throws Exception {
        System.out.println("mv");
        String arquivo = "";
        String path = "";
        MeuFileUtils.mv(arquivo, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MeuFileUtils.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MeuFileUtils.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
