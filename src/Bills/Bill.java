package Bills;

import java.util.Random;

public class Bill implements billsPayment
{
    protected double amount;
    protected billType type;
    protected boolean paid = false;
    public Bill(billType b)
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
