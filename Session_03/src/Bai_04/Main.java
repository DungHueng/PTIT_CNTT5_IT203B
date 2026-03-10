package Bai_04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Nguyen Van A");
        User user2 = new User("Nguyen Van A");
        User user3 = new User("Tran Thi B");
        User user4 = new User("Le Thanh C");

        List<User> users = List.of(user1, user2, user3, user4);
        List<User> uniqueUsers = new ArrayList<>(
            users.stream()
                    .collect(Collectors.toMap(User::username, u -> u,
                            (existing, replacement) -> existing
                    ))
                    .values()
        );
        uniqueUsers.forEach(System.out::println);
    }
}
