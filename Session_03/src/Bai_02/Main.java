package Bai_02;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice", "alice@gmail.com");
        User bob = new User("Bob", "bob@yahoo.com");
        User charlie = new User("Charlie", "charlie@gmail.com");

        List<User> users = Arrays.asList(alice, bob, charlie);
        users.stream().filter(user -> user.email()
                .endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.username()));
    }
}
