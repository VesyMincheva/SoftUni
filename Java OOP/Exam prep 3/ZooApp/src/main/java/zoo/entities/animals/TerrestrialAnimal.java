package zoo.entities.animals;

public class TerrestrialAnimal extends BaseAnimal{
    public static final double INITIAL_KG = 5.50;
    public static final double ADDITION_AFTER_EATING = 5.70;

    public TerrestrialAnimal(String name, String kind, double price) {
        super(name, kind, INITIAL_KG, price);
    }

    @Override
    public void eat (){
        setKg(getKg() + ADDITION_AFTER_EATING);
    }
}
