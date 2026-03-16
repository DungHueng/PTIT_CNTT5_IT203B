package Bai_04;

import Bai_03.CardPayable;

public class EmailService implements NotificationService {
    @Override
    public void send(String message, String recipient) {
        System.out.println("Gửi email: " + message);
    }
}
