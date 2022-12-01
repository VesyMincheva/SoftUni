package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    public final static double ADDITIONAL_FUEL_CONSUMPTION_FROM_AC = 1.4;
    public Bus(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption, capacity);
    }
    @Override
    public String drive (double distance){
        setFuelConsumption(getFuelConsumption() + ADDITIONAL_FUEL_CONSUMPTION_FROM_AC);
        String result = super.drive(distance);
        setFuelConsumption(getFuelConsumption() - ADDITIONAL_FUEL_CONSUMPTION_FROM_AC);
        return result;
    }

    public String driveEmpty (double distance){
        return super.drive(distance);
    }
}
