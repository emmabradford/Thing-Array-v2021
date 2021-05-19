
/**
 * Thing is a Comparable object that holds primative ints
 * 
 * @author 
 * @version
 */
public class Thing implements Comparable
{
    private int amount;
    public Thing(int x)
    {
        amount = x;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setAmount()
    {
        
    }
    
    public int compareTo(Object o)
    {
        Thing other = (Thing)(o);
        return (this.getAmount() - other.getAmount()) ;  // replace this line
    }
        
    public boolean equals(Thing a)
    {
        return this.compareTo(a) == 0;
    }
    
    public String toString()
    {
        return "Thing amount " + amount + "\n";
    }
}
