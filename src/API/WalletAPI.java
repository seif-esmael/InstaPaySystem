package API;

import Database.Account;
import Database.walletAccount;
import Database.database;
import Database.dummyDatabase;

public class WalletAPI
{
    public boolean transferToWallet(String mobileNumber,double amount)
    {
        return true;
    }
    //_____________________________________________________________________________
    public static boolean search(String mobileNumber) {
        for (Account a : database.walletDatabase.getAccounts()) {
            if (a instanceof walletAccount) {
                walletAccount walletAcc = (walletAccount) a;
                if (walletAcc.getMobileNumber().equals(mobileNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
    //_____________________________________________________________________________    
    public static Account getAcc(String mobileNumber) {
        for (Account a : database.walletDatabase.getAccounts()) {
            if (a instanceof walletAccount) {
                walletAccount walletAcc = (walletAccount) a;
                if (walletAcc.getMobileNumber().equals(mobileNumber)) {
                    return a;
                }
            }
        }
        return null;
    }
    public static void removeCredit(String mobileNumber, double amount)
    {
        for(Account a : database.walletDatabase.getAccounts())
        {
            if(a instanceof walletAccount && ((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                ((walletAccount) a).setBalance(((walletAccount) a).getBalance() - amount);
                break;
            }
        }
    }

    public static void addCredit(String mobileNumber, double amount)
    {
        for(Account a : database.walletDatabase.getAccounts())
        {
            if(a instanceof walletAccount && ((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                ((walletAccount) a).setBalance(((walletAccount) a).getBalance() + amount);
                break;
            }
        }
    }
}
