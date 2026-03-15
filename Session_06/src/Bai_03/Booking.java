package Bai_03;

public class Booking implements Runnable {
    private String name;
    private TicketPool pool;
    private int soldCount = 0;

    public Booking(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {

        while (true) {

            Ticket ticket = pool.sellTicket();

            if (ticket != null) {

                soldCount++;

                System.out.println(name
                        + " đã bán vé "
                        + ticket.getId());

            } else {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }

            }
        }
    }
}
