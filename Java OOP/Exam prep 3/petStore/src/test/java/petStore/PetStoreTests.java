package petStore;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PetStoreTests {

    @Test
    public void testAddAnimalShouldAdd (){
        PetStore petStore = new PetStore();
        Animal dog = new Animal("Dingo", 20, 100);
        Animal cat = new Animal("Tom", 10, 200);
        Animal fish = new Animal("Gold", 1, 50);
        Assert.assertEquals(0, petStore.getCount());
        petStore.addAnimal(dog);
        petStore.addAnimal(cat);
        petStore.addAnimal(fish);
        Assert.assertEquals(3, petStore.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddAnimalWithNullName (){
        PetStore petStore = new PetStore();
        Animal dog = null;

        Assert.assertEquals(0, petStore.getCount());
        petStore.addAnimal(dog);

    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetCollectionReturnUnmodifiableCollection (){
        PetStore petStore = new PetStore();
        Animal dog = new Animal("Dingo", 20, 100);
        Animal cat = new Animal("Tom", 10, 200);
        Animal fish = new Animal("Gold", 1, 50);

        petStore.addAnimal(dog);
        petStore.addAnimal(cat);
        petStore.addAnimal(fish);

        petStore.getAnimals().add(2, dog);

        Assert.assertEquals(3, petStore.getCount());
    }

    @Test
    public void testFindAllAnimalsWithMaxKilograms (){
        PetStore petStore = new PetStore();
        Animal dog = new Animal("Dingo", 20, 100);
        Animal cat = new Animal("Tom", 10, 200);
        Animal fish = new Animal("Gold", 1, 50);
        Animal wolf = new Animal("Ghost", 50, 2000);

        petStore.addAnimal(dog);
        petStore.addAnimal(cat);
        petStore.addAnimal(fish);
        petStore.addAnimal(wolf);

        List<Animal> maxKgAnimals = petStore.findAllAnimalsWithMaxKilograms(40);

        Assert.assertEquals(1, maxKgAnimals.size());
        Assert.assertEquals(wolf, maxKgAnimals.get(0));

    }

    @Test
    public void testFindMostExpensiveAnimal (){
        PetStore petStore = new PetStore();
        Animal dog = new Animal("Dingo", 20, 100);
        Animal cat = new Animal("Tom", 10, 200);
        Animal fish = new Animal("Gold", 1, 50);
        Animal wolf = new Animal("Ghost", 50, 2000);

        petStore.addAnimal(dog);
        petStore.addAnimal(cat);
        petStore.addAnimal(fish);
        petStore.addAnimal(wolf);

        Animal animal = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals(wolf, animal);

    }

    @Test
    public void testFindAllAnimalsWithSameSpecie (){
        PetStore petStore = new PetStore();
        Animal dog = new Animal("Dingo", 20, 100);
        Animal cat = new Animal("Tom", 10, 200);
        Animal fish = new Animal("Gold", 1, 50);
        Animal wolf = new Animal("Tom", 50, 2000);

        petStore.addAnimal(dog);
        petStore.addAnimal(cat);
        petStore.addAnimal(fish);
        petStore.addAnimal(wolf);

        List<Animal> animals = petStore.findAllAnimalBySpecie("Tom");

        Assert.assertEquals(2, animals.size());
        Assert.assertEquals(wolf, animals.get(1));

    }
}

