/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instapaysystem;

/**
 *
 * @author Seif
 */
public interface InstaPayAPI {
    public void transferInstaPay(int ID,double amount);
    public void addUser(User u);
    public boolean search(String userName,String password);
    public User getUser(String userName,String password);
}
