package tests.patterns;

import org.testng.Assert;
import org.testng.annotations.Test;
import patterns.AddressBuilder;
import patterns.AddressManager;

public class PatternsTest {

    @Test
    public void builder(){
        String county = "Ukraine";
        String house = "90";
        String apartmentNumber = "1";

        AddressBuilder addressBuilder = new AddressBuilder.Builder()
                .setCountry(county)
                .setHouse("90")
                .setApartmentNumber("1")
                .build();

        Assert.assertEquals(county, addressBuilder.getCountry());
        Assert.assertEquals(house, addressBuilder.getHouse());
        Assert.assertEquals(apartmentNumber, addressBuilder.getApartmentNumber());
    }

    @Test
    public void singleton(){
        AddressManager.getSingleton().addCounter(1);
        Assert.assertEquals(1, AddressManager.getSingleton().getCounter());
    }

    @Test
    public void singleton2(){
        AddressManager.getSingleton().addCounter(1);
        Assert.assertEquals(2, AddressManager.getSingleton().getCounter());
    }
}
