package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.Map;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Map<String, Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new LinkedHashMap<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")){
            area = new WaterArea(areaName);

        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);

        }else {
            throw new NullPointerException (INVALID_AREA_TYPE);
        }


        areas.put(areaName, area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")){
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        }else {
            throw new IllegalArgumentException (INVALID_FOOD_TYPE);
        }

        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food foodForArea = foodRepository.findByType(foodType);
        if (foodForArea == null){
            String error = String.format(NO_FOOD_FOUND, foodType);
            throw new IllegalArgumentException (error);
        }else {
            areas.get(areaName).addFood(foodForArea);
            foodRepository.remove(foodForArea);
            return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
        }
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;
        if (animalType.equals("AquaticAnimal")){
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        }else {
            throw new IllegalArgumentException (INVALID_ANIMAL_TYPE);
        }

        if (areas.get(areaName).getClass().getSimpleName().equals("WaterArea") && animalType.equals("AquaticAnimal")){
            areas.get(areaName).addAnimal(animal);
            return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else if (areas.get(areaName).getClass().getSimpleName().equals("LandArea") && animalType.equals("TerrestrialAnimal")) {
            areas.get(areaName).addAnimal(animal);
            return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        }else {
            return String.format(AREA_NOT_SUITABLE);
        }

    }

    @Override
    public String feedAnimal(String areaName) {
        areas.get(areaName).feed();
        return String.format(ANIMALS_FED, areas.get(areaName).getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        double value = areas.get(areaName).getAnimals().stream()
                .mapToDouble(Animal::getKg).sum();

        return String.format(KILOGRAMS_AREA, areaName, value);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area entry : areas.values()) {
            sb.append(entry.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
