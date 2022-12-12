package zoo.entities.animals;

public class AquaticAnimal extends BaseAnimal{
    public static final double INITIAL_KG = 2.50;
    public static final double ADDITION_AFTER_EATING = 7.50;

    public AquaticAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KG, price);
    }

    @Override
    public void eat (){
        setKg(getKg() + ADDITION_AFTER_EATING);
    }
}
