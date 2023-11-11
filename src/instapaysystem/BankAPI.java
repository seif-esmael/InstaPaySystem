/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instapaysystem;

/**
 *
 * @author Seif
 */
public interface BankAPI {
    public boolean transferToBank(int ID,double amount);
    public boolean search(String userName,String password,String mobileNumber);
    public Account getAcc(String userName,String password,String mobileNumber);
}
