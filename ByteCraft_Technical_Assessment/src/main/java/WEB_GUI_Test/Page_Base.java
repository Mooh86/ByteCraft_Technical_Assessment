package WEB_GUI_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page_Base (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
}


    }

