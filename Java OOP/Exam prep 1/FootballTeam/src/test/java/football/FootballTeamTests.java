package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    @Test
    public void testFootballTeamCreateTeam (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);

        Assert.assertEquals("ManUtd", footballTeam.getName());
        Assert.assertEquals(10, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class )
    public void testFootballTeamWithNullNameShouldThrow (){
        FootballTeam footballTeam = new FootballTeam(null, 10);

        Assert.assertEquals(null, footballTeam.getName());
    }

    @Test(expected = NullPointerException.class )
    public void testFootballTeamWithEmptyNameShouldThrow (){
        FootballTeam footballTeam = new FootballTeam("   ", 10);

        Assert.assertEquals(null, footballTeam.getName());
    }

    @Test(expected = IllegalArgumentException.class )
    public void testFootballTeamSetVacantPositionsAreNegativeShouldThrow (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", -10);

        Assert.assertEquals(-10, footballTeam.getVacantPositions());
    }

    @Test
    public void testGetCountReturnFootballersCount (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);

        Assert.assertEquals(0, footballTeam.getCount());
        Footballer footballer1 = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Rooney");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        Assert.assertEquals(2, footballTeam.getCount());

    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFootballerWithNoCapacityShouldThrow (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 2);
        Footballer footballer1 = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Rooney");
        Footballer footballer3 = new Footballer("Beckham");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
    }

    @Test
    public void testRemoveFootballerShouldRemove (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);
        Footballer footballer1 = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Rooney");
        Footballer footballer3 = new Footballer("Beckham");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        Assert.assertEquals(3, footballTeam.getCount());
        footballTeam.removeFootballer("Rooney");
        Assert.assertEquals(2, footballTeam.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFootballerIfNotInTeamShouldThrow (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);
        Footballer footballer1 = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Rooney");
        Footballer footballer3 = new Footballer("Beckham");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        footballTeam.removeFootballer("Messi");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldThrow (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);
        Footballer footballer1 = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Rooney");
        Footballer footballer3 = new Footballer("Beckham");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        footballTeam.footballerForSale("Messi");
    }

    @Test
    public void testFootballerForSaleShouldSetActive (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);
        Footballer footballer1 = new Footballer("Ronaldo");
        Footballer footballer2 = new Footballer("Rooney");
        Footballer footballer3 = new Footballer("Beckham");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);

        Footballer footballer = footballTeam.footballerForSale("Ronaldo");

        Assert.assertFalse(footballer.isActive());
    }

    @Test
    public void testGetStatistics (){
        FootballTeam footballTeam = new FootballTeam("ManUtd", 10);
        Footballer footballer1 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer1);

        Assert.assertEquals("The footballer Ronaldo is in the team ManUtd.", footballTeam.getStatistics());
    }



}
