package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import ui.wait.WaitHelper;

public class Page {

    @Test(groups = {"smoke"})
    public void login() {
        String expectedResult = "Secure Area";

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        WebElement title =  driver.findElement(By.xpath("//h2"));
        Assert.assertEquals(title.getText(), expectedResult);

        driver.quit();
    }

    @Test
    public void selectValueFromDropdown(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        String option1Name = "Option 1";
        int indexOption1Value = 1;
        String expectedResult = setDropdownValue(driver, indexOption1Value).getText();
        Assert.assertEquals(option1Name, expectedResult);

        driver.quit();
    }

    public WebElement setDropdownValue(WebDriver driver, int value){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByIndex(value);
        return select.getFirstSelectedOption();
    }

    @Test
    public void checkStatusCode(){
        BrowserMobProxy browserMobProxy = new BrowserMobProxyServer();
        browserMobProxy.start(0);

        Proxy proxy = ClientUtil.createSeleniumProxy(browserMobProxy);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.setProxy(proxy);

        ChromeDriver driver = new ChromeDriver(options);
        browserMobProxy.newHar();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        Har har = browserMobProxy.getHar();

        har.getLog().getEntries().forEach(harEntry -> {
            if (harEntry.getRequest().getUrl().contains("/authenticate")){
                Assert.assertEquals(harEntry.getResponse().getStatus(), 303);
            }
        });

        browserMobProxy.stop();
        driver.quit();
    }

    @Test
    public void addQueryParams(){
        BrowserMobProxy browserMobProxy = new BrowserMobProxyServer();
        browserMobProxy.start(0);

        browserMobProxy.addRequestFilter(((httpRequest, httpMessageContents, httpMessageInfo) -> {
            if(httpRequest.getUri().contains("/authenticate")){
                String newUri = httpRequest.getUri() + "&newParam=newValue";
                httpRequest.setUri(newUri);
            }
            return null;
        }));

        Proxy proxy = ClientUtil.createSeleniumProxy(browserMobProxy);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.setProxy(proxy);

        ChromeDriver driver = new ChromeDriver(options);
        browserMobProxy.newHar();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        Har har = browserMobProxy.getHar();

        har.getLog().getEntries().forEach(harEntry -> {
            if (harEntry.getRequest().getUrl().contains("/authenticate&newParam=newValue")){
                System.out.println("Query params was success added");
            }
        });

        browserMobProxy.stop();
        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void checkSuccessLoginTitle() {
        String expectedResult = "Secure Area";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WaitHelper waitHelper = new WaitHelper(driver);

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        WebElement title = waitHelper.waitAndGetOfVisibilityElement(By.xpath("//h2"));

        Assert.assertEquals(title.getText(), expectedResult);

        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void checkInvisibilityLoaderWithExplicitWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WaitHelper waitHelper = new WaitHelper(driver);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button")).click();

        waitHelper.waitOfVisibilityElement(By.id("loading"));
        Assert.assertTrue(waitHelper.waitOfInvisibilityElement(By.id("loading")));
        WebElement successLoadingTitle = waitHelper.waitAndGetOfVisibilityElement(By.cssSelector("#finish h4"));
        Assert.assertEquals(successLoadingTitle.getText(), "Hello World!");

        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void checkInvisibilityLoaderWithFluentWait() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WaitHelper waitHelper = new WaitHelper(driver);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button")).click();

        WebElement successLoadingTitle = waitHelper.fluentWaitOnElement(By.cssSelector("#finish h4"));
        Assert.assertEquals(successLoadingTitle.getText(), "Hello World!");

        driver.quit();
    }

    @Test(groups = {"smoke"})
    public void checkScroll() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WaitHelper waitHelper = new WaitHelper(driver);

        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000);");
        waitHelper.waitOfInvisibilityElement(By.xpath("(//div[@class='jscroll-added'])[3]"));

        driver.quit();
    }
}
