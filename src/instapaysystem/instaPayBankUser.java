/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instapaysystem;

import java.util.Random;

/**
 *
 * @author Seif
 */
public class instaPayBankUser extends User
{
    private int bankAccountID;
    //-----------------------------------------
    instaPayBankUser(String username, String password, String mobilenumber, int instapayID, double balance, int bankID)
    {
        this.userName=username;
        this.password=password;
        this.mobileNumber = mobilenumber;
        this.type = userType.instaPayBankUser;
        this.instaPayID=instapayID;
        this.bills.add(new waterBill());
        this.bills.add(new gasBill());
        this.bills.add(new electricityBill());
        this.bankAccountID = bankID;
        this.balance = balance;

    }
    public boolean pay(double amount)
    {
        if(!database.instaDatabase.checkBalance(instaPayID,amount))
        {
            System.out.println("Your balance is not enough!");
            return false;
        }
        balance -= amount;
        database.bankDatabase.removeCredit(bankAccountID,amount);
        bills.clear();
        return true;
    }
    public int getBankAccountID()
    {
        return bankAccountID;
    }
}
