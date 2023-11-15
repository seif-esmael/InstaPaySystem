package API;

import Database.Account;
import Database.walletAccount;

public class WalletAPI
{
    public boolean transferToWallet(String mobileNumber,double amount)
    {
        return true;
    }
    //_____________________________________________________________________________
    public static boolean search(String mobileNumber) {
        for (Account a : Database.database.walletDatabase.getAccounts()) {
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
        for (Account a : Database.database.walletDatabase.getAccounts()) {
            if (a instanceof walletAccount) {
                walletAccount walletAcc = (walletAccount) a;
                if (walletAcc.getMobileNumber().equals(mobileNumber)) {
                    return a;
                }
            }
        }
        return null;
    }
}