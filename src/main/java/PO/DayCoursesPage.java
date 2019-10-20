package main.java.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DayCoursesPage extends BasePage {
    public Logger logger = LogManager.getLogger(this.getClass());

    public DayCoursesPage(WebDriver driver) {
        super(driver);
    }

    public DayCoursesPage selectDayCourse(String course) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='grid_3 item'][h2='" + course +"']"))));
        driver.findElement(By.xpath("//div[@class='grid_3 item'][h2='" + course +"']"));
        logger.info(course + " is found");
        return this;
    }

}
