package Bai_02;

public class Main {
    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");

        roomA.addTickets(2, "A");
        roomB.addTickets(5, "B");

        Booking counter1 = new Booking("Quầy 1", roomA);
        Booking counter2 = new Booking("Quầy 2", roomB);

        TicketSupplier supplier = new TicketSupplier(roomA);

        counter1.start();
        counter2.start();
        supplier.start();
    }
}
