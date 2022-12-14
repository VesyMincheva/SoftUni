package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static christmasPastryShop.common.ExceptionMessages.*;

public class BaseBooth implements Booth{
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.numberOfPeople = 0;
        this.pricePerPerson = pricePerPerson;
        this.isReserved = false;
        this.price = 0;
    }

    protected void setCapacity(int capacity) {
        if (capacity < 0){
            throw new IllegalArgumentException (INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    protected void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException (INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        isReserved = true;
        price = this.numberOfPeople * this.pricePerPerson;
    }

    @Override
    public double getBill() {

        return pricePerPerson * numberOfPeople;
    }

    @Override
    public void clear() {
        delicacyOrders.clear();
        cocktailOrders.clear();
        isReserved = false;
        numberOfPeople = 0;
        price = 0;
    }
}
