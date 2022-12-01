package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double capacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double capacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setCapacity(capacity);
    }

    public String drive (double distance){
        double fuelNeeded = distance * getFuelConsumption();
        if (fuelNeeded > getFuelQuantity()){
            return this.getClass().getSimpleName() + " needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));

    };
    void refuel (double litters){
        if (litters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (litters + fuelQuantity > capacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += litters;
    };

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {

        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}
