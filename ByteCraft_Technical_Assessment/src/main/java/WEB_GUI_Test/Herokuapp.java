package WEB_GUI_Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Herokuapp extends Page_Base {
    public Herokuapp(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='File Upload']")
    WebElement fileUpload_link;

    @FindBy(id = "file-upload")
    WebElement fileUpload_Button;

    @FindBy(xpath = " //input[@id='file-submit']")
    WebElement Upload_Button;

    public void uploadPhoto() {
        fileUpload_link.click();
        fileUpload_Button.sendKeys("C:\\Users\\Dafa\\IdeaProjects\\ByteCraft_Technical_Assessment\\Photos\\OIP.jpg");
        Upload_Button.submit();
    }

    @FindBy(xpath = "//a[normalize-space()='Dynamic Loading']")
    WebElement DynamicLoading_link;
    @FindBy(xpath = "//a[normalize-space()='Example 2: Element rendered after the fact']")
    WebElement Example2;
    @FindBy(xpath = "//*[@id=\"start\"]/button")
    WebElement StartButton;
    @FindBy(id = "finish")
    public WebElement displayedText;

    public void Dynamic_loading() {
        DynamicLoading_link.click();
        Example2.click();
        StartButton.click();
        wait.until(ExpectedConditions.visibilityOf(displayedText));
    }
    public String getDisplayedText() {
        return displayedText.getText();
    }
}



