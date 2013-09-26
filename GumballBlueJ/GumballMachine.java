
public class GumballMachine implements IGumballMachine
{
    private int num_gumballs;
    private int num_quarter;
    private int num_dime;
    private int num_nickel;
    private int remainder;
    private int gumball_price;
    
    public GumballMachine( int size )
    {
        this(size, 50);
    }

    public GumballMachine( int size, int gumball_price )
    {
        this.num_gumballs = size;
        this.gumball_price = gumball_price;
        this.remainder = 0;
        this.num_quarter = this.num_dime = this.num_nickel = 0;
    }

    public void insertQuarter() throws GumballException
    {
        this.num_quarter ++;
    }
    
    public void insertDime() throws GumballException
    {
        this.num_dime ++;
    }
    
    public void insertNickel() throws GumballException
    {
        this.num_nickel ++;
    }
    
    public int coinsInserted()
    {
        return this.num_quarter * 25 + 
                this.num_dime * 10 + 
                this.num_nickel * 5 + 
                remainder;
    }
    
    public boolean isMoneyEnough()
    {
        return coinsInserted() >= this.gumball_price;
    }
    
    public void turnCrank() throws GumballException
    {
        if ( isMoneyEnough() )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs-- ;
                this.remainder = coinsInserted() - gumball_price;
                this.num_quarter = this.num_dime = this.num_nickel = 0;
                System.out.println( "Thanks for your coins.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
            }
        }
        else 
        {
            System.out.println( "Please insert 50 cents coins" ) ;
        }        
    }
    
    public boolean isGumballInSlot()
    {
        return false;
    }
    
    public void takeGumballFromSlot()
    {
    }
}
