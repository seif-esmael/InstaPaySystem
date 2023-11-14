package instapaysystem;

public class WalletAPI
{
    //public boolean transferToWallet(String mobileNumber,double amount);
    public static boolean search(String mobileNumber){
        for(Account a : database.walletDatabase.getAccounts())
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                return true;
            }
        }
        return false;
    }
    public static Account getAcc(String mobileNumber){
        for(Account a : database.walletDatabase.getAccounts())
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                return a;
            }
        }
        return null;
    }
}
