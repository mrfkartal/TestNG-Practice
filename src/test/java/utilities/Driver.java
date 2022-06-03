package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    /*
    POM'de driver icin TestBase classine extends etmek yerine
    Driver class'indan static methodlar kullanarak
    driver olusturup ilgili ayarlarin yapilmasi ve en sonda
    driverin kapatilmasi tercih edilmistir

    POM'de Driver class'ındaki getDriver()'nun obje oluşturularak kullanılmasını
    engellemek için Singleton pattern kullanımı benimsenmiştir

   *** Singleton pattern: tekli kullanım, bir classın farklı classlardan
    obje oluşturularak kullanımını engellemek için kullanılır

    ***  Bunu saglamak icin yapmamiz gereken sey oldukca basittir
    Obje olusturmak icin kullanilan constructor i private yaptigimiz zaman baska class'lardan
    driver classindan obje olusturulmasi mumkun olamaz
     */

    private Driver(){

    }

 public static WebDriver driver;

    public static WebDriver getDriver() {

        if(driver==null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null)  //driver'a bir deger atanmissa
        driver.close();
        driver=null;

    }
}
