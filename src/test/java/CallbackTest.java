package test.java;

import main.java.PO.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CallbackTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, 60);
    }

    @Test(description = "Positive case")
    public static void PositiveTest() throws InterruptedException {
        homePage.isShown()
                .clickRecall();

        driver.findElement(By.id("b-contacte__full-name")).sendKeys("TEST");
        driver.findElement(By.id("b-contacte-phone-tel")).sendKeys("0666666666");
        driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b-header-contacte-phone-thank"))));
        String actualString = driver.findElement(By.className("b-header-contacte-phone-thank")).getText();
        String expectedString = "Спасибо!\nНаш менеджер свяжется с Вами.";
        assertEquals(expectedString, actualString);
    }

    @Test(description = "Negative case")
    public static void NegativeTest() throws InterruptedException {
        homePage.isShown()
                .clickRecall();

        driver.findElement(By.xpath("//*[@id=\"callback-form\"]/input[4]")).click();
        String actualString = driver.findElement(By.id("b-contacte__full-name")).getAttribute("style");
        String expectedString = "border-color: red;";
        assertEquals(expectedString, actualString);
    }

    @AfterMethod
    public static void tearDown() {
        driver.quit();
    }
}