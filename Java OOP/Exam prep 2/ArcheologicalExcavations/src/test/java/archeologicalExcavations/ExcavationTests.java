package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {

    @Test
    public void testCreateExcavation (){
        Excavation excavation = new Excavation("Pazardjik", 10);
        Assert.assertEquals(excavation.getName(), "Pazardjik");
        Assert.assertEquals(excavation.getCapacity(), 10);
    }

    @Test (expected = NullPointerException.class)
    public void testCreateExcavationShouldThrowNullName (){
        Excavation excavation = new Excavation(null, 10);
        Assert.assertEquals(excavation.getName(), "Pazardjik");
        Assert.assertEquals(excavation.getCapacity(), 10);
    }

    @Test (expected = NullPointerException.class)
    public void testCreateExcavationShouldThrowEmptyName (){
        Excavation excavation = new Excavation("    ", 10);
        Assert.assertEquals(excavation.getName(), "Pazardjik");
        Assert.assertEquals(excavation.getCapacity(), 10);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateExcavationShouldThrowNegativeCapacity (){
        Excavation excavation = new Excavation("Pazardjik", -10);
        Assert.assertEquals(excavation.getName(), "Pazardjik");
        Assert.assertEquals(excavation.getCapacity(), 10);
    }

    @Test
    public void testAddArcheologistShouldCreate(){
        Excavation excavation = new Excavation("Pazardvik", 10);
        Archaeologist archaeologist = new Archaeologist("Pesho", 200);
        Assert.assertEquals(excavation.getCount(), 0);
        excavation.addArchaeologist(archaeologist);
        Assert.assertEquals(excavation.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistShouldThrowNoCapacity(){
        Excavation excavation = new Excavation("Pazardvik", 2);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 200);
        Archaeologist archaeologist2 = new Archaeologist("Tosho", 100);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 300);
        Assert.assertEquals(excavation.getCount(), 0);
        excavation.addArchaeologist(archaeologist1);
        Assert.assertEquals(excavation.getCount(), 1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddArcheologistShouldThrowNullArcheologist(){
        Excavation excavation = new Excavation("Pazardvik", 10);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 200);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 500);
        Assert.assertEquals(excavation.getCount(), 0);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);

    }

    @Test
    public void testRemoveShouldRemove(){
        Excavation excavation = new Excavation("Pazardvik", 111);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 200);
        Archaeologist archaeologist2 = new Archaeologist("Tosho", 100);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 300);
        Assert.assertEquals(excavation.getCount(), 0);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        Assert.assertEquals(excavation.getCount(), 3);
        Assert.assertTrue(excavation.removeArchaeologist("Pesho"));
        Assert.assertEquals(excavation.getCount(), 2);
    }

    @Test
    public void testRemoveShouldNotRemove(){
        Excavation excavation = new Excavation("Pazardvik", 111);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 200);
        Archaeologist archaeologist2 = new Archaeologist("Tosho", 100);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 300);
        Assert.assertEquals(excavation.getCount(), 0);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        Assert.assertEquals(excavation.getCount(), 3);
        Assert.assertFalse(excavation.removeArchaeologist("Gogo"));
        Assert.assertEquals(excavation.getCount(), 3);
    }
}
