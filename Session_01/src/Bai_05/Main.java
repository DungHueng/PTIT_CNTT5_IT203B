package Bai_05;

import Bai_03.User;

public class Main {
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-1);
            System.out.println("Tuổi: " + user.getAge());
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
