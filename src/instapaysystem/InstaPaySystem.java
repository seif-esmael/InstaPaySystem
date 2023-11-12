package instapaysystem;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InstaPaySystem implements WalletAPI , InstaPayAPI , BankAPI
{
    private User currentUser;
    private int idsforusers = 100;
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
                        User u = register();
                        if(u != null)
                        {
                            addUser(register());
                        }
                        break;
                    }
                    else if(choice.equals("2"))
                    {
                        User u = signIn();
                        if(u != null)
                        {
                            currentUser = signIn();
                        }
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
        Scanner data = new Scanner(System.in);
        System.out.println("1-)Register using your bank account\n2-)Register using your eWallet\n");
        String choice = data.next();
        if (choice.equals("1"))
        {
            String bank_email, bank_password, bank_phone_number, email, password;

            System.out.print("Enter the Bank's Email: ");
            bank_email = data.next();
            System.out.println();
            //-----------------------------------------------------
            System.out.print("Enter the Bank's Password: ");
            bank_password = data.next();
            System.out.println();
            //-----------------------------------------------------
            System.out.print("Enter the Bank's Phone number: ");
            bank_phone_number = data.next();
            System.out.println();
            if(search(bank_email,bank_password,bank_phone_number))
            {
                System.out.print("Enter Email: ");
                email = data.next();
                System.out.println();
                //-----------------------------------------------------
                System.out.print("Enter Password: ");
                password = data.next();
                System.out.println();
                double bank_balance = ((bankAccount)getAcc(bank_email,bank_password,bank_phone_number)).getBalance();
                int bank_ID = ((bankAccount)getAcc(bank_email,bank_password,bank_phone_number)).getBankAccountID();

                instaPayBankUser myuser = new instaPayBankUser(email,password,bank_phone_number,idsforusers++,bank_balance,bank_ID);
                return myuser;
            }
            else
            {
                System.out.println("User not found in bank!");
            }

        }
        else if(choice.equals("2"))
        {
            String eWallet_phone_number, email, password;
            System.out.print("Enter your eWallet Phone number: ");
            eWallet_phone_number = data.next();
            System.out.println();
            if(search(eWallet_phone_number))
            {
                System.out.print("Enter Email: ");
                email = data.next();
                System.out.println();
                //-----------------------------------------------------
                System.out.print("Enter Password: ");
                password = data.next();
                System.out.println();
                double ewallet_balance = ((walletAccount)getAcc(eWallet_phone_number)).getBalance();
                instaPayWalletUser myuser = new instaPayWalletUser(email,password,eWallet_phone_number,idsforusers++,ewallet_balance);
                return myuser;
            }
            else
            {
                System.out.println("User not found in eWallet!");
            }
        }
        else
        {
            System.out.println("Invalid Choice!");
        }
        return null;
    }
    public User signIn()
    {
        Scanner data = new Scanner(System.in);
        String email, password;
        System.out.print("Enter Email: ");
        email = data.next();
        System.out.println();
        //-----------------------------------------------------
        System.out.print("Enter Password: ");
        password = data.next();
        System.out.println();
        if(search(email,password))
        {
            return getUser(email,password);
        }
        else
        {
            System.out.println("Invalid email or password!");
        }
        return null;
    }
    @Override
    public boolean transferToBank(int ID, double amount) {
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
    public void transfertoInstaPay(int ID, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addUser(User u) {
        database.instaDatabase.adduser(u);
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
    public boolean transferToWallet(String mobilenumber, double amount) {
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
