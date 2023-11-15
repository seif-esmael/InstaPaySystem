package Database;

import java.util.Vector;
public abstract class dummyDatabase
{
    protected static Vector<Account> accounts = new Vector();

    public static Vector<Account> getAccounts() {
        return accounts;
    }
    
}
