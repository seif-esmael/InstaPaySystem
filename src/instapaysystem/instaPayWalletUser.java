/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instapaysystem;

/**
 *
 * @author Seif
 */
public class instaPayWalletUser extends User
{
    //-------------------------------------
    public boolean pay(double amount)
    {
        bills.clear();
        if(!database.instaDatabase.checkBalance(instaPayID,amount))
        {
            System.out.println("Your balance is not enough!");
            return false;
        }
        balance -= amount;
        database.walletDatabase.removeCredit(mobileNumber,amount);
        return true;
    }
    @Override
    public boolean withdraw(double amount)
    {
        if(!database.walletDatabase.checkBalance(mobileNumber,amount))
        {
            System.out.println("Your balance is not enough!");
            return false;
        }
        balance -= amount;
        database.walletDatabase.removeCredit(mobileNumber,amount);
        return true;
    }
    public void deposit(double amount)
    {
        super.deposit(amount);
        database.walletDatabase.addCredit(mobileNumber,amount);
    }
}
