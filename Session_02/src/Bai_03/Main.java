package Bai_03;

import Bai_01.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("123456");
        System.out.println("Mật khẩu hợp lệ: " + user.isAuthenticated());
        String encrypted = Authenticatable.encrypt("123456");
        System.out.println("Mật khẩu sau khi mã hóa: " + encrypted);
    }
}
