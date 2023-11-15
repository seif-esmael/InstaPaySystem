package Database;
public class dummyWalletDatabase extends dummyDatabase
{
    dummyWalletDatabase()
    {
        //--------------------------------------------------------------------------------------------------------------
        Account youssef = new walletAccount();
        youssef.setUserName("youssef");
        youssef.setPassword("youssefabdullah");
        youssef.setMobileNumber("01233456789");
        youssef.setBalance(2000);
        accounts.add(youssef);
        //--------------------------------------------------------------------------------------------------------------
    }
    public boolean checkExistance(String mobileNumber)    
    {
        for(Account a : accounts)
        {
            if(a instanceof walletAccount &&((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                return true;
            }
        }
        return false;
    }
    //_____________________________________________________________________________________________
    public boolean checkBalance(String mobileNumber, double amount)
    {
        for(Account a : accounts)
        {
            if(a instanceof walletAccount && ((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                if(((walletAccount) a).getBalance() < amount)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        }
        return false;
    }
    //_____________________________________________________________________________________________
    public static void addCredit(String mobileNumber, double amount)
    {
        for(Account a : accounts)
        {
            if(a instanceof walletAccount && ((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                ((walletAccount) a).setBalance(((walletAccount) a).getBalance() + amount);
                break;
            }
        }
    }
    //_____________________________________________________________________________________________
    public static void removeCredit(String mobileNumber, double amount)
    {
        for(Account a : accounts)
        {
            if(a instanceof walletAccount && ((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                ((walletAccount) a).setBalance(((walletAccount) a).getBalance() - amount);
                break;
            }
        }
    }
}
