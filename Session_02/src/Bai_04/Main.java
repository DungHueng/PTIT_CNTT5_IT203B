package Bai_04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("NguyenA"));
        users.add(new User("TranB"));
        users.add(new User("LeC"));

        Function<User, String> layUsername = User::getUsername;

        System.out.println("Danh sách username:");
        users.stream().map(layUsername).forEach(System.out::println);

        Consumer<String> inChuoi = System.out::println;
        inChuoi.accept("Xin chào Java Method Reference");
        Supplier<User> taoUser = User::new;
        User userMoi = taoUser.get();
        System.out.println("User mới: " + userMoi.getUsername());
    }
}
