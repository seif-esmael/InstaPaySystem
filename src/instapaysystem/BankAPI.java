package instapaysystem;

public interface BankAPI
{
    public boolean transferToBank(int ID,double amount);
    public boolean search(String userName,String password,String mobileNumber);
    public Account getAcc(String userName,String password,String mobileNumber);
}
