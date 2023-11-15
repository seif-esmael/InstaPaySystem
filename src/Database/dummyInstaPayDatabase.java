package Database;

import User.User;
import java.util.Vector;

public class dummyInstaPayDatabase
{
    private static Vector<User> users = new Vector();
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
    //____________________________________________________________________________________
    public static void adduser(User u)
    {
        users.add(u);
    }
    //____________________________________________________________________________________
    public static boolean checkBalance(int id,double amount)
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
    //____________________________________________________________________________________
    public static void addCredit(int id,double amount)
    {
        for(User u : users)
        {
            if(u.getInstaID() == id)
            {
                u.setBalance(u.getBalance() + amount);
                break;
            }
        }
    }
    //____________________________________________________________________________________
    public static void removeCredit(int id,double amount)
    {
        for(User u : users)
        {
            if(u.getInstaID() == id)
            {
                u.setBalance(u.getBalance() - amount);
                break;
            }
        }
    }
    //____________________________________________________________________________________
    public static Vector<User> getUsers()
    {
        return users;
    }
}
