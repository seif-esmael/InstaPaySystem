package instapaysystem;

public abstract class bill
{
    protected double amount;
    protected String type;
    public String getType()
    {
        return type;
    }
    public double getAmount()
    {
        return amount;
    }
}
