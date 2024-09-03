package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Page {
//    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    @BeforeGroups
//    public void setup(){
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
//    }

    @Test(groups = {"smoke"}, priority = 100, description = "some description",
    dataProviderClass = NumbersProvider.class, dataProvider = "numbers")
    public void one(int number) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();
        System.out.println("NUMBER = " + number);

        driver.quit();
    }

    @Test(groups = {"regression"}, priority = -10)
    public void two() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();

        Thread.sleep(1000);

        driver.quit();
    }

    @Parameters({"name", "secondName"})
    @Test(groups = {"smoke"}, priority = 1)
    public void api(String name, String secondName) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();

        System.out.println("FULL NAME = " + name + " / " + secondName);
        Thread.sleep(1000);

        driver.quit();
    }

//    @AfterGroups
//    public void teardown(){
//        driver.get().quit();
//    }
}
