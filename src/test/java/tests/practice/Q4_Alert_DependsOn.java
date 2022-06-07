package tests.practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WebDriverUniversityPage;
import utilities.Driver;
import utilities.TestBase;

public class Q4_Alert_DependsOn  {

       /*
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2. CLICK ME of JavaScript Alert e tıklayın
     // 3. pop up text i alın
     // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
     // 5. pop up i kabul edin

     // Yine ayni class da baska test methodu olusturun
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
     // 3.  pop up text i alın
     // 4. Mesajın "Press a button!" olduğunu doğrulayın
     // 5. Açılır pencereyi kapat
     // 6. pop up i iptal edin,
     // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
     // 8. alert1'e göre dependsOnMethods kullanın
 */

    @Test
    public void alert1(){
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        WebDriverUniversityPage wdup = new WebDriverUniversityPage();
        wdup.javaScriptAlert.click();
        String actualMessage = Driver.getDriver().switchTo().alert().getText();
        String expectedMessage ="I am an alert box!";
        Assert.assertEquals(actualMessage, expectedMessage);

        Driver.getDriver().switchTo().alert().accept();
    }

    @Test(dependsOnMethods="alert1")
    public void alert2(){
        Driver.getDriver().get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        WebDriverUniversityPage wdup = new WebDriverUniversityPage();
        wdup.javaScriptConfirmBox.click();
        Alert alert = Driver.getDriver().switchTo().alert();

        String expectedMessage= "Press a button!";
        Assert.assertEquals(alert.getText(),expectedMessage);

        alert.dismiss();
        Assert.assertTrue(wdup.yaziElementi.isDisplayed());
    }

    /*
    Alert alert = driver.switchTo().alert(); //bu sekilde de kullanimi mevcuttur
    driver.switchTo().alert();    yerine   Alert data turundeki alert variable ini kullandik.
    alert variable ile methodlara ulasilabilir
    alert.dismiss();
    alert.accept(); vb
     alert.getText();
    bu kullanim sayesinde switchto() yazmamiza gerek kalmaz
     */
}

