package Transactions;

import Database.Account;
import Database.bankAccount;
import Database.database;
import Database.walletAccount;
import User.*;

import static API.DatabaseFunctions.getUser;

public class toBankTransfer implements Transfer
{
    @Override
    public boolean transfer(Account acc, int amount, User currentuser)
    {
        if(acc instanceof bankAccount)
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
            database.instaDatabase.removeCredit(currentuser.getInstaID(),amount);
            database.bankDatabase.addCredit(((bankAccount) acc).getBankAccountID(),amount);
            if(currentuser.getType().equals(userType.instaPayBankUser))
            {
                database.bankDatabase.removeCredit(((instaPayBankUser) currentuser).getBankAccountID(),amount);
            }
            else
            {
                Database.dummyWalletDatabase.removeCredit(currentuser.getMobileNumber(),amount);
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
        else if(acc instanceof walletAccount)
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


