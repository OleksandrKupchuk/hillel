package tests.ui.steps.definitions;

import ui.browserfactory.BrowserFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ui.pages.theinternet.MainPage;

public class LoginDefinition {
    private WebDriver driver = BrowserFactory.getInstance().getDriver();
    private MainPage mainPage;

    public LoginDefinition(){
        mainPage = new MainPage();
    }

    @When("[UI] User login with username")
    public void login(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
    }

    @Then("[UI] User should be on main page")
    public void uiUserShouldBeOnMainPage() {
        mainPage.assertTitle();
    }

    @When("\\[UI] User login with username (.*) and (.*)$")
    public void login(String username, String password) {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("radius")).click();
    }
}
