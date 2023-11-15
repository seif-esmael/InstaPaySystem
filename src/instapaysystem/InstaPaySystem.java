package instapaysystem;

import API.BankAPI;
import API.DatabaseFunctions;
import API.WalletAPI;
import Authentication.RegisterContext;
import Bills.billsPayment;
import Bills.Bill;
import Database.database;
import Transactions.Transfer;
import Transactions.TransferFactory;
import User.instaPayBankUser;
import User.User;
import User.userType;
import Authentication.bankRegister;
import Authentication.siginIn;
import Authentication.walletRegister;
import java.util.Scanner;
import java.util.Vector;
import static API.DatabaseFunctions.*;

public class InstaPaySystem implements siginIn
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
                            if(currentUser.getType().equals(userType.instaPayBankUser))
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
                                    TransferFactory transferfactory = new TransferFactory();
                                    Transfer transfer = transferfactory.createTransferTransaction("tobank");

                                    if(transfer.transfer(BankAPI.getAcc(id),amount,currentUser))
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

                                    TransferFactory transferfactory = new TransferFactory();
                                    Transfer transfer = transferfactory.createTransferTransaction("towallet");

                                    if(transfer.transfer(WalletAPI.getAcc(mobileNumber),amount,currentUser))
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

                                    TransferFactory transferfactory = new TransferFactory();
                                    Transfer transfer = transferfactory.createTransferTransaction("toinstapay");

                                    if(DatabaseFunctions.getUser(id,"insta")!=null)
                                    {
                                        if (((DatabaseFunctions.getUser(id, "insta")).getType() == userType.instaPayBankUser)) {
                                            if (transfer.transfer(BankAPI.getAcc(((instaPayBankUser) DatabaseFunctions.getUser(id, "insta")).getBankAccountID()), amount, currentUser)) {
                                                System.out.println("Transfer was successfully done!");
                                                System.out.println();
                                            } else {
                                                System.out.println("Transfer couldn't be completed!");
                                                System.out.println();
                                            }
                                        }
                                        else if(((DatabaseFunctions.getUser(id, "insta")).getType() == userType.instaPayWalletUser)){
                                            if(transfer.transfer(WalletAPI.getAcc(getUser(id, "insta").getMobileNumber()),amount,currentUser))
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
                                    }
                                    else
                                    {
                                        System.out.println("Couldn't find the user you want to transfer to!");
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
                                    TransferFactory transferfactory = new TransferFactory();
                                    Transfer transfer = transferfactory.createTransferTransaction("towallet");

                                    if(transfer.transfer(WalletAPI.getAcc(mobileNumber),amount,currentUser))
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
                                    TransferFactory transferfactory = new TransferFactory();
                                    Transfer transfer = transferfactory.createTransferTransaction("toinstapay");

                                    if(DatabaseFunctions.getUser(id,"insta")!=null)
                                    {
                                        if (((DatabaseFunctions.getUser(id, "insta")).getType() == userType.instaPayBankUser)) {
                                            if (transfer.transfer(BankAPI.getAcc(((instaPayBankUser)getUser(id,"insta")).getBankAccountID()), amount, currentUser)) {
                                                System.out.println("Transfer was successfully done!");
                                                System.out.println();
                                            } else {
                                                System.out.println("Transfer couldn't be completed!");
                                                System.out.println();
                                            }
                                        }
                                        else if(((DatabaseFunctions.getUser(id, "insta")).getType() == userType.instaPayWalletUser)){
                                            if(transfer.transfer(WalletAPI.getAcc(getUser(id, "insta").getMobileNumber()),amount,currentUser))
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
                                    }
                                    else {
                                        System.out.println("Couldn't find the user you want to transfer to!");
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
                            currentUser.seeBills();
                            System.out.println("1- Pay");
                            System.out.println("2- Back");
                            System.out.print("Your choice: ");
                            String c = scanner.next();
                            System.out.println();
                            Vector <billsPayment> spare = currentUser.getBills();
                            if(c.equals("1"))
                            {
                                if(spare.isEmpty())
                                {
                                    System.out.println("You have no bills to pay!");
                                }
                                else
                                {
                                    System.out.print("Enter the number of bill you want to pay: ");
                                    int ccc = scanner.nextInt();
                                    if(ccc > spare.size() || ccc <= 0)
                                    {
                                        System.out.println("Invalid index!");
                                    }
                                    else if(((Bill)spare.elementAt(ccc-1)).getAmount() > currentUser.getBalance())
                                    {
                                        System.out.println("Your balance is not enough!");
                                    }
                                    else if(((Bill)spare.elementAt(ccc-1)).getStatus())
                                    {
                                        System.out.println("You already paid it!");
                                    }
                                    else
                                    {
                                        database.instaDatabase.removeCredit(currentUser.getInstaID(),((Bill)spare.elementAt(ccc-1)).getAmount());
                                        if(currentUser.getType().equals(userType.instaPayBankUser))
                                        {
                                            BankAPI.removeCredit(((instaPayBankUser)currentUser).getBankAccountID(),((Bill)spare.elementAt(ccc-1)).getAmount());
                                        }
                                        else
                                        {
                                            WalletAPI.removeCredit(currentUser.getMobileNumber(),((Bill)spare.elementAt(ccc-1)).getAmount());
                                        }
                                        spare.elementAt(ccc-1).pay();
                                    }
                                }
                                currentUser.setBills(spare);
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
                        if(deposit(amount,currentUser))
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
                        if(withdraw(amount,currentUser))
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
                        if(currentUser.getType().equals(userType.instaPayBankUser))
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
                        Scanner data = new Scanner(System.in);
                        System.out.println();
                        System.out.println("1- Register using your bank account\n2- Register using your eWallet\n");
                        System.out.print("Your choice: ");
                        String choice2 = data.next();
                        if (choice2.equals("1"))
                        {
                            RegisterContext context = new RegisterContext(new bankRegister());
                            User myuser = context.register.registeration(idsforusers++);
                            if(myuser!=null)
                            {
                                context.addUser(myuser);
                            }
                        }
                        else if(choice2.equals("2")) {
                            RegisterContext context = new RegisterContext(new walletRegister());
                            User myuser = context.register.registeration(idsforusers++);
                            if(myuser!=null)
                            {
                                context.addUser(myuser);
                            }
                        }
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
}
