package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallbackTest {
    static WebDriver driver;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Positive case")
    public static void PositiveTest() throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        By recallwindow = By.className("callback-btn");
        WebElement element = driver.findElement(recallwindow);
        element.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b-header-contacte"))));
        By input1 = By.id("b-contacte__full-name");
        WebElement element1 = driver.findElement(input1);
        element1.sendKeys("TEST");
        By input2 = By.id("b-contacte-phone-tel");
        WebElement element2 = driver.findElement(input2);
        element2.sendKeys("0666666666");
        By submitbtn = By.xpath("//*[@id=\"callback-form\"]/input[4]");
        WebElement element3 = driver.findElement(submitbtn);
        element3.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b-header-contacte-phone-thank"))));
        By spanposit = By.className("b-header-contacte-phone-thank");
        WebElement element4 = driver.findElement(spanposit);
        System.out.println(element4.getText());
    }

    @Test(description = "Negative case")
    public static void NegativeTest() throws InterruptedException {
        driver.get("http://iteaua-develop.demo.gns-it.com");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement preloader = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(preloader));
        wait.until(ExpectedConditions.invisibilityOf(preloader));
        By recallwindow = By.className("callback-btn");
        WebElement element = driver.findElement(recallwindow);
        element.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b-header-contacte"))));
        By submitbtn2 = By.xpath("//*[@id=\"callback-form\"]/input[4]");
        WebElement element1 = driver.findElement(submitbtn2);
        element1.click();
        wait.until(ExpectedConditions.attributeContains(By.id("b-contacte__full-name"), "style", "border-color: red;"));
        wait.until(ExpectedConditions.attributeContains(By.id("b-contacte-phone-tel"), "style", "border-color: red;"));
        System.out.println("Enter your personal data");
    }


    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}