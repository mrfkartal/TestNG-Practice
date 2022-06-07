package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q6_DropDown_FakerClass extends TestBase {
    //twitter a faker class kullanarak mail ile kayit olmaya calisiniz
    //actions class kullanmayin twitteri deneyen instagram i denesin

   // Not :bilerek page class yapmadim, derste FaceBook uzerine calismissnz karissin istemedim, siz isterseniz uyarlayabilirisniz
    @Test
    public void register() throws InterruptedException {

        Faker faker = new Faker();
        driver.get("https://www.twitter.com");
        WebElement register = driver.findElement(By.xpath("//a[@data-testid='signupButton']"));
        register.click();

        WebElement emailInstead = driver.findElement(By.xpath("//span[.='E-posta kullan']"));
        emailInstead.click();
        WebElement isim = driver.findElement(By.name("name"));
        isim.sendKeys(faker.funnyName().name());
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);

        WebElement ayElementi = driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));  //ay
        WebElement gunElementi = driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));  //gun
        WebElement yilElementi = driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));  //yil

        Select select = new Select(ayElementi);
        select.selectByIndex(faker.number().numberBetween(1,13)); //int number
        Select select1 = new Select(gunElementi);
        select1.selectByIndex(faker.random().nextInt(1, 30));
        Select select2= new Select(yilElementi);
        select2.selectByIndex(faker.random().nextInt(1, 120));

        WebElement nextButton = driver.findElement(By.xpath("//span[text()='İleri']"));
        nextButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {

        }
        driver.findElement(By.xpath("(//span[.='İleri'])[2]")).click();


    }


}
