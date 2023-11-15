package User;

import Bills.Bill;
import Bills.billsPayment;
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
    //______________________________________________________________________________
    public String getUserName() {
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
                    
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public int getInstaID(){
        return instaPayID;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public userType getType()
    {
        return type;
    }
    //______________________________________________________________________________
    public void seeBills()
    {
        int cnt = 1;
        for(billsPayment i : bills)
        {
            System.out.print(cnt + "- " + ((Bill) i).getType() + " price: " + ((Bill) i).getAmount());
            cnt++;
            if(((Bill) i).getStatus())
            {
                System.out.print(" paid");
            }
            System.out.println();
        }
    }
    //______________________________________________________________________________
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    //______________________________________________________________________________
    public Vector<billsPayment> getBills()
    {
        return bills;
    }
    public void setBills(Vector<billsPayment> bills)
    {
        this.bills = bills;
    }
}
