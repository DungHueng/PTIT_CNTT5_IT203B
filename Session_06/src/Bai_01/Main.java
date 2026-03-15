package Bai_01;

public class Main {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");

        roomA.addTicket(new Ticket("A-001"));
        roomA.addTicket(new Ticket("A-002"));

        roomB.addTicket(new Ticket("B-001"));
        roomB.addTicket(new Ticket("B-002"));

        Booking counter1 = new Booking(
                "Quầy 1", roomA, roomB);

        Booking counter2 = new Booking(
                "Quầy 2", roomB, roomA);
        counter1.start();
        counter2.start();
    }
}
