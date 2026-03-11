package Bai_01;

public class UserValidator {
    public boolean isValidUserName(String userName){
        if(userName == null){
            return false;
        }
        if(userName.length() < 6 || userName.length() > 20){
            return false;
        }
        if(userName.contains("  ")){
            return false;
        }
        return true;
    }
}
