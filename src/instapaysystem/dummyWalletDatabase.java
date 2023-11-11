package instapaysystem;
import java.util.Vector;
public class dummyWalletDatabase extends dummyDatabase
{
    public boolean checkExistance(String mobileNumber)    
    {
        for(Account a : accounts)
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkBalance(String mobileNumber, double amount)
    {
        for(Account a : accounts)
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
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
    public void addCredit(String mobileNumber, double amount)
    {
        for(Account a : accounts)
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                ((walletAccount) a).setBalance(((walletAccount) a).getBalance() + amount);
                break;
            }
        }
    }
    public void removeCredit(String mobileNumber, double amount)
    {
        for(Account a : accounts)
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                ((walletAccount) a).setBalance(((walletAccount) a).getBalance() - amount);
                break;
            }
        }
    }
}
