package API;

import Database.Account;
import Database.bankAccount;
import Database.database;
import Database.dummyDatabase;

public class BankAPI
{
    //____________________________________________________________________________________
    public static boolean search(String userName, String password, String mobileNumber) {
        for (Account a : dummyDatabase.getAccounts()) {
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
        for (Account a : dummyDatabase.getAccounts()) {
            if (a instanceof bankAccount) {
                bankAccount bankAcc = (bankAccount) a;
                if (bankAcc.getUserName().equals(userName) && bankAcc.getPassword().equals(password) && bankAcc.getMobileNumber().equals(mobileNumber)) {
                    return a;
                }
            }
        }
        return null;
    }
    public static Account getAcc(int ID) {
        for (Account a : dummyDatabase.getAccounts()) {
                if (((bankAccount)a).getBankAccountID()==ID) {
                    return a;
                }
        }
        return null;
    }
}
