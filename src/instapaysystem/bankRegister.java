package instapaysystem;

import java.util.Random;
import java.util.Scanner;

import static instapaysystem.BankAPI.getAcc;
import static instapaysystem.InstaPayAPI.getUser;
import static instapaysystem.InstaPayAPI.search;

public class bankRegister implements OTP,Register
{
    public User registeration(int idsforusers)
    {
        String bank_email, bank_password, bank_phone_number, email, password;
        Scanner data = new Scanner(System.in);
        System.out.print("Enter the Bank's Username: ");
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
        if(BankAPI.search(bank_email,bank_password,bank_phone_number))
        {
            if(getUser(((bankAccount)getAcc(bank_email,bank_password,bank_phone_number)).getBankAccountID(),"bank") != null)
            {
                System.out.println();
                System.out.println("You are already registered!");
                System.out.println();
                return getUser(((bankAccount)getAcc(bank_email,bank_password,bank_phone_number)).getBankAccountID(),"bank");
            }
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
            double bank_balance = (getAcc(bank_email,bank_password,bank_phone_number)).getBalance();
            int bank_ID = ((bankAccount)getAcc(bank_email,bank_password,bank_phone_number)).getBankAccountID();

            instaPayBankUser myuser = new instaPayBankUser(email,password,bank_phone_number,idsforusers,bank_balance,bank_ID);
            System.out.println("Your new account has been created!");
            System.out.println();
            return myuser;
        }
        else
        {
            System.out.println("User not found in bank!");
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
