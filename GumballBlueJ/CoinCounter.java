
public class CoinCounter
{
    private int num_quarter;
    private int num_dime;
    private int num_nickel;
    private int remainder;
        
    public CoinCounter()
    {
        clear();
    }
    
    public void clear()
    {
        this.num_quarter = 0;
        this.num_dime = 0;
        this.num_nickel = 0;
    }
    
    public void insert(CoinType coinType)
    {
        switch (coinType) {
            case QUARTER:
                this.num_quarter ++;
                break ;
            case DIME:
                this.num_dime ++;
                break ;
            case NICKEL:
                this.num_nickel ++;
                break ;
            }
    }
    
    public int totalValue()
    {
         return this.num_quarter * 25 + 
                this.num_dime * 10 + 
                this.num_nickel * 5;
    }
}