package instapaysystem;
import java.util.Vector;
public class dummyBankDatabase extends dummyDatabase
{
    public boolean checkExistance(int id)
    {
        for(Account a : accounts)
        {
            if(((bankAccount) a).getBankAccountID() == id)
            {
                return true;
            }
        }
        return false;
    }
    public boolean checkBalance(int id, double amount)
    {
        for(Account a : accounts)
        {
            if(((bankAccount) a).getBankAccountID() == id)
            {
                if(((bankAccount) a).getBalance() < amount)
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
    public void addCredit(int id, double amount)
    {
        for(Account a : accounts)
        {
            if(((bankAccount) a).getBankAccountID() == id)
            {
                a.setBalance(a.getBalance() + amount);
                break;
            }
        }
    }
    public void removeCredit(int id, double amount)
    {
        for(Account a : accounts)
        {
            if(((bankAccount) a).getBankAccountID() == id)
            {
                a.setBalance(a.getBalance() - amount);
                break;
            }
        }
    }
}
