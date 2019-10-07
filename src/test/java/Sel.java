import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mak\\IdeaProjects\\qatasks\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea");
        Thread.sleep(5000);
        By div = By.className("phones-block");
        WebElement element = driver.findElement(div);
        element.click();
        Thread.sleep(5000);
        By number = By.linkText("+38 (050) 599-46-63");
        WebElement element1 = driver.findElement(number);
        String phone = element1.getText();
        Thread.sleep(5000);
        System.out.println(phone.substring(3));
        driver.quit();
    }
}

