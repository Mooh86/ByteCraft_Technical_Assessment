package WEB_GUI_Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Google_Search extends Page_Base{
    public Google_Search(WebDriver driver) {
        super(driver);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(id = "APjFqb")
    WebElement SearchBar;
    @FindBy(xpath = "//h3[normalize-space()='Downloads']")
     public  WebElement Third_text;

    public void setSearchBar(String search1) {
        SearchBar.sendKeys(search1);
        SearchBar.submit();
        js.executeScript("arguments[0].scrollIntoView(true);", Third_text);
    }
}




