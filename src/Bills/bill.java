package Bills;

import java.util.Random;

public class bill implements billsPayment
{
    protected double amount;
    protected billType type;
    protected static boolean paid = false;
    public bill(billType b)
    {
        type = b;
        Random random = new Random();
        amount = random.nextFloat((1000 - 100) + 1) + 100;
    }
    public billType getType()
    {
        return type;
    }
    public double getAmount()
    {
        return amount;
    }
    @Override
    public void pay()
    {
         paid = true;
    }
    public boolean getStatus()
    {
        return paid;
    }
}
