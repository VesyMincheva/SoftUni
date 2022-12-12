package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.*;

public abstract class BaseArea implements Area {
    private String name;
    private int capacity;
    private Collection<Food> foods;
    private List<Animal> animals;

    public BaseArea(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException (AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return animals;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }

    @Override
    public int sumCalories() {
        int sum = foods.stream().mapToInt(Food::getCalories).sum();
        return sum;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animals.size() >= capacity){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", name, this.getClass().getSimpleName()))
                .append(System.lineSeparator());
        if (animals.isEmpty()){
            sb.append("Animals: none");
        }else {
            String animalsLine = animals.stream().map(Animal::getName).collect(Collectors.joining(" "));
            sb.append("Animals: ").append(animalsLine);
//            for (Animal animal : animals) {
//                sb.append(animal.getName() + " ");
//            }
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Foods: %d", foods.size()))
                .append(System.lineSeparator());
        sb.append(String.format("Calories: %d", sumCalories()));
        return sb.toString();
    }
}
