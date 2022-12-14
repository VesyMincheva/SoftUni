package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.List;
import java.util.stream.Collectors;

import static christmasPastryShop.common.ExceptionMessages.*;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private String type;
    private String name;
    private double price;
    private double totalIncome;
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = null;


        if (delicacyRepository.getByName(name) != null){
            String error = String.format(FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException (error);
        }else {
            if (type.equals("Gingerbread")){
                delicacy = new Gingerbread(name, price);
            }else if (type.equals("Stolen")){
                delicacy = new Stolen(name, price);
            }
        }

        delicacyRepository.add(delicacy);

        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = null;
        if (cocktailRepository.getByName(name) != null){
            String error = String.format(FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException (error);
        }else {
            if (type.equals("Hibernation")){
                cocktail = new Hibernation(name, size, brand);
            }else if (type.equals("MulledWine")){
                cocktail = new MulledWine(name, size, brand);
            }
        }

        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = null;
        if (boothRepository.getByNumber(boothNumber) != null){
            String error = String.format(BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException (error);
        }else {
            if (type.equals("OpenBooth")){
                booth = new OpenBooth(boothNumber, capacity);
            } else if (type.equals("PrivateBooth")) {
                booth = new PrivateBooth(boothNumber, capacity);
            }
        }

        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        List<Booth> freeBooths = boothRepository.getAll()
                .stream().filter(b -> !b.isReserved()).collect(Collectors.toList());
        Booth freeBoothWithEnoughCapacity = freeBooths.stream()
                .filter(b -> b.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);

        String message = null;
        if (freeBoothWithEnoughCapacity == null){
            message = String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }else {
            freeBoothWithEnoughCapacity.reserve(numberOfPeople);
            message = String.format(BOOTH_RESERVED, freeBoothWithEnoughCapacity.getBoothNumber(), numberOfPeople);
        }

        return message;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        booth.clear();
        totalIncome += bill;


        return String.format(BILL, boothNumber, bill);
    }

    @Override
    public String getIncome() {
        //TODO
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
