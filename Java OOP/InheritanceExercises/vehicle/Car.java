package vehicle;

public class Car extends Vehicle{
    public final static double DEFAULT_FUEL_CONSUMPTION = 3.00;
    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
