package instapaysystem;

import java.util.Vector;

public abstract class User
{
    protected String userName;
    protected String password;
    protected String mobileNumber;
    protected int instaPayID;
    protected double balance;
    protected Vector<billsPayment> bills = new Vector();
    protected userType type;
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
    public void printBills()
    {
        int cnt = 1;
        for(billsPayment i : bills)
        {
            System.out.print(cnt + "- " + ((bill) i).getType() + " price: " + ((bill) i).getAmount());
            cnt++;
            if(((bill) i).getStatus())
            {
                System.out.print(" paid");
            }
            System.out.println();
        }
    }
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public Vector<billsPayment> getBills()
    {
        return bills;
    }
    public void setBills(Vector<billsPayment> bills)
    {
        this.bills = bills;
    }
    public userType getType()
    {
        return type;
    }
}
