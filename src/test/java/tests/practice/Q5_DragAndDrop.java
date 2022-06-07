package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DHtmlGoodiesPage;
import utilities.Driver;
import utilities.TestBase;

public class Q5_DragAndDrop {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.

    @Test
    public void test() {
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        DHtmlGoodiesPage dhtmlpage = new DHtmlGoodiesPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dhtmlpage.Oslo,dhtmlpage.Norway).
                dragAndDrop(dhtmlpage.Stockholm,dhtmlpage.Sweden).
                dragAndDrop(dhtmlpage.washington,dhtmlpage.UnitedStates).
                dragAndDrop(dhtmlpage.Copenhagen,dhtmlpage.Denmark).
                dragAndDrop(dhtmlpage.Seoul, dhtmlpage.southKorea).
                dragAndDrop(dhtmlpage.Madrid,dhtmlpage.Spain).
                dragAndDrop(dhtmlpage.Roma,dhtmlpage.Italy).perform();

    }


}