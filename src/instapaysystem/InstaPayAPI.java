package instapaysystem;

public interface InstaPayAPI
{
    public boolean transfertoInstaPay(int ID,double amount);
    public User getUser(int ID, String which);
    public User getUser(String mobileNumber);
    public void addUser(User u);
    public boolean search(String userName,String password);
    public User getUser(String userName,String password);
}
