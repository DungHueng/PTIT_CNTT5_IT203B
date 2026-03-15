package Bai_02;

public class Booking extends Thread {
    private String counterName;
    private TicketPool pool;

    public Booking(String name, TicketPool pool) {
        this.counterName = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            pool.sellTicket(counterName);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
