package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DhtmlGoodiesPage {
    public DhtmlGoodiesPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@id='box106']")
    public WebElement Italy;
    @FindBy(xpath ="//div[@id='box6']")
    public WebElement Roma;
    @FindBy(xpath = "//div[@id='box102']")
    public WebElement Sweden ;
    @FindBy(xpath = "//div[@id='box2']")
    public WebElement Stockholm;
    @FindBy(xpath = "//div[@id='box107']")
    public WebElement Spain ;
    @FindBy(xpath = "//div[@id='box7']")
    public WebElement Madrid;
    @FindBy(xpath = "//div[@id='box103']")
    public WebElement UnitedStates ;
    @FindBy(xpath = "//div[@id='box3']")
    public WebElement washington;
    @FindBy(xpath = "//div[@id='box105']")
    public WebElement southKorea;
    @FindBy(xpath = "//div[@id='box5']")
    public WebElement Seoul;
    @FindBy(xpath = "//div[@id='box101']")
    public WebElement Norway;
    @FindBy(xpath = "//div[@id='box1']")
    public WebElement Oslo;
    @FindBy(xpath = "//div[@id='box104']")
    public WebElement Denmark;
    @FindBy(xpath = "//div[@id='box4']")
    public WebElement Copenhagen;



    }

