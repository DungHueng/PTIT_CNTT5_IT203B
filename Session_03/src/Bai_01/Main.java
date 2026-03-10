package Bai_01;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Alice",  "alice123@gmail.com", "ACTIVE");
        User bob = new User("Bob",  "bobo3@gmail.com", "INACTIVE");
        User charlie = new User("Charlie",  "chara367@gmail.com", "ACTIVE");

        List<User> users = List.of(alice, bob, charlie);
        users.forEach(System.out::println);
    }
}
