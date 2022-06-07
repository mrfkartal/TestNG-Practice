package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SauceDemoPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3_SoftAssert {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high with soft Assert
     *     T2 : Verify item prices are sorted from low to high with hard Assert
     */

    // Verify item prices are sorted from low to high with hard Assert

    @Test
    public void sauceDemoSoft(){
        Driver.getDriver().get("https://www.saucedemo.com/");

        SauceDemoPage sdpage = new SauceDemoPage();
        sdpage.username.sendKeys("standard_user");
        sdpage.password.sendKeys("secret_sauce");
        sdpage.loginButton.click();

        Select select =new Select(sdpage.dropDown);
        select.selectByVisibleText("Price (low to high)");

        String expected = "PRICE (LOW TO HIGH)";
        String actual = select.getFirstSelectedOption().getText();
        String actual2 = Driver.getDriver().findElement(By.className("active_option")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertEquals(actual2,expected);
        softAssert.assertAll();

    }


    @Test
    public void sauceDemoHard(){
        Driver.getDriver().get("https://www.saucedemo.com/");

        SauceDemoPage sdpage = new SauceDemoPage();
        sdpage.username.sendKeys("standard_user");
        sdpage.password.sendKeys("secret_sauce");
        sdpage.loginButton.click();

        Select select =new Select(sdpage.dropDown);
        select.selectByIndex(2);
        ArrayList<Double> urunlerDouble = new ArrayList<>();

        for (WebElement each: sdpage.urunler){
           // String fiyatStr = each.getText().replaceAll("$", "");
            String fiyatStr = each.getText().replaceAll("^\\D", "");
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);

        Assert.assertEquals(kontrolListe,urunlerDouble);

    }
}
