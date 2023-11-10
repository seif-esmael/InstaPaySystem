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
public class User {
    private String userName;
    private String Password;
    private String mobileNumber;
    private int instaPayID;
    private double balance;
    private Vector<billsPayment> bills = new Vector();
    private userType type;    
    //-------------------------------------------------
    public void payBills(billsPayment bills[])
    {
        
    }
    //-------------------------------------------------
    public void deposit(double amount)
    {
        
    }
    //-------------------------------------------------
    public void withdraw(double amount)
    {
        
    }
    //-------------------------------------------------
    public double getBalance()
    {
        
    }
    //-------------------------------------------------
    public int getInstaID()
    {
        
    }
}
