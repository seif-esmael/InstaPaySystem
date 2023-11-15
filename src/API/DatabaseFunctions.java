package API;

import User.instaPayBankUser;
import User.User;
import User.userType;

public class DatabaseFunctions
{
    public boolean transfertoInstaPay(int ID,double amount)
    {
        return true;
    }
    //_______________________________________________________________________________________________
    public static boolean search(String userName, String password) {
        for(User u : Database.dummyInstaPayDatabase.getUsers())
        {
            if(u.getUserName().equals(userName) && u.getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }
    //_______________________________________________________________________________________________    
    public static User getUser(String userName, String password) {
        for(User u : Database.dummyInstaPayDatabase.getUsers())
        {
            if(u.getUserName().equals(userName) && u.getPassword().equals(password))
            {
                return u;
            }
        }
        return null;
    } 
    //_______________________________________________________________________________________________
    public static User getUser(int ID, String which)
    {
        if(which.equals("insta"))
        {
            for(User u : Database.dummyInstaPayDatabase.getUsers())
            {
                if(u.getInstaID() == ID)
                {
                    return u;
                }
            }
            return null;
        }
        else
        {
            for(User u : Database.dummyInstaPayDatabase.getUsers())
            {
                if(((instaPayBankUser) u).getBankAccountID() == ID)
                {
                    return u;
                }
            }
            return null;
        }
    }
    //_______________________________________________________________________________________________
    public static User getUser(String mobileNumber) {
        for(User u : Database.dummyInstaPayDatabase.getUsers())
        {
            if(u.getMobileNumber().equals(mobileNumber))
            {
                return u;
            }
        }
        return null;
    }
    //_______________________________________________________________________________________________
    public static boolean deposit(double amount,User currentUser)
    {
        Database.dummyInstaPayDatabase.addCredit(currentUser.getInstaID(), amount);
        if(currentUser.getType().equals(userType.instaPayBankUser))
        {
            Database.database.bankDatabase.addCredit(((instaPayBankUser)currentUser).getBankAccountID(), amount);
        }
        else
        {
            Database.dummyWalletDatabase.addCredit(currentUser.getMobileNumber(), amount);
        }
        return true;
    }                   
    //_______________________________________________________________________________________________
    public static boolean withdraw(double amount,User currentUser)
    {
        if(!Database.dummyInstaPayDatabase.checkBalance(currentUser.getInstaID(), amount))
        {
            return false;
        }
        Database.dummyInstaPayDatabase.removeCredit(currentUser.getInstaID(), amount);
        if(currentUser.getType().equals(userType.instaPayBankUser))
        {
            Database.database.bankDatabase.removeCredit(((instaPayBankUser)currentUser).getBankAccountID(), amount);
        }
        else
        {
            Database.dummyWalletDatabase.removeCredit(currentUser.getMobileNumber(), amount);
        }
        return true;
    }
    //_______________________________________________________________________________________________
    public static void addUser(User u) {
        Database.dummyInstaPayDatabase.adduser(u);
    } 
}
