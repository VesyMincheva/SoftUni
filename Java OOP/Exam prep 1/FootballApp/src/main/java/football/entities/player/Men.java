package football.entities.player;

public class Men extends BasePlayer{

    public static final double INITIAL_KG = 60;
    public static final int ADDITIONAL_STRENGTH = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, INITIAL_KG, strength);
    }


    @Override
    public void stimulation() {
        this.setStrength(getStrength() + ADDITIONAL_STRENGTH);
    }

}
