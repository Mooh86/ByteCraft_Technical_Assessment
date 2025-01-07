package Test_GUI;
import WEB_GUI_Test.Herokuapp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.time.Duration;


public class Test_HeroKuapp {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    Herokuapp Hero_Object;

    @BeforeClass
    public void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-spark.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeMethod
    public void Initiate_driver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void UploadTest() {
        test = extent.createTest("UploadTest", "Test file upload functionality");
        Hero_Object = new Herokuapp(driver);
        Hero_Object.uploadPhoto();

        if (driver.getPageSource().contains("File Uploaded!")) {
            test.pass("File uploaded successfully.");
            System.out.println("file uploaded");
        } else {
            test.fail("File upload failed.");
            System.out.println("file not uploaded");
        }
    }

    @Test(priority = 2)
    public void DynamicTest() {
        test = extent.createTest("DynamicTest", "Test dynamic loading functionality");

        Hero_Object = new Herokuapp(driver);
        Hero_Object.Dynamic_loading();
        String displayedText = Hero_Object.getDisplayedText();

        try {
            Assert.assertEquals(displayedText, "Hello World!", "Displayed text isn't correct");
            test.pass("Displayed text is correct.");
        } catch (AssertionError e) {
            test.fail("Displayed text is incorrect: " + displayedText);
        }
    }

    @AfterMethod
    public void Close_Driver() {
        if (driver != null) {
            driver.close();
        }
    }

    @AfterClass
    public void teardown() {
        extent.flush();
    }
}

