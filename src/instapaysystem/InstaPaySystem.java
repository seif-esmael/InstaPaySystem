/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package instapaysystem;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Seif
 */
public class InstaPaySystem implements WalletAPI , InstaPayAPI , BankAPI {
    private User currentUser;
    private boolean loggedIn;
    
    //------------------------------------------        
    public void run()
    {        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t***Welcome To InstaPay System***");
        System.out.println("\t\t\t\t________________________________");
        //------                        
        if(loggedIn)
        {
            
        }
        else
        {
            while(true)
            {
                System.out.println("1- Register");
                System.out.println("2- Sign In"); 
                String choice = scanner.next();
                if(choice.equals("1")) 
                {
                    register();                    
                    break;
                }
                else if(choice.equals("2"))
                {
                    currentUser = signIn();                
                    break;
                }
                else
                {
                    System.out.println("Invalid Choice!");
                }
            }
        }                                
    }
    //------------------------------------------
    public User register()
    {
        
    }
    
    public User signIn()
    {
        
    }
    
    @Override
    public boolean transferToWallet(String mobileNumber, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean search(String mobileNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account getAcc(String mobileNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void transferInstaPay(int ID, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addUser(User u) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean search(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUser(String userName, String password) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean transferToWallet(int ID, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean search(String userName, String password, String mobileNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account getAcc(String userName, String password, String mobileNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //---------------------------------------------------------------
    public static void main(String[] args) {
        // TODO code application logic here        
        InstaPaySystem i = new InstaPaySystem();
        i.run();
    }        
}
