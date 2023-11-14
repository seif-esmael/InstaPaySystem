package instapaysystem;

public class BankAPI
{
    //public boolean transferToBank(int ID,double amount);
    public static boolean search(String userName,String password,String mobileNumber){
        for(Account a : database.bankDatabase.getAccounts())
        {
            if(((bankAccount)a).getUserName().equals(userName) && ((bankAccount)a).getPassword().equals(password) && ((bankAccount)a).getMobileNumber().equals(mobileNumber))
            {
                return true;
            }
        }
        return false;
    }
    public static Account getAcc(String userName,String password,String mobileNumber){
        for(Account a : database.bankDatabase.getAccounts())
        {
            if(((bankAccount)a).getUserName().equals(userName) && ((bankAccount)a).getPassword().equals(password) && ((bankAccount)a).getMobileNumber().equals(mobileNumber))
            {
                return a;
            }
        }
        return null;
    }
}
