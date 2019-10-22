package test.java;

import main.java.PO.DayCoursesPage;
import main.java.PO.EveningCoursesPage;
import main.java.PO.HomePage;
import main.java.Utils.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class CoursesTest {
    static WebDriver driver;
    static WebDriverWait wait;
    static WebElement preloader;
    static HomePage homePage;
    static EveningCoursesPage eveningCoursesPage;
    static DayCoursesPage dayCoursesPage;

    @BeforeMethod
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        eveningCoursesPage = new EveningCoursesPage(driver);
        dayCoursesPage = new DayCoursesPage(driver);
    }

    @Test(description = "evening")
    public static void checkEveningCourses() {
        homePage.isShown()
                .openEveningCourses();
        String[] arr = {"Тестирование", "Frontend development", "JS development", "Веб-дизайн",
                "PHP", "Программирование под IOS", "Программирование под Android", "Java programming",
                "Python", "Data Science/Machine Learning", "C# /.NET development", "C++",
                "Game Development", "DEVOPS", "Digital Marketing", "Управление персоналом",
                "Управление проектами", "Менеджмент", "Кибербезопасность", "Mobile development",
                "Видеомонтаж", "Cisco", "Go development"};
        List<String> expected = new ArrayList<>(Arrays.asList(arr));

        boolean presence = true;
        for(WebElement el: driver.findElements(By.xpath("(//div[@class=\"img\"])[1]"))) {
            if(expected.contains(el.getText())) {
                presence = false;
            }
        }
        assertTrue(presence);
    }

    @Test(description = "day")
    public static void checkDayCourses() {
        homePage.isShown()
                .openDayCourses();
        String[] arr = {"Microsoft", "Cisco", "UNIX / Linux", "Oracle",
                "ITIL", "Программирование", "Управление проектами", "Пользовательские курсы",
                "Vmware", "Teradata", "EC-Council"};
        List<String> expected = new ArrayList<>(Arrays.asList(arr));

        boolean presence = true;
        for(WebElement el: driver.findElements(By.xpath("(//div[@class=\"img\"])[1]"))) {
            if(expected.contains(el.getText())) {
                presence = false;
            }
        }
        assertTrue(presence);
    }

    @Test(dataProvider = "provider")
    public static void EveningCoursesTest(String course) throws InterruptedException {
        homePage.isShown()
                .openEveningCourses();
        eveningCoursesPage.selectEveningCourse(course);
    }

    @Test(dataProvider = "provider2")
    public static void DayCoursesTest(String course) throws InterruptedException {
        homePage.isShown()
                .openDayCourses();
        dayCoursesPage.selectDayCourse(course);
    }

    @Test(dataProvider = "provider3")
    public static void EveningCoursesSelectionsTest(String course) throws InterruptedException {
        homePage.isShown()
                .openEveningCourses();
        eveningCoursesPage.selectEveningCourse(course)
                .clickEveningCourse();

        assertTrue(driver.findElement(By.xpath("//input[@type=\"radio\"][1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@type=\"radio\"][2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@type=\"radio\"][3]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).isSelected());
    }

    @AfterMethod
    public static void tearDown(ITestResult result) {
        driver.quit();
    }

    @DataProvider(name = "provider")
    public Object[][] provider() {
        return new Object[][]{
                {"Тестирование"},
                {"Frontend development"},
                {"JS development"},
                {"Веб-дизайн"},
                {"PHP"},
                {"Программирование под IOS"},
                {"Программирование под Android"},
                {"Java programming"},
                {"Python"},
                {"Data Science/Machine Learning"},
                {"C# /.NET development"},
                {"C++"},
                {"Game Development"},
                {"DEVOPS"},
                {"Digital Marketing"},
                {"Управление персоналом"},
                {"Управление проектами"},
                {"Менеджмент"},
                {"Кибербезопасность"},
                {"Mobile development"},
                {"Видеомонтаж"},
                {"Cisco"},
                {"Go development"}
        };
    }

    @DataProvider(name = "provider2")
    public Object[][] provider2() {
        return new Object[][]{
                {"Microsoft"},
                {"Cisco"},
                {"UNIX / Linux"},
                {"Oracle"},
                {"ITIL"},
                {"Программирование"},
                {"Управление проектами"},
                {"Пользовательские курсы"},
                {"Vmware"},
                {"Teradata"},
                {"EC-Council"}
        };
    }

    @DataProvider(name = "provider3")
    public Object[][] provider3() {
        return new Object[][]{
                {"Тестирование"},
                {"Frontend development"},
                {"JS development"},
                {"Веб-дизайн"},
                {"PHP"},
                {"Программирование под IOS"},
                {"Программирование под Android"},
                {"Java programming"},
                {"Python"},
                {"Data Science/Machine Learning"},
                {"C# /.NET development"},
                {"C++"},
                {"Game Development"},
                {"DEVOPS"},
                {"Digital Marketing"},
                {"Управление персоналом"},
                {"Управление проектами"},
                {"Менеджмент"},
                {"Кибербезопасность"},
                {"Mobile development"},
                {"Видеомонтаж"},
                {"Cisco"},
                {"Go development"}
        };
    }
}

