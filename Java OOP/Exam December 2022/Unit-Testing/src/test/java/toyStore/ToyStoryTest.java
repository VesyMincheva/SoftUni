package toyStore;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


public class ToyStoryTest {

    @Test
    public void testConstructor (){
        ToyStore toyStore = new ToyStore();
        Toy toy = toyStore.getToyShelf().get("A");

        Assert.assertNull(toy);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetToyShelf (){
        ToyStore toyStore = new ToyStore();
        Toy toy = new Toy("FisherPrice", "MusicDog");

        Toy toyShelf = toyStore.getToyShelf().put("W", toy);
    }

    @Test
    public void testAddToy () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");

        String resultFromAdding = toyStore.addToy("A", toy1);

        Assert.assertEquals("Toy:MusicDog placed successfully!", resultFromAdding);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddToyAlreadyInTheShelf () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");

        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyInFullShelf () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");
        Toy toy2 = new Toy("Lego", "Constructor");

        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddToyInNoneExistingShelf () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");
        Toy toy2 = new Toy("Lego", "Constructor");

        toyStore.addToy("W", toy1);
        toyStore.addToy("Q", toy2);
    }

    @Test
    public void testRemoveToy () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");
        Toy toy2 = new Toy("Lego", "Constructor");
        Toy toy3 = new Toy("TeddyBears", "Bear");

        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);
        toyStore.addToy("C", toy3);

        String result = toyStore.removeToy("A", toy1);

        Assert.assertNull(toyStore.getToyShelf().get("A"));
        Assert.assertEquals("Remove toy:MusicDog successfully!", result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveToyFromNonExistingShelf () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");
        Toy toy2 = new Toy("Lego", "Constructor");
        Toy toy3 = new Toy("TeddyBears", "Bear");

        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);
        toyStore.addToy("C", toy3);

        toyStore.removeToy("W", toy1);

        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNotExistingToy () throws OperationNotSupportedException {
        ToyStore toyStore = new ToyStore();
        Toy toy1 = new Toy("FisherPrice", "MusicDog");
        Toy toy2 = new Toy("Lego", "Constructor");
        Toy toy3 = new Toy("TeddyBears", "Bear");

        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy2);
        toyStore.addToy("C", toy3);

        toyStore.removeToy("A", toy3);

        Assert.assertNull(toyStore.getToyShelf().get("A"));
    }


}