package main.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EveningCoursesPage extends BasePage {
    public Logger logger = LogManager.getLogger(this.getClass());

    public EveningCoursesPage(WebDriver driver) {
        super(driver);
        this.waitSpinner();
    }

    public EveningCoursesPage selectEveningCourse(String course) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='container_12 isotope 23']/div[h2='" + course + "']"))));
        driver.findElement(By.xpath("//div[@class='container_12 isotope 23']/div[h2='" + course + "']"));
        logger.info(course + " is found");
        return this;
    }

    public EveningCoursesPage clickEveningCourse(String course) {
        driver.findElement(By.xpath("//div[@class='container_12 isotope 23']/div[h2='" + course + "']")).click();
        this.waitSpinner();
        logger.debug(course + " is shown");
        driver.findElement(By.xpath("(//button[@class=\"order-courses-btn\"])[1]")).click();
        this.waitSpinner();
        return this;
    }

    public EveningCoursesPage selectionsCheck(String course) {
        driver.findElement(By.className("input:" + course + "[type=\"radio\"]"));
        driver.findElement(By.className("input:" + course + "[type=\"radio\"]:nth-child(3)"));
        driver.findElement(By.className("input:" + course + "[type=\"radio\"]:nth-child(5)"));
        //driver.findElement(By.className("input:" + checked + "[type=\"checkbox\"]"));
        return this;
    }
}
