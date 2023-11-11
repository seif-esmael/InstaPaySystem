/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package instapaysystem;

public interface InstaPayAPI {
    public void transfertoInstaPay(int ID,double amount);
    public void addUser(User u);
    public boolean search(String userName,String password);
    public User getUser(String userName,String password);
}
