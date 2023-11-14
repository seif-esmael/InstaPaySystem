package instapaysystem;

import java.util.Random;

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
        this.bills.add(new bill(billType.waterBill));
        this.bills.add(new bill(billType.gasBill));
        this.bills.add(new bill(billType.electricityBill));
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
        if(bills.size() == 0)
        {
            System.out.println("There is no bills!");
            return true;
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
