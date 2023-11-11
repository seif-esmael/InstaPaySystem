/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instapaysystem;

/**
 *
 * @author Seif
 */
public class instaPayBankUser extends User
{
    private int bankAccountID;
    //-----------------------------------------
    public boolean pay(double amount)
    {
        bills.clear();
        if(!database.instaDatabase.checkBalance(instaPayID,amount))
        {
            System.out.println("Your balance is not enough!");
            return false;
        }
        balance -= amount;
        database.bankDatabase.removeCredit(bankAccountID,amount);
        return true;
    }
    public boolean withdraw(double amount)
    {
        if(!database.bankDatabase.checkBalance(bankAccountID,amount))
        {
            System.out.println("Your balance is not enough!");
            return false;
        }
        balance -= amount;
        database.bankDatabase.removeCredit(bankAccountID,amount);
        return true;
    }
    public void deposit(double amount)
    {
        super.deposit(amount);
        database.bankDatabase.addCredit(bankAccountID,amount);
    }
    public int getID()
    {
        return bankAccountID;
    }
}
