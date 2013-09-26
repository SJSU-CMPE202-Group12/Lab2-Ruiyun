

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GumballMachinePatternTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GumballMachinePatternTest
{
    private GumballMachinePattern gumballMachine;

    /**
     * Default constructor for test class GumballMachinePatternTest
     */
    public GumballMachinePatternTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        gumballMachine = new GumballMachinePattern();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testInsertQuarter()
    {
        try {
            gumballMachine.insertQuarter();
            assertEquals(25, gumballMachine.getCoinCounter().totalValue());
        }
        catch ( GumballException e )
        {
            fail( "Invalid Exception Thrown!" ) ;
        }
    }
    
        @Test
    public void testInsertDime()
    {
        try {
            gumballMachine.insertDime();
            assertEquals(10, gumballMachine.getCoinCounter().totalValue());
        }
        catch ( GumballException e )
        {
            fail( "Invalid Exception Thrown!" ) ;
        }
    }
    
        @Test
    public void testInsertNickel()
    {
        try {
            gumballMachine.insertNickel();
            assertEquals(5, gumballMachine.getCoinCounter().totalValue());
        }
        catch ( GumballException e )
        {
            fail( "Invalid Exception Thrown!" ) ;
        }
    }
    

    @Test
    public void testNoCoins()
    {
        try {
            gumballMachine.turnCrank();
            assertEquals(false, gumballMachine.isGumballInSlot());
        }
        catch ( NoEnoughCoinsException e )
        {
            assertTrue(true) ;   
        }
        catch ( GumballException e )
        {
            fail( "Invalid Exception Thrown!" ) ;
        }
    }

    @Test
    public void testNoEnoughCoins()
    {
        try {
            gumballMachine.insertQuarter();
            gumballMachine.insertDime();
            gumballMachine.turnCrank();
            assertEquals(false, gumballMachine.isGumballInSlot());
        }
        catch ( NoEnoughCoinsException e )
        {
            assertTrue(true) ;   
        }
        catch ( GumballException e )
        {
            fail( "Invalid Exception Thrown!" ) ;
        }
    }

    @Test
    public void testDoubleQuarters()
    {
        try {            
            gumballMachine.insertQuarter();
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }

    @Test
    public void testFiveDimes()
    {
        try {     
            for(int i = 0; i < 5; i++)
            {
                gumballMachine.insertDime();
            }
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }

    @Test
    public void testTenNickels()
    {
        try {            
            for(int i = 0; i < 10; i++)
            {
                gumballMachine.insertNickel();
            }
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }

    @Test
    public void testCoinsInsertedMoreThan50Cents()
    {
        try {            
            gumballMachine.insertQuarter();
            gumballMachine.insertDime();
            gumballMachine.insertDime();
            gumballMachine.insertNickel();
            gumballMachine.insertDime();
        }
        catch ( EnoughCoinsException e )
        {
            assertTrue(true) ;   
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }
    
    @Test
    public void testRemainder()
    {
        try {            
            gumballMachine.insertQuarter();
            gumballMachine.insertDime();
            gumballMachine.insertDime();
            gumballMachine.insertDime();
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
            assertEquals(5, gumballMachine.getRemainder());
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }
    
        @Test
    public void testMultipleTransactions()
    {
        try {            
            gumballMachine.insertQuarter();
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());

            gumballMachine.takeGumballFromSlot();
            
            gumballMachine.insertQuarter();
            gumballMachine.insertDime();
            gumballMachine.insertDime();
            gumballMachine.insertDime();
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
            assertEquals(5, gumballMachine.getRemainder());
            
            gumballMachine.takeGumballFromSlot();
            
            gumballMachine.insertQuarter();
            gumballMachine.insertDime();
            gumballMachine.insertDime();
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
            assertEquals(0, gumballMachine.getRemainder());
            
            gumballMachine.takeGumballFromSlot();
            gumballMachine.insertQuarter();
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            assertEquals(true, gumballMachine.isGumballInSlot());
            assertEquals(0, gumballMachine.getRemainder());
        }
        catch ( GumballException e )
        {
            fail( e.getMessage() ) ;
        }
    }
}






