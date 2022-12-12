package zoo.entities.areas;

import zoo.entities.animals.BaseAnimal;

public class WaterArea extends BaseArea {
    public static final int CAPACITY = 10;

    public WaterArea(String name) {
        super(name, CAPACITY);
    }

}
