package instapaysystem;

import java.util.Vector;

public abstract class User implements billsPayment
{
    protected String userName;
    protected String Password;
    protected String mobileNumber;
    protected int instaPayID;
    protected double balance;
    protected Vector<bill> bills = new Vector();
    protected userType type;
    //-------------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
    }
    //-------------------------------------------------
    public abstract boolean withdraw(double amount);
    //-------------------------------------------------
    public double getBalance()
    {
        return balance;
    }
    //-------------------------------------------------
    public int getInstaID()
    {
        return instaPayID;
    }
    //---------------------------------------------------
    public double printBills()
    {
        int cnt = 1;
        int totalPrice = 0;
        for(bill i : bills)
        {
            System.out.println(cnt + "- " + i.getType() + " price: " + i.getAmount());
            totalPrice += i.getAmount();
            cnt++;
        }
        System.out.println("Total price: " + totalPrice);
        return totalPrice;
    }
    public void updateBalance(double amount)
    {
        balance += amount;
    }
}
