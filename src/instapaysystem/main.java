package instapaysystem;

import java.util.Vector;

class database
{
    public static final dummyInstaPayDatabase instaDatabase = new dummyInstaPayDatabase();
    public static final dummyWalletDatabase walletDatabase = new dummyWalletDatabase();
    public static final dummyBankDatabase bankDatabase = new dummyBankDatabase();
}
public class main
{
    public static void main(String[] args)
    {
        InstaPaySystem i = new InstaPaySystem();
        i.run();
    }
}
