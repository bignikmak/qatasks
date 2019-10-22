package main.java.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 70);
    }

    public void waitSpinner() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id=\"preload-it\"]"))));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id=\"preload-it\"]"))));
    }
}
