package Authentication;

import API.WalletAPI;
import API.DatabaseFunctions;
import User.User;
import User.instaPayWalletUser;
import java.util.Random;
import java.util.Scanner;

import static API.DatabaseFunctions.getUser;
import static API.DatabaseFunctions.search;

public class walletRegister implements OTP, Register
{
    @Override
    public User registeration(int idsforusers)
    {
        Scanner data = new Scanner(System.in);
        System.out.println();
        String eWallet_phone_number, email, password;
        System.out.print("Enter your eWallet Phone number: ");
        eWallet_phone_number = data.next();
        System.out.println();
            while(true)
            {
                int otp = sendOTP();
                System.out.print("Enter the OTP sent to your registered phone number: ");
                int inputOTP = data.nextInt();
                if (confirm(otp,inputOTP)) {
                    System.out.println("OTP confirmed successfully!");
                    break;
                } else {
                    System.out.println("OTP confirmation failed, Try again");
                }
            }
        if(getUser(eWallet_phone_number) != null)
        {
            System.out.println();
            System.out.println("You already registered!");
            System.out.println();
            return DatabaseFunctions.getUser(eWallet_phone_number);
        }
        if(WalletAPI.search(eWallet_phone_number))
        {
            System.out.println("Welcome!");
            System.out.println("Please enter enter your new account data!");
            while(true)
            {
                System.out.println();
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
                    System.out.println("Email is already taken!");
                    System.out.println();
                }
                else
                {
                    break;
                }
            }
            double ewallet_balance = (WalletAPI.getAcc(eWallet_phone_number)).getBalance();
            instaPayWalletUser myuser = new instaPayWalletUser(email,password,eWallet_phone_number,idsforusers,ewallet_balance);
            System.out.println("Your new account has been created!");
            System.out.println();
            return myuser;
        }
        else
        {
            System.out.println("User not found in eWallet!");
            System.out.println();
        }
        return null;
    }

    @Override
    public int sendOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000);
        System.out.println("OTP sent to the user: " + otp);
        return otp;
    }

    @Override
    public boolean confirm(int usercode, int code) {
        if (usercode == code) {
            return true;
        }
        return false;
    }
}
