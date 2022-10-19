package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> pets;

    public Clinic(int capacity) {
        this.capacity = capacity;
        pets = new ArrayList<>();
    }

    public void add(Pet pet){
        if (pets.size() < capacity){
            pets.add(pet);
        }
    }

    public boolean remove (String name){
        Pet petToRemove = pets.stream().filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (petToRemove != null){
            pets.remove(petToRemove);
            return true;
        }
        return false;
    }

    public Pet getPet (String name, String owner){
        return pets.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet (){
        return pets.stream().max((f, s) -> f.getAge() - s.getAge()).orElse(null);
    }

    public int getCount(){
        return pets.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet pet : pets) {
            sb.append(pet.getName() + " " + pet.getOwner()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
