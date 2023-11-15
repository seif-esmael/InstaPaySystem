package Database;


import java.util.Vector;
public class dummyBankDatabase extends dummyDatabase
{
    dummyBankDatabase()
    {
        //--------------------------------------------------------------------------------------------------------------
        Account kero = new bankAccount();
        kero.setUserName("kirlos");
        kero.setPassword("kirlosnabil");
        kero.setMobileNumber("01234567890");
        kero.setBalance(1500);
        ((bankAccount) kero).setBankAccountID(223);
        accounts.add(kero);
        //--------------------------------------------------------------------------------------------------------------
        Account seif = new bankAccount();
        seif.setUserName("seif");
        seif.setPassword("seifmohamed");
        seif.setMobileNumber("01000946346");
        ((bankAccount) seif).setBankAccountID(129);
        seif.setBalance(1000);
        accounts.add(seif);
        //--------------------------------------------------------------------------------------------------------------
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
            if(a instanceof bankAccount &&((bankAccount) a).getBankAccountID() == id)
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
            if(a instanceof bankAccount && ((bankAccount) a).getBankAccountID() == id)
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
            if(a instanceof bankAccount &&((bankAccount) a).getBankAccountID() == id)
            {
                a.setBalance(a.getBalance() - amount);
                break;
            }
        }
    }
}
