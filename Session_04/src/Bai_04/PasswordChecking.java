package Bai_04;

public class PasswordChecking {
    public String passwordCheck(String password) {
        if (password.length() < 8 || password == null) {
            throw new IllegalArgumentException("Weak password");
        }
        boolean UpperCasePassword = password.matches(".*[A-Z].*");
        boolean LowerCasePassword = password.matches(".*[a-z].*");
        boolean NumberPassword = password.matches(".*[0-9].*");
        boolean SpecialPassword = password.matches(".*[^a-zA-Z0-9].*");

        if  (UpperCasePassword || LowerCasePassword || NumberPassword || SpecialPassword) {
            return "Medium password";
        }
        if  (UpperCasePassword && LowerCasePassword && NumberPassword && SpecialPassword) {
            return "Strong password";
        }
        return "Weak password";
    }
}
