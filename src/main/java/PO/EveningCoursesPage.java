package main.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EveningCoursesPage extends BasePage {
    public Logger logger = LogManager.getLogger(this.getClass());

    public EveningCoursesPage(WebDriver driver) {
        super(driver);
    }

    public EveningCoursesPage selectEveningCourse(String course) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class=\"container_12 isotope 23\"]/div[h2='" + course + "']"))));
        logger.info("Loader is disappeared");
        driver.findElement(By.xpath("//div[@class=\"container_12 isotope 23\"]/div[h2='" + course + "']"));
        logger.debug(course + " is found");
        return this;
    }

    public EveningCoursesPage clickEveningCourse() {
        driver.findElement(By.xpath("//div[@class=\"container_12 isotope 23\"]/div")).click();
        this.waitSpinner();
        logger.debug("Course order page is shown");
        driver.findElement(By.xpath("(//button[@class=\"order-courses-btn\"])[1]")).click();
        this.waitSpinner();
        return this;
    }

}
