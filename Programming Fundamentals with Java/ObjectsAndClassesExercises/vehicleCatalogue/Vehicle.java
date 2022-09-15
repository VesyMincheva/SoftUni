package vehicleCatalogue;

public class Vehicle {
    private String type;
    private String model;
    private String color;
    private double horsePower;

    public Vehicle(String type, String model, String color, double horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getModel() {
        return this.model;
    }
    public String getType() {
        return this.type;
    }
    public double getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        //Type: {typeOfVehicle}
        //Model: {modelOfVehicle}
        //Color: {colorOfVehicle}
        //Horsepower: {horsepowerOfVehicle}
        String formattedType = "";
        if (this.type.equals("car")) {
            formattedType = "Car";
        } else if (this.type.equals("truck")) {
            formattedType = "Truck";
        }
        return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f", formattedType, this.model, this.color, this.horsePower);
    }

}
