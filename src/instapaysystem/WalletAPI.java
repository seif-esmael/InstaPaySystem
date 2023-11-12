package instapaysystem;

public interface WalletAPI
{
    public boolean transferToWallet(String mobileNumber,double amount);
    public boolean search(String mobileNumber);
    public Account getAcc(String mobileNumber);
}
