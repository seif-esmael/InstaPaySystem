package Authentication;

import API.InstaPayAPI;
import Authentication.Register;
import User.User;

public class RegisterContext {
    public Register register;
    public RegisterContext(Register r){
        register = r;
    }


    public void addUser(User myuser)
    {
        InstaPayAPI.addUser(myuser);
    }
}
