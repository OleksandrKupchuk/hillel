package tests.ui;

import org.testng.annotations.DataProvider;

public class NumbersProvider {
    @DataProvider
    public Object[][] numbers() {
        return new Object [][] {
                {1},
                {2},
                {3}
        };
    }

    @DataProvider
    public Object[][] floats() {
        return new Object [][] {
                {1},
                {2},
                {3}
        };
    }
}
