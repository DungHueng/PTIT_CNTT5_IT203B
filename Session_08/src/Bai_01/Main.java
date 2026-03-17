package Bai_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Function> devices = new ArrayList<>();

        Singleton connection = null;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");
            System.out.println("----------------");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    connection = Singleton.getInstance();
                    break;

                case 2:
                    System.out.println("Chọn loại:");
                    System.out.println("1. Đèn");
                    System.out.println("2. Quạt");
                    System.out.println("3. Điều hòa");
                    int type = sc.nextInt();

                    DeviceFactory factory = null;

                    switch (type) {
                        case 1: factory = new LightFactory(); break;
                        case 2: factory = new FanFactory(); break;
                        case 3: factory = new AirConditionerFactory(); break;
                        default:
                            System.out.println("Không hợp lệ!");
                            continue;
                    }

                    Function device = factory.createDevice();
                    devices.add(device);
                    break;

                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1) + ". Device " + (i + 1));
                    }

                    System.out.print("Chọn: ");
                    int onIndex = sc.nextInt() - 1;
                    devices.get(onIndex).turnOn();
                    break;

                case 4:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1) + ". Device " + (i + 1));
                    }

                    System.out.print("Chọn: ");
                    int offIndex = sc.nextInt() - 1;
                    devices.get(offIndex).turnOff();
                    break;

                case 5:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}
