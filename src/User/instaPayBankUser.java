package User;

import Bills.Bill;
import Bills.billType;

public class instaPayBankUser extends User
{
    public static String get;
    private int bankAccountID;
    //______________________________________________________________________________
    public instaPayBankUser(String username, String password, String mobilenumber, int instapayID, double balance, int bankID)
    {
        this.userName=username;
        this.password=password;
        this.mobileNumber = mobilenumber;
        this.type = userType.instaPayBankUser;
        this.instaPayID=instapayID;
        this.bills.add(new Bill(billType.waterBill));
        this.bills.add(new Bill(billType.gasBill));
        this.bills.add(new Bill(billType.electricityBill));
        this.bankAccountID = bankID;
        this.balance = balance;
    }    
    //______________________________________________________________________________
    public int getBankAccountID()
    {
        return bankAccountID;
    }
}
