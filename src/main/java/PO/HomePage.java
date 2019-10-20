package main.java.PO;

import main.java.Utils.PropertyLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public Logger logger = LogManager.getLogger(this.getClass());

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage isShown() {
        driver.get(PropertyLoader.loadProperty("url"));
        this.waitSpinner();
        logger.info("HomePage is shown");
        return this;
    }

    public HomePage clickRecall() {
        driver.findElement(By.className("callback-btn")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("b-header-contacte"))));
        logger.info("Recall is formed");
        return this;
    }

    public HomePage openEveningCourses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class=\'parent\'])[2]")));
        driver.findElement(By.xpath("(//a[@class=\"parent\"])[2]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[@id='menu-item-411']/ul/li/a)[1]"))));
        driver.findElement(By.xpath("(//li[@id='menu-item-411']/ul/li/a)[1]")).click();
        logger.info("Evening courses is opened");
        return this;
    }

    public HomePage openDayCourses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id=\"menu-item-7901\"]/a")));
        driver.findElement(By.xpath("//li[@id=\"menu-item-7901\"]/a")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li[@id=\"menu-item-7901\"]/ul/li/a)[1]"))));
        driver.findElement(By.xpath("(//li[@id=\"menu-item-7901\"]/ul/li/a)[1]")).click();
        logger.info("Day courses is opened");
        return this;
    }
}