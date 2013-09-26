
public class NoEnoughCoinsState implements IGumballState
{
    private GumballMachinePattern gumball_machine ;
    
    public NoEnoughCoinsState(GumballMachinePattern m)
    {
        this.gumball_machine = m ;
        
    }
    
    public void insertQuarter() throws GumballException
    {
        this.gumball_machine.insert(CoinType.QUARTER);
        changeState();
    }
    
    public void insertDime() throws GumballException    
    {
        this.gumball_machine.insert(CoinType.DIME);
        changeState();
    }
    
    public void insertNickel() throws GumballException    
    {
        this.gumball_machine.insert(CoinType.NICKEL);
        changeState();
    }
    
    private void changeState()
    {
        if(this.gumball_machine.haveEnoughCoins())
        {
            this.gumball_machine.setState(GumballStates.ENOUGH_COINS);
        }
    }
    
    public void turnCrank() throws GumballException 
    {
        throw new NoEnoughCoinsException();
    }
}