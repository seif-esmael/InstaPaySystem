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
public class dummyBankAPI extends dummyDatabase {
    public boolean checkExistance(int id)    
    {
        return true;
    }
    
    public boolean checkBalance(int id,double amount)
    {
        return true;
    }
    
    public void addCredit(int id,double amount)
    {
        
    }
    
    public void removeCredit(int id,double amount)
    {
        
    }
}
