package Transactions;
import Database.Account;
import Database.database;
import User.userType;

import Database.bankAccount;
import Database.walletAccount;
import User.*;

import static API.DatabaseFunctions.getUser;

public class toWalletTransfer implements Transfer{
    @Override
    public boolean transfer(Account acc, int amount, User currentuser)
    {
        if(acc instanceof walletAccount)
        {
            if(!database.walletDatabase.checkExistance(acc.getMobileNumber()))
            {
                System.out.println("Couldn't find the user you want to transfer to!");
                System.out.println();
                return false;
            }
            if(!database.instaDatabase.checkBalance(currentuser.getInstaID(),amount))
            {
                System.out.println("Your balance is not enough!");
                System.out.println();
                return false;
            }
            database.walletDatabase.addCredit(acc.getMobileNumber(),amount);
            database.instaDatabase.removeCredit(currentuser.getInstaID(),amount);
            if(currentuser.getType() == userType.instaPayWalletUser)
            {
                database.walletDatabase.removeCredit(currentuser.getMobileNumber(),amount);
            }
            else if(currentuser.getType() ==userType.instaPayBankUser)
            {
                database.bankDatabase.removeCredit(((instaPayBankUser) currentuser).getBankAccountID(),amount);
            }
            try
            {
                database.instaDatabase.addCredit(getUser(acc.getMobileNumber()).getInstaID(), amount);
            }
            catch(Exception e)
            {

            }
            return true;
        }
        else if(acc instanceof bankAccount)
        {
            return false;
        }
        else
        {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
    }
}
