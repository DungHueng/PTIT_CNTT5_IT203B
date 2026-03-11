package Bai_03;

public class EmailChecking {
    public String checkEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";

        if(email == null || !email.matches(regex)){
            throw new IllegalArgumentException("--- Sai dinh dang email ---");
        }

        return email.toLowerCase();
    }
}
