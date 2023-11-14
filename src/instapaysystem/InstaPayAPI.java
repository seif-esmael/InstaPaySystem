package instapaysystem;

public class InstaPayAPI
{
//    public boolean transfertoInstaPay(int ID,double amount);

    public static void addUser(User u) {
        database.instaDatabase.adduser(u);
    }

    public static boolean search(String userName, String password) {
        for(User u : database.instaDatabase.getUsers())
        {
            if(u.userName.equals(userName) && u.password.equals(password))
            {
                return true;
            }
        }
        return false;
    }

    public static User getUser(String userName, String password) {
        for(User u : database.instaDatabase.getUsers())
        {
            if(u.userName.equals(userName) && u.password.equals(password))
            {
                return u;
            }
        }
        return null;
    }

    public static User getUser(String mobileNumber) {
        for(User u : database.instaDatabase.getUsers())
        {
            if(u.mobileNumber.equals(mobileNumber))
            {
                return u;
            }
        }
        return null;
    }

    public static User getUser(int ID, String which)
    {
        if(which.equals("insta"))
        {
            for(User u : database.instaDatabase.getUsers())
            {
                if(u.instaPayID == ID)
                {
                    return u;
                }
            }
            return null;
        }
        else
        {
            for(User u : database.instaDatabase.getUsers())
            {
                if(((instaPayBankUser) u).getBankAccountID() == ID)
                {
                    return u;
                }
            }
            return null;
        }
    }

    public static boolean deposit(double amount,User currentUser)
    {
        database.instaDatabase.addCredit(currentUser.instaPayID, amount);
        if(currentUser.type.equals(userType.instaPayBankUser))
        {
            database.bankDatabase.addCredit(((instaPayBankUser)currentUser).getBankAccountID(), amount);
        }
        else
        {
            database.walletDatabase.addCredit(currentUser.mobileNumber, amount);
        }
        return true;
    }

    public static boolean withdraw(double amount,User currentUser)
    {
        if(!database.instaDatabase.checkBalance(currentUser.getInstaID(), amount))
        {
            return false;
        }
        database.instaDatabase.removeCredit(currentUser.instaPayID, amount);
        if(currentUser.type.equals(userType.instaPayBankUser))
        {
            database.bankDatabase.removeCredit(((instaPayBankUser)currentUser).getBankAccountID(), amount);
        }
        else
        {
            database.walletDatabase.removeCredit(currentUser.mobileNumber, amount);
        }
        return true;
    }
}
