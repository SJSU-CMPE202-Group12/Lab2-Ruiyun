
public class GumballMachinePattern implements IGumballMachine
{
    private NoEnoughCoinsState no_enough_coins ;
    private EnoughCoinsState enough_coins ;
    private IGumballState current ;
    private boolean hasGumball ;
    private int gumball_price;
    private CoinCounter coin_counter;
    private int remainder;
    
    public GumballMachinePattern()
    {
        this(50);
    }
    
    public GumballMachinePattern(int gumball_price )
    {
        this.no_enough_coins = new NoEnoughCoinsState(this);
        this.enough_coins = new EnoughCoinsState(this);
        this.current = no_enough_coins;
        this.hasGumball = false ;
        this.gumball_price = gumball_price;
        this.coin_counter = new CoinCounter();
        this.remainder = 0;
    }
    
    public int getRemainder()
    {
        return this.remainder;
    }
    
    public CoinCounter getCoinCounter()
    {
        return this.coin_counter;
    }

    public void insert(CoinType coinType)
    {
        this.coin_counter.insert(coinType);
    }
    
    public boolean haveEnoughCoins()
    {
        return this.coin_counter.totalValue() + this.remainder >= this.gumball_price;
    }
    
    public void receiveCoins()
    {
        this.remainder = this.coin_counter.totalValue() + this.remainder - this.gumball_price;
        this.coin_counter.clear();
    }
   
   
    public void setState( GumballStates state )
    {
        switch (state) {
            case ENOUGH_COINS:
                this.current = enough_coins ;
                break ;
            case NO_ENOUGH_COINS:
                this.current = no_enough_coins ;
                break ;
            }
    }

    public void insertQuarter() throws GumballException
    {
        current.insertQuarter() ;
    }
    
    public void insertDime() throws GumballException
    {
        current.insertDime() ;
    }
    
    public void insertNickel() throws GumballException
    {
        current.insertNickel() ;
    }
    
    public void turnCrank() throws GumballException
    {
        if (current == enough_coins )
        {
            hasGumball = true ;
        }
        current.turnCrank() ;      
    }
    
    public boolean isGumballInSlot()
    {
        return this.hasGumball ;
    }
    
    public void takeGumballFromSlot()
    {
        this.hasGumball = false ;
    }
}
