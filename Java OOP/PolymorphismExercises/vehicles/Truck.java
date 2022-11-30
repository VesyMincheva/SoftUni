package vehicles;

public class Truck extends Vehicle {
    public final static double ADDITIONAL_FUEL_CONSUMPTION_FROM_AC = 1.6;
    public final static double FUEL_AFTER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION_FROM_AC);
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters * FUEL_AFTER_DEDUCTION);
    }
}
