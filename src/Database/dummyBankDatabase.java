package Database;


import java.util.Vector;
public class dummyBankDatabase extends dummyDatabase
{
    dummyBankDatabase()
    {
        //--------------------------------------------------------------------------------------------------------------
        Account kero = new bankAccount();
        kero.setUserName("kirlos");
        kero.setPassword("kirlosnabil");
        kero.setMobileNumber("01234567890");
        kero.setBalance(1500);
        ((bankAccount) kero).setBankAccountID(223);
        accounts.add(kero);
        //--------------------------------------------------------------------------------------------------------------
        Account seif = new bankAccount();
        seif.setUserName("seif");
        seif.setPassword("seifmohamed");
        seif.setMobileNumber("01000946346");
        ((bankAccount) seif).setBankAccountID(129);
        seif.setBalance(1000);
        accounts.add(seif);
        //--------------------------------------------------------------------------------------------------------------
    }

}
