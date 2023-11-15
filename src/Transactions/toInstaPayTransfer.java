package Transactions;

import Database.Account;
import Database.bankAccount;
import Database.database;
import Database.walletAccount;
import User.instaPayWalletUser;
import User.*;

import static API.InstaPayAPI.getUser;

public class toInstaPayTransfer implements Transfer {

    @Override
    public boolean transfer(Account acc, int amount, User currentuser) {
        if ((database.bankDatabase.checkExistance(((bankAccount) acc).getBankAccountID()))) {
            if(!database.instaDatabase.checkBalance(currentuser.getInstaID(),amount))
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
                    database.instaDatabase.addCredit(getUser(((bankAccount) acc).getBankAccountID(),"bank").getInstaID(), amount);
                }
                catch(Exception e)
                {

                }
                return true;
            }

        } else if ((database.walletDatabase.checkExistance(((walletAccount) acc).getMobileNumber()))) {
            if(!database.instaDatabase.checkBalance(currentuser.getInstaID(),amount))
            {
                System.out.println("Your balance is not enough!");
                System.out.println();
                return false;
            }
            else {
                database.walletDatabase.removeCredit(currentuser.getMobileNumber(),amount);
                database.walletDatabase.addCredit(acc.getMobileNumber(),amount);
                database.instaDatabase.removeCredit(currentuser.getInstaID(),amount);
                try
                {
                    database.instaDatabase.addCredit(getUser(acc.getMobileNumber()).getInstaID(), amount);
                }
                catch(Exception e)
                {

                }
            }
            return true;

        } else {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
    }

}
