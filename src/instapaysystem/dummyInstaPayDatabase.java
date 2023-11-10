package instapaysystem;

import java.util.Vector;

public class dummyInstaPayDatabase
{
    private Vector<User> users = new Vector();
    //-------------------------------------------------------------
    public boolean checkExistance(int id)    
    {
        return true;
    }
    
    public boolean checkBalance(int id,double amount)
    {
        return true;
    }
    
    public void addCredit(int id,double amount)
    {
        
    }
    
    public void removeCredit(int id,double amount)
    {
        
    }
}
