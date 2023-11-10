/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instapaysystem;

/**
 *
 * @author Seif
 */
public interface WalletAPI {
    public boolean transferToWallet(String mobileNumber,double amount);
    public boolean search(String mobileNumber);
    public Account getAcc(String mobileNumber);
}
