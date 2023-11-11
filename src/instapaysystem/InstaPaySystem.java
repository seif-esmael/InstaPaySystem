package instapaysystem;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InstaPaySystem implements WalletAPI , InstaPayAPI , BankAPI
{
    private User currentUser;
    private boolean loggedIn = false;
    //------------------------------------------        
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t________________________________");
        System.out.println("\t\t\t\t---Welcome To InstaPay System---");
        System.out.println("\t\t\t\t________________________________");
        while(true)
        {
            if(loggedIn)
            {
                while(true)
                {
                    System.out.println("1- Transfer");
                    System.out.println("2- Inquire about balance");
                    System.out.println("3- Pay bills");
                    String choice = scanner.next();
                    if(choice.equals("1"))
                    {

                    }
                    else if(choice.equals("2"))
                    {
                        System.out.println("Your current balance is: " + currentUser.getBalance());
                        break;
                    }
                    else if(choice.equals("3"))
                    {
                        while(true)
                        {
                            System.out.println("Your bills are: ");
                            double price = currentUser.printBills();
                            System.out.println("1- Pay");
                            System.out.println("2- Back");
                            String c = scanner.next();
                            if(c.equals("1"))
                            {
                                currentUser.pay(price);
                            }
                            else if(c.equals("2"))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("Invalid Choice!");
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Choice!");
                    }
                }
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
    }
    //------------------------------------------
    public User register()
    {
        return new instaPayBankUser();
    }
    public User signIn()
    {
        return new instaPayBankUser();
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

}
