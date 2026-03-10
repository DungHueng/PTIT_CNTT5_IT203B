package Bai_03;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.findUserName("Alice")
                .ifPresentOrElse(user -> System.out.println("Welcome " + user.username()),
                () -> System.out.println("Guest login"));
    }
}
