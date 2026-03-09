package BTTH;

public interface IUserAccount {
    String getRole();

    default boolean checkAccess(){
        return getRole().equals("Admin");
    }
    static boolean isStandardLength(String username){
        return username.length() > 5;
    }
}
