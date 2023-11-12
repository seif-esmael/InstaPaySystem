package instapaysystem;
import java.util.Vector;
public class dummyBankDatabase extends dummyDatabase
{
    dummyBankDatabase()
    {
        Account acc = new bankAccount();
        acc.setUserName("kero");
        acc.setPassword("kerooo");
        acc.setMobileNumber("012");
        acc.setBalance(1000);
        ((bankAccount) acc).setBankAccountID(1);
        accounts.add(acc);
        Account seif = new bankAccount();
        seif.setUserName("seif");
        seif.setPassword("seifooo");
        seif.setMobileNumber("0122");
        ((bankAccount) seif).setBankAccountID(2);
        seif.setBalance(1000);
        accounts.add(seif);
    }
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
