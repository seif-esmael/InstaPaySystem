/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package instapaysystem;

import java.util.Vector;

/**
 *
 * @author Seif
 */
public class dummyWalletDatabase extends dummyDatabase {        
    public boolean checkExistance(String mobileNumber)    
    {
        return true;
    }
    
    public boolean checkBalance(String mobileNumber,double balance)
    {
        return true;
    }
    
    public void addCredit(String mobileNumber,double amount)
    {
        
    }
    
    public void removeCredit(String mobileNumber,double amount)
    {
        
    }
}
