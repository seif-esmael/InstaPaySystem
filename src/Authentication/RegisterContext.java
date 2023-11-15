package Authentication;

import API.DatabaseFunctions;
import User.User;

public class RegisterContext {
    public Register register;
    public RegisterContext(Register r){
        register = r;
    }


    public void addUser(User myuser)
    {
        DatabaseFunctions.addUser(myuser);
    }
}
