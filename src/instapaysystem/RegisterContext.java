package instapaysystem;

public class RegisterContext {
    public Register register;
    RegisterContext(Register r){
        register = r;
    }


    public void addUser(User myuser)
    {
        InstaPayAPI.addUser(myuser);
    }
}
