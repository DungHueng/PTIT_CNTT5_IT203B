package Traffic_Simulation.engine;

import Traffic_Simulation.entity.Vehicle;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {

    private ReentrantLock lock = new ReentrantLock();

    public void enterIntersection(Vehicle vehicle) {
        try {
            lock.lock();
            System.out.println(vehicle.getClass().getSimpleName()
                    + " " + vehicle.getId() + " is crossing intersection");

            Thread.sleep(1000);

            System.out.println(vehicle.getId() + " exited intersection");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}