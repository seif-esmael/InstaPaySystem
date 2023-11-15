package User;

import Bills.Bill;
import Bills.billType;
//import instapaysystem.database;

public class instaPayWalletUser extends User
{
    public instaPayWalletUser(String username, String password, String mobilenumber, int instapayID, double balance)
    {
        this.userName=username;
        this.password=password;
        this.mobileNumber = mobilenumber;
        this.type = userType.instaPayWalletUser;
        this.instaPayID=instapayID;
        this.bills.add(new Bill(billType.waterBill));
        this.bills.add(new Bill(billType.gasBill));
        this.bills.add(new Bill(billType.electricityBill));
        this.balance = balance;
    }
}
