package Transactions;

import Database.Account;
import Database.bankAccount;
import Database.database;
import User.instaPayBankUser;
import User.*;

import static API.InstaPayAPI.getUser;

public class toBankTransfer implements Transfer{
    public boolean transfer(Account acc, int amount, User currentuser)
    {
        if(!database.bankDatabase.checkExistance(((bankAccount) acc).getBankAccountID()))
        {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
        else if(!database.instaDatabase.checkBalance(currentuser.getInstaID(),amount))
        {
            System.out.println("Your balance is not enough!");
            System.out.println();
            return false;
        }
        else {
            database.bankDatabase.removeCredit(((instaPayBankUser) currentuser).getBankAccountID(),amount);
            database.bankDatabase.addCredit(((bankAccount) acc).getBankAccountID(),amount);
            database.instaDatabase.removeCredit(currentuser.getInstaID(),amount);
            try
            {
                database.instaDatabase.addCredit(getUser(acc.getUserName(),acc.getPassword()).getInstaID(), amount);
            }
            catch(Exception e)
            {

            }
            return true;
        }


    }
}


