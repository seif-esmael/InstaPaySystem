package Transactions;

import Database.Account;
import User.*;

public interface Transfer {
    public boolean transfer(Account acc, int amount, User currentuser);

}
