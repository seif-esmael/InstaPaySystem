package API;

import Database.Account;
import Database.bankAccount;
import Database.database;
public class BankAPI
{
    public static boolean transferToBank(int id,double amount)
    {
        return true;
    }
    //____________________________________________________________________________________
    public static boolean search(String userName, String password, String mobileNumber) {
        for (Account a : database.bankDatabase.getAccounts()) {
            if (a instanceof bankAccount) {
                bankAccount bankAcc = (bankAccount) a;
                if (bankAcc.getUserName().equals(userName) && bankAcc.getPassword().equals(password) && bankAcc.getMobileNumber().equals(mobileNumber)) {
                    return true;
                }
            }
        }
        return false;
    }
    //____________________________________________________________________________________
    public static Account getAcc(String userName, String password, String mobileNumber) {
        for (Account a : database.bankDatabase.getAccounts()) {
            if (a instanceof bankAccount) {
                bankAccount bankAcc = (bankAccount) a;
                if (bankAcc.getUserName().equals(userName) && bankAcc.getPassword().equals(password) && bankAcc.getMobileNumber().equals(mobileNumber)) {
                    return a;
                }
            }
        }
        return null;
    }
}
