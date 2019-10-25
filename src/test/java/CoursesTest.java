package test.java;

import io.qameta.allure.*;
import main.java.PO.DayCoursesPage;
import main.java.PO.EveningCoursesPage;
import main.java.PO.HomePage;
import main.java.Utils.RetryAnalyzer;
import main.java.Utils.Screenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

@Epic("Cart menu")
@Feature("Cart2")
public class CoursesTest {
     WebDriver driver;
     WebDriverWait wait;
     WebElement preloader;
     HomePage homePage;
     EveningCoursesPage eveningCoursesPage;
     DayCoursesPage dayCoursesPage;

    @BeforeMethod
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("webDriver", driver);
        homePage = new HomePage(driver);
        eveningCoursesPage = new EveningCoursesPage(driver);
        dayCoursesPage = new DayCoursesPage(driver);
    }

    @Link("example.org")
    @TmsLink("tms.com/AAA-1")
    @Issues({
            @Issue("B-1")
    })
    @Story("check evening courses")
    @Test(description = "evening")
    public void checkEveningCourses() {
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

    @Story("Day check courses")
    @Test(description = "day")
    public void checkDayCourses() {
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

    @Test(dataProvider = "eveningCourses")
    public void EveningCoursesTest(String course) throws InterruptedException {
        homePage.isShown()
                .openEveningCourses();
        eveningCoursesPage.selectEveningCourse(course);
    }

    @Test(dataProvider = "dayCourses")
    public void DayCoursesTest(String course) throws InterruptedException {
        homePage.isShown()
                .openDayCourses();
        dayCoursesPage.selectDayCourse(course);
        fail();
    }

    @Test(dataProvider = "provider3")
    public void EveningCoursesSelectionsTest(String course) throws InterruptedException {
        homePage.isShown()
                .openEveningCourses();
        eveningCoursesPage.selectEveningCourse(course)
                .clickEveningCourse();

        assertTrue(driver.findElement(By.xpath("//input[@type=\"radio\"][1]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@type=\"radio\"][2]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@type=\"radio\"][3]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).isSelected());
    }

    @Test
    public void Test() throws Exception {
        String[] str = {"Тестирование", "Frontend development", "JS development", "Веб-дизайн",
                "PHP", "Программирование под IOS", "Программирование под Android", "Java programming",
                "Python", "Data Science/Machine Learning", "C# /.NET development", "C++",
                "Game Development", "DEVOPS", "Digital Marketing", "Управление персоналом",
                "Управление проектами", "Менеджмент", "Кибербезопасность", "Mobile development",
                "Видеомонтаж", "Cisco", "Go development"};
        int rand = (int) (Math.random() * (str.length + 1));
        homePage.isShown();
        eveningCoursesPage.selectEveningCourse(str[rand]);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        saveScreenshot();
        driver.quit();
    }

    @DataProvider(name = "eveningCourses")
    public Object[][] eveningCourses() {
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

    @DataProvider(name = "dayCourses")
    public Object[][] dayCourses() {
        return new Object[][]{
                {"Microsoft"}
               /* {"Cisco"},
                {"UNIX / Linux"},
                {"Oracle"},
                {"ITIL"},
                {"Программирование"},
                {"Управление проектами"},
                {"Пользовательские курсы"},
                {"Vmware"},
                {"Teradata"},
                {"EC-Council"}*/
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

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

