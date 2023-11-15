package Transactions;

import API.*;
import Database.Account;
import Database.bankAccount;
import Database.database;
import Database.walletAccount;
import User.*;

import static API.DatabaseFunctions.getUser;

public class toInstaPayTransfer implements Transfer
{
    @Override
    public boolean transfer(Account acc, int amount, User currentuser)
    {
        if(!database.instaDatabase.checkBalance(currentuser.getInstaID(),amount))
        {
            System.out.println("Your balance is not enough!");
            System.out.println();
            return false;
        }
        database.instaDatabase.removeCredit(currentuser.getInstaID(),amount);
        if(acc instanceof bankAccount)
        {
            BankAPI.addCredit(((bankAccount) acc).getBankAccountID(),amount);
            try
            {
                database.instaDatabase.addCredit(getUser(((bankAccount) acc).getBankAccountID(),"bank").getInstaID(), amount);
            }
            catch(Exception e)
            {

            }
            if(currentuser.getType().equals(userType.instaPayBankUser))
            {
                BankAPI.removeCredit(((instaPayBankUser) currentuser).getBankAccountID(),amount);
                return true;
            }
            else
            {
                WalletAPI.removeCredit(currentuser.getMobileNumber(),amount);
                return true;
            }
        }
        else if(acc instanceof walletAccount)
        {

            WalletAPI.addCredit(acc.getMobileNumber(),amount);
            try
            {
                database.instaDatabase.addCredit(getUser(acc.getMobileNumber()).getInstaID(), amount);
            }
            catch(Exception e)
            {

            }
            if(currentuser.getType().equals(userType.instaPayBankUser))
            {
                BankAPI.removeCredit(((instaPayBankUser) currentuser).getBankAccountID(),amount);
                return true;
            }
            else
            {
                WalletAPI.removeCredit(currentuser.getMobileNumber(),amount);
                return true;
            }
        }
        else
        {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
    }
}
