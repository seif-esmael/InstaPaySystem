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
        this.bills.add(new bill(billType.waterBill));
        this.bills.add(new bill(billType.gasBill));
        this.bills.add(new bill(billType.electricityBill));
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
        database.walletDatabase.removeCredit(mobileNumber,amount);
        bills.clear();
        return true;
    }

}
