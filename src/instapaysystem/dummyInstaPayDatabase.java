package instapaysystem;

import java.util.Vector;

public class dummyInstaPayDatabase
{
    private Vector<User> users = new Vector();
    public boolean checkExistance(int id)    
    {
        for(User u : users)
        {
            if(u.getInstaID() == id)
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkBalance(int id,double amount)
    {
        for(User u : users)
        {
            if(u.getInstaID() == id)
            {
                if(u.getBalance() >= amount)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        return false;
    }
    public void addCredit(int id,double amount)
    {
        for(User u : users)
        {
            if(u.getInstaID() == id)
            {
                u.updateBalance(amount);
                break;
            }
        }
    }
    public void removeCredit(int id,double amount)
    {
        for(User u : users)
        {
            if(u.getInstaID() == id)
            {
                u.updateBalance(-amount);
                break;
            }
        }
    }
}
