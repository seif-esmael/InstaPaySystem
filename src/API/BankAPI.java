package API;

import Database.Account;
import Database.bankAccount;
import Database.database;
import Database.dummyDatabase;

public class BankAPI
{
    //____________________________________________________________________________________
    public static boolean search(String userName, String password, String mobileNumber) {
        for (Account a : Database.database.bankDatabase.getAccounts()) {
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
    public static Account getAcc(int ID) {
        for (Account a : database.bankDatabase.getAccounts()) {
            if (a instanceof bankAccount) {
                bankAccount bankAcc = (bankAccount) a;
                if (bankAcc.getBankAccountID() == ID) {
                    return a;
                }
            }
        }
        return null;
    }

    public static boolean checkExistance(int id)
    {
        for(Account a :  database.bankDatabase.getAccounts())
        {
            if(a instanceof bankAccount)
            {
                if(((bankAccount) a).getBankAccountID() == id)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkBalance(int id, double amount)
    {
        for(Account a :  database.bankDatabase.getAccounts())
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
    public static void addCredit(int id, double amount)
    {
        for(Account a :  database.bankDatabase.getAccounts())
        {
            if(a instanceof bankAccount && ((bankAccount) a).getBankAccountID() == id)
            {
                a.setBalance(a.getBalance() + amount);
                break;
            }
        }
    }
    public static void removeCredit(int id, double amount)
    {
        for(Account a :  database.bankDatabase.getAccounts())
        {
            if(a instanceof bankAccount &&((bankAccount) a).getBankAccountID() == id)
            {
                a.setBalance(a.getBalance() - amount);
                break;
            }
        }
    }
}
