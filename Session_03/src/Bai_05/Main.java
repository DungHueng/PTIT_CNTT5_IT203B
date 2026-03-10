package Bai_05;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User u1 = new User("alexander");
        User u2 = new User("alice");
        User u3 = new User("bob");
        User u4 = new User("charlotte");
        User u5 = new User("Benjamin");

        List<User> users = List.of(u1, u2, u3, u4, u5);
        users.stream()
                .sorted(Comparator.comparing((User u) -> u.username().length()).reversed())
                .limit(3)
                .forEach(u -> System.out.println(u.username()));

    }
}
