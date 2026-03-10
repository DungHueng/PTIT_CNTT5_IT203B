package Bai_03;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    List<User> users = List.of(
            new User("Alice", "alice@gmail.com"),
            new User("Bob", "bob@yahoo.com"),
            new User("Charlie", "charlie@gmail.com")
    );
    Optional<User> findUserName(String username) {
        return users.stream().filter(user -> user.username().equalsIgnoreCase(username)).findFirst();
    }
}
