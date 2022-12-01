package vehiclesExtension;

public class Car extends Vehicle {
    public final static double ADDITIONAL_FUEL_CONSUMPTION_FROM_AC = 0.9;

    public Car(double fuelQuantity, double fuelConsumption,double capacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION_FROM_AC, capacity);

    }


}
