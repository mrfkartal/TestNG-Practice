package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebDriverUniversityPage {
    public WebDriverUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "button1")
    public WebElement javaScriptAlert;

    @FindBy(xpath = "//span[@id='button4']")
    public WebElement javaScriptConfirmBox;

    @FindBy(xpath = "//p[@id='confirm-alert-text']")
    public WebElement yaziElementi;
}
