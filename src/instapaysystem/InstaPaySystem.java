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
    //------------------------------------------------------------------------------------------------------------------
    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t________________________________");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|  Welcome To InstaPay System  |");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t________________________________");
        while(true)
        {
            if(loggedIn)
            {
                while(true)
                {
                    System.out.println("1- Transfer");
                    System.out.println("2- Inquire about balance");
                    System.out.println("3- Pay bills");
                    System.out.println("4- deposit");
                    System.out.println("5- Withdraw");
                    System.out.println("6- Inquire about my IDs");
                    System.out.println("7- Logout");
                    System.out.println("8- Exit");
                    System.out.print("Your choice: ");
                    String choice = scanner.next();
                    if(choice.equals("1"))
                    {
                        while(true)
                        {
                            if(currentUser.type.equals(userType.instaPayBankUser))
                            {
                                System.out.println("1- Transfer to bank account");
                                System.out.println("2- Transfer to wallet");
                                System.out.println("3- Transfer to InstaPay account");
                                System.out.println("4- Back");
                                System.out.print("Your choice: ");
                                String c = scanner.next();
                                if(c.equals("1"))
                                {
                                    System.out.println();
                                    System.out.print("Enter Bank ID of user you want to transfer to: ");
                                    int id = scanner.nextInt();
                                    System.out.print("Enter amount you want to transfer: ");
                                    int amount = scanner.nextInt();
                                    System.out.println();
                                    if(transferToBank(id,amount))
                                    {
                                        System.out.println("Transfer was successfully done!");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        System.out.println("Transfer couldn't be completed!");
                                        System.out.println();
                                    }
                                }
                                else if(c.equals("2"))
                                {
                                    System.out.println();
                                    System.out.print("Enter mobile number of user you want to transfer to: ");
                                    String mobileNumber = scanner.next();
                                    System.out.print("Enter amount you want to transfer: ");
                                    int amount = scanner.nextInt();
                                    System.out.println();
                                    if(transferToWallet(mobileNumber,amount))
                                    {
                                        System.out.println("Transfer was successfully done!");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        System.out.println("Transfer couldn't be completed!");
                                        System.out.println();
                                    }
                                }
                                else if(c.equals("3"))
                                {
                                    System.out.println();
                                    System.out.print("Enter InstaPay ID of user you want to transfer to: ");
                                    int id = scanner.nextInt();
                                    System.out.print("Enter amount you want to transfer: ");
                                    int amount = scanner.nextInt();
                                    System.out.println();
                                    if(transfertoInstaPay(id,amount))
                                    {
                                        System.out.println("Transfer was successfully done!");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        System.out.println("Transfer couldn't be completed!");
                                        System.out.println();
                                    }
                                }
                                else if(c.equals("4"))
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("Invalid choice!");
                                }
                            }
                            else
                            {
                                System.out.println("1- Transfer to wallet");
                                System.out.println("2- Transfer to InstaPay account");
                                System.out.println("3- Back");
                                System.out.print("Your choice: ");
                                String c = scanner.next();
                                if(c.equals("1"))
                                {
                                    System.out.println();
                                    System.out.print("Enter mobile number of user you want to transfer to: ");
                                    String mobileNumber = scanner.next();
                                    System.out.print("Enter amount you want to transfer: ");
                                    int amount = scanner.nextInt();
                                    System.out.println();
                                    if(transferToWallet(mobileNumber,amount))
                                    {
                                        System.out.println("Transfer was successfully done!");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        System.out.println("Transfer couldn't be completed!");
                                        System.out.println();
                                    }
                                }
                                else if(c.equals("2"))
                                {
                                    System.out.println();
                                    System.out.print("Enter InstaPay ID of user you want to transfer to: ");
                                    int id = scanner.nextInt();
                                    System.out.print("Enter amount you want to transfer: ");
                                    int amount = scanner.nextInt();
                                    System.out.println();
                                    if(transfertoInstaPay(id,amount))
                                    {
                                        System.out.println("Transfer was successfully done!");
                                        System.out.println();
                                    }
                                    else
                                    {
                                        System.out.println("Transfer couldn't be completed!");
                                        System.out.println();
                                    }
                                }
                                else if(c.equals("3"))
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("Invalid choice!");
                                    System.out.println();
                                }
                            }
                        }
                    }
                    else if(choice.equals("2"))
                    {
                        System.out.println();
                        System.out.println("Your current balance is: " + currentUser.getBalance());
                        System.out.println();
                        break;
                    }
                    else if(choice.equals("3"))
                    {
                        while(true)
                        {
                            System.out.println();
                            System.out.println("Your bills are: ");
                            double price = currentUser.printBills();
                            System.out.println("1- Pay");
                            System.out.println("2- Back");
                            System.out.print("Your choice: ");
                            String c = scanner.next();
                            System.out.println();
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
                                System.out.println();
                            }
                        }
                    }
                    else if(choice.equals("4"))
                    {
                        System.out.println();
                        System.out.print("Enter amount you want to deposit: ");
                        int amount = scanner.nextInt();
                        System.out.println();
                        if(deposit(amount))
                        {
                            System.out.println("Deposit successfully done!");
                            System.out.println();
                        }
                        else
                        {
                            System.out.println("Deposit couldn't be done!");
                            System.out.println();
                        }
                    }
                    else if(choice.equals("5"))
                    {
                        System.out.println();
                        System.out.print("Enter amount you want to withdraw: ");
                        int amount = scanner.nextInt();
                        System.out.println();
                        if(withdraw(amount))
                        {
                            System.out.println("Withdraw successfully done!");
                            System.out.println();
                        }
                        else
                        {
                            System.out.println("Withdraw couldn't be done!");
                            System.out.println();
                        }
                    }
                    else if(choice.equals("6"))
                    {
                        System.out.println();
                        System.out.println("Your InstaPay ID: " + currentUser.getInstaID());
                        System.out.println();
                        if(currentUser.type.equals(userType.instaPayBankUser))
                        {
                            System.out.println("Your Bank ID: " + ((instaPayBankUser) currentUser).getBankAccountID());
                            System.out.println();
                        }
                    }
                    else if(choice.equals("7"))
                    {
                        loggedIn = false;
                        currentUser = null;
                        System.out.println();
                        System.out.println("Logged out!");
                        System.out.println();
                        break;
                    }
                    else if(choice.equals("8"))
                    {
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Invalid Choice!");
                        System.out.println();
                    }
                }
            }
            else
            {
                while(true)
                {
                    if(loggedIn)
                    {
                        break;
                    }
                    System.out.println();
                    System.out.println("1- Register");
                    System.out.println("2- Sign In");
                    System.out.println("3- Exit");
                    System.out.print("Your choice: ");
                    String choice = scanner.next();
                    System.out.println();
                    if(choice.equals("1"))
                    {
                        User u = register();
                        if(u != null)
                        {
                            addUser(u);
                        }
                        break;
                    }
                    else if(choice.equals("2"))
                    {
                        User u = signIn();
                        if(u != null)
                        {
                            currentUser = u;
                        }
                        break;
                    }
                    else if(choice.equals("3"))
                    {
                        System.exit(0);
                    }
                    else
                    {
                        System.out.println("Invalid Choice!");
                        System.out.println();
                    }
                }
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public User register()
    {
        Scanner data = new Scanner(System.in);
        System.out.println();
        System.out.println("1- Register using your bank account\n2- Register using your eWallet\n");
        System.out.print("Your choice: ");
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
                System.out.println("Welcome!");
                System.out.println("Please enter enter your new account data!");
                System.out.println();
                System.out.print("Enter Email: ");
                email = data.next();
                System.out.println();
                //-----------------------------------------------------
                System.out.print("Enter Password: ");
                password = data.next();
                System.out.println();
                double bank_balance = (getAcc(bank_email,bank_password,bank_phone_number)).getBalance();
                int bank_ID = ((bankAccount)getAcc(bank_email,bank_password,bank_phone_number)).getBankAccountID();

                instaPayBankUser myuser = new instaPayBankUser(email,password,bank_phone_number,idsforusers++,bank_balance,bank_ID);
                System.out.println("Your new account has been created!");
                System.out.println();
                return myuser;
            }
            else
            {
                System.out.println("User not found in bank!");
                System.out.println();
            }

        }
        else if(choice.equals("2"))
        {
            System.out.println();
            String eWallet_phone_number, email, password;
            System.out.print("Enter your eWallet Phone number: ");
            eWallet_phone_number = data.next();
            System.out.println();
            if(search(eWallet_phone_number))
            {
                System.out.println("Welcome!");
                System.out.println("Please enter enter your new account data!");
                System.out.println();
                System.out.print("Enter Email: ");
                email = data.next();
                System.out.println();
                //-----------------------------------------------------
                System.out.print("Enter Password: ");
                password = data.next();
                System.out.println();
                double ewallet_balance = (getAcc(eWallet_phone_number)).getBalance();
                instaPayWalletUser myuser = new instaPayWalletUser(email,password,eWallet_phone_number,idsforusers++,ewallet_balance);
                System.out.println("Your new account has been created!");
                System.out.println();
                return myuser;
            }
            else
            {
                System.out.println("User not found in eWallet!");
                System.out.println();
            }
        }
        else
        {
            System.out.println("Invalid Choice!");
            System.out.println();
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------
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
            System.out.println();
            loggedIn = true;
            System.out.println("Logged in!");
            System.out.println();
            return getUser(email,password);
        }
        else
        {
            System.out.println("Invalid email or password!");
            System.out.println();
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------        
    // **This Section for InstaPayAPI**    
    @Override
    public boolean transfertoInstaPay(int ID, double amount)
    {
        if(!database.instaDatabase.checkExistance(ID))
        {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
        if(!database.instaDatabase.checkBalance(currentUser.getInstaID(),amount))
        {
            System.out.println("Your balance is not enough!");
            System.out.println();
            return false;
        }
        if(getUser(ID,"insta").type.equals(userType.instaPayBankUser))
        {
            database.bankDatabase.addCredit(ID,amount);
        }
        else
        {
            database.walletDatabase.addCredit(getUser(ID,"insta").mobileNumber,amount);
        }
        if(currentUser.type.equals(userType.instaPayBankUser))
        {
            database.bankDatabase.removeCredit(((instaPayBankUser) currentUser).getBankAccountID(),amount);
        }
        else
        {
            database.walletDatabase.removeCredit(currentUser.mobileNumber,amount);
        }
        database.instaDatabase.addCredit(ID,amount);
        database.instaDatabase.removeCredit(currentUser.getInstaID(),amount);
        return true;
    }
    
    @Override
    public void addUser(User u) {
        database.instaDatabase.adduser(u);
    }
    
    @Override
    public boolean search(String userName, String password) {
        for(User u : database.instaDatabase.getUsers())
        {
            if(u.userName.equals(userName) && u.password.equals(password))
            {
                return true;
            }            
        }
        return false;
    }
    
    @Override
    public User getUser(String userName, String password) {
        for(User u : database.instaDatabase.getUsers())
        {
            if(u.userName.equals(userName) && u.password.equals(password))
            {
                return u;
            }            
        }
        return null;
    }
    
    public User getUser(String mobileNumber) {
        for(User u : database.instaDatabase.getUsers())
        {
            if(u.mobileNumber.equals(mobileNumber))
            {
                return u;
            }            
        }
        return null;
    }
    
    public User getUser(int ID, String which)
    {
        if(which.equals("insta"))
        {
            for(User u : database.instaDatabase.getUsers())
            {
                if(u.instaPayID == ID)
                {
                    return u;
                }
            }
            return null;
        }
        else
        {
            for(User u : database.instaDatabase.getUsers())
            {
                if(((instaPayBankUser) u).getBankAccountID() == ID)
                {
                    return u;
                }
            }
            return null;
        }
    }
    
    @Override
    public boolean deposit(double amount)
    {
        database.instaDatabase.addCredit(currentUser.instaPayID, amount);
        if(currentUser.type.equals(userType.instaPayBankUser))
        {
            database.bankDatabase.addCredit(((instaPayBankUser)currentUser).getBankAccountID(), amount);            
        }
        else
        {
            database.walletDatabase.addCredit(currentUser.mobileNumber, amount);
        }
        return true;
    }
    
    public boolean withdraw(double amount)
    {
        if(!database.instaDatabase.checkBalance(currentUser.getInstaID(), amount))
        {
            return false;
        }
        database.instaDatabase.removeCredit(currentUser.instaPayID, amount);
        if(currentUser.type.equals(userType.instaPayBankUser))
        {
            database.bankDatabase.removeCredit(((instaPayBankUser)currentUser).getBankAccountID(), amount);            
        }
        else
        {
            database.walletDatabase.removeCredit(currentUser.mobileNumber, amount);
        }
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------
    // **This Section for WalletAPI**
    @Override
    public boolean transferToWallet(String mobilenumber, double amount)
    {
        if(!database.walletDatabase.checkExistance(mobilenumber))
        {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
        if(currentUser.type.equals(userType.instaPayBankUser))
        {
            if(!database.bankDatabase.checkBalance(((instaPayBankUser) currentUser).getBankAccountID(),amount))
            {
                System.out.println("Your balance is not enough!");
                System.out.println();
                return false;
            }
            database.bankDatabase.removeCredit(((instaPayBankUser) currentUser).getBankAccountID(),amount);
        }
        else
        {
            if(!database.walletDatabase.checkBalance(currentUser.mobileNumber,amount))
            {
                System.out.println("Your balance is not enough!");
                System.out.println();
                return false;
            }
            database.walletDatabase.removeCredit(currentUser.mobileNumber,amount);
        }
        database.walletDatabase.addCredit(mobilenumber,amount);
        if(database.instaDatabase.checkExistance(getUser(mobilenumber).getInstaID()))
        {
            database.instaDatabase.addCredit(getUser(mobilenumber).getInstaID(),amount);
        }
        database.instaDatabase.removeCredit(currentUser.getInstaID(),amount);
        return true;
    }
    
    @Override
    public boolean search(String mobileNumber) {
        for(Account a : database.walletDatabase.getAccounts())
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Account getAcc(String mobileNumber) {
        for(Account a : database.walletDatabase.getAccounts())
        {
            if(((walletAccount) a).getMobileNumber().equals(mobileNumber))            
            {
                return a;
            }
        }
        return null;
    }    
    //------------------------------------------------------------------------------------------------------------------  
    // **This Section for BankAPI** 
    @Override
    public boolean transferToBank(int ID, double amount)
    {
        if(!database.bankDatabase.checkExistance(ID))
        {
            System.out.println("Couldn't find the user you want to transfer to!");
            System.out.println();
            return false;
        }
        if(!database.bankDatabase.checkBalance(((instaPayBankUser)currentUser).getBankAccountID(),amount))
        {
            System.out.println("Your balance is not enough!");
            System.out.println();
            return false;
        }
        database.bankDatabase.addCredit(ID,amount);
        database.bankDatabase.removeCredit(((instaPayBankUser) currentUser).getBankAccountID(),amount);
        database.instaDatabase.addCredit(getUser(ID,"bank").getInstaID(),amount);
        database.instaDatabase.removeCredit(currentUser.getInstaID(),amount);
        return true;
    }
    
    @Override
    public boolean search(String userName, String password, String mobileNumber) {
        for(Account a : database.bankDatabase.getAccounts())
        {
            if(((bankAccount)a).getUserName().equals(userName) && ((bankAccount)a).getPassword().equals(password) && ((bankAccount)a).getMobileNumber().equals(mobileNumber))
            {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Account getAcc(String userName, String password, String mobileNumber)
    {
        for(Account a : database.bankDatabase.getAccounts())
        {
            if(((bankAccount)a).getUserName().equals(userName) && ((bankAccount)a).getPassword().equals(password) && ((bankAccount)a).getMobileNumber().equals(mobileNumber))
            {
                return a;
            }
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------------------------         
}
