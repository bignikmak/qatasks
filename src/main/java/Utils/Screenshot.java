package main.java.Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Screenshot {
    private WebDriver driver;

    public Screenshot(WebDriver driver){
        this.driver = driver;
    }

    public void saveScreenshot(ITestResult result) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        Path path = Paths.get("");
        try {
            FileUtils.copyFile(src, new File(
                    path.toAbsolutePath().toString()
                            + "\\screenshots\\"
                            + result.getTestClass().getName().replace(".", "\\\\")
                            + "\\" + result.getMethod().getConstructorOrMethod().getName() + " "
                            + result.getParameters()[0]
                            + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}