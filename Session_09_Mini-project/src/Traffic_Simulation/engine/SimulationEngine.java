package Traffic_Simulation.engine;

import Traffic_Simulation.entity.Vehicle;
import Traffic_Simulation.pattern.VehicleFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationEngine {

    public void startSimulation() {

        Intersection intersection = new Intersection();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            Vehicle vehicle = VehicleFactory.createRandomVehicle(intersection);
            executor.submit(vehicle);
        }

        executor.shutdown();
    }
}