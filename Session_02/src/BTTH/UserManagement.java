package BTTH;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class UserManagement {
    public User createUser(){
        Supplier<User> handleCreateUser = () -> {
            return new User(
                    "Nguyen Van A",
                    "A123@gmail.com",
                    "User",
                    "ACTIVE"
            );
        };
        return handleCreateUser.get();
    }

    public boolean checkStatusUser(User user){
        Predicate<User> checkStatus = (u) -> u.getStatus().equals("ACTIVE");
        return checkStatus.test(user);
    }
    public String getEmailByUser(User user){
        Function<User, String> getEmail = User::getEmail;
        return getEmail.apply(user);
    }
}
