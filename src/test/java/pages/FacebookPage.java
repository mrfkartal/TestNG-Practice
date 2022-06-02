package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public WebElement cookieButonu;

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        //bunun vazifesi ....
    }

    @FindBy(id = "email")
    public WebElement mailKutusu;

    @FindBy(id = "pass")
    public WebElement sifreKutusu;

    @FindBy(name = "login")
    public WebElement loginTusu;

    @FindBy(className = "_9ay7")
    public WebElement girilemediYaziElementi;

}
