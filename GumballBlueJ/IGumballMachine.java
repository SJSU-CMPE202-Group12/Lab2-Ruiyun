
public interface IGumballMachine
{
    public void insertQuarter() throws GumballException ;
    public void insertDime() throws GumballException ;
    public void insertNickel() throws GumballException ;
    public void turnCrank() throws GumballException ;
    public boolean isGumballInSlot();
    public void takeGumballFromSlot();
}
