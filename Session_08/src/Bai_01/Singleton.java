package Bai_01;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("--- Đã kết nối phần cứng ---");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void disconnect() {
        System.out.println("--- Đã ngắt kết nối ---");
    }
}
