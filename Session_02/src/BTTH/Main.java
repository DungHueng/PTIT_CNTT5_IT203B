package BTTH;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        User TranB = userManagement.createUser();

        String username = TranB.getUsername();

        boolean isUserName = IUserAccount.isStandardLength(username);
        System.out.println(isUserName);

        String email = userManagement.getEmailByUser(TranB);
        System.out.println(email);

        User nguyenA = new User(
                "Nguyen Van A",
                "A456@gmail.com",
                "SubAdmin",
                "ACTIVE"
        );

        User LeC = new User(
                "Le Hoang C",
                "C123@gmail.com",
                "User",
                "ACTIVE"
        );

        List<User> users = new ArrayList<>(List.of(nguyenA, LeC));
        users.forEach(System.out::println);
    }
}
