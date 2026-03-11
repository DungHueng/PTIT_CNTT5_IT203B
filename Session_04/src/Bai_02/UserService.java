package Bai_02;

public class UserService {
    public boolean checkRegistrationAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("Tuổi không được âm");
        }
        if (age >18){
            return true;
        }
        return false;
    }
}
