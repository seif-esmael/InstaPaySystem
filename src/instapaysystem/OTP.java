package instapaysystem;

public interface OTP {
    public int sendOTP();
    public boolean confirm(int userCode,int code);
}
