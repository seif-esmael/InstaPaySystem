package instapaysystem;
public class instaPayWalletUser extends User
{
    instaPayWalletUser(String username, String password, String mobilenumber, int instapayID, double balance)
    {
        this.userName=username;
        this.password=password;
        this.mobileNumber = mobilenumber;
        this.type = userType.instaPayWalletUser;
        this.instaPayID=instapayID;
        this.bills.add(new waterBill());
        this.bills.add(new gasBill());
        this.bills.add(new electricityBill());
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
        database.walletDatabase.removeCredit(mobileNumber,amount);
        bills.clear();
        return true;
    }

}
