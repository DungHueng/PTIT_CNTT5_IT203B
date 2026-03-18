package Traffic_Simulation.pattern;

import Traffic_Simulation.entity.PriorityVehicle;
import Traffic_Simulation.entity.StandardVehicle;
import Traffic_Simulation.entity.Vehicle;
import Traffic_Simulation.engine.Intersection;

import java.util.Random;

public class VehicleFactory {

    private static int counter = 0;

    public static Vehicle createRandomVehicle(Intersection intersection) {

        Random random = new Random();
        counter++;

        int type = random.nextInt(4);

        switch (type) {
            case 0:
                return new StandardVehicle("Motorbike-" + counter, 60, intersection);

            case 1:
                return new StandardVehicle("Car-" + counter, 50, intersection);

            case 2:
                return new StandardVehicle("Truck-" + counter, 40, intersection);

            default:
                return new PriorityVehicle("Ambulance-" + counter, 80, intersection);
        }
    }
}