package Test_GUI;

import WEB_GUI_Test.Google_Search;
import WEB_GUI_Test.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.Duration;

public class Test_Google {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    Google_Search searchObject;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void Initiate_driver() {
        // Initialize ExtentReports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Google_Report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Test Execution Report");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/ncr");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void Test_Google_search() {
        // Initialize ExtentTest
        test = extent.createTest("Test_Google_search", "Search for 'selenium webdriver'");

        searchObject = new Google_Search(driver);
        searchObject.setSearchBar("selenium webdriver");
        String third_text = searchObject.Third_text.getText();
        String expected_text = "What is Selenium WebDriver?";

        try {
            Assert.assertEquals(third_text, expected_text);
            test.pass("Text matched successfully.");
        } catch (AssertionError e) {
            test.fail("Text did not match. Expected: " + expected_text + ", but got: " + third_text);
        }
    }

    @AfterMethod
    public void takeScreenShot() {
        if (driver != null) {
            Utility.takeScreenshot(driver, "failure_screenshot");
            driver.close();
        }
        // Flush the ExtentReports instance
        extent.flush();
    }
}
