
public class EnoughCoinsState implements IGumballState
{
    private GumballMachinePattern gumball_machine ;
    
    public EnoughCoinsState(GumballMachinePattern m)
    {
        this.gumball_machine = m ;
    }
    
    public void insertQuarter() throws GumballException
    {
        throw new EnoughCoinsException() ;
    }
    
    public void insertDime() throws GumballException
    {
        throw new EnoughCoinsException() ;
    }
    
    public void insertNickel() throws GumballException
    {
        throw new EnoughCoinsException() ;
    }
    
    public void turnCrank() throws GumballException
    {
        this.gumball_machine.receiveCoins();
        this.gumball_machine.setState(GumballStates.NO_ENOUGH_COINS);
    }
    
}