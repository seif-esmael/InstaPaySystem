package instapaysystem;

import java.util.Vector;
public abstract class dummyDatabase
{
    protected Vector<Account> accounts = new Vector();

    public Vector<Account> getAccounts() {
        return accounts;
    }
    
}
