package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Odev3 extends TestBase {

    @Test
    public void test(){
        // //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        ////2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);

        // //3."Login Portal" a tiklayin
        WebElement loginButon=driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        actions.moveToElement(loginButon).perform();

        String parentHandle= driver.getWindowHandle();

        loginButon.click();


        Set<String> allHandless= driver.getWindowHandles();
        ////4.Diger window'a gecin
        for (String element:allHandless
             ) {
            if (!element.equals(parentHandle)){
                driver.switchTo().window(element);
            }

        }


        //5.//5."username" ve "password" kutularina deger yazdirin
        WebElement userName= driver.findElement(By.id("text"));
        userName.sendKeys("tayfur");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("123456");
        // //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        ////7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
      String actualAlert=  driver.switchTo().alert().getText();
      String expectedAlert="validation failed";
        Assert.assertEquals(actualAlert,expectedAlert,"alert messaj dogrulanmadi");
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(parentHandle);
        //10.Ilk sayfaya donuldugunu test edin
        String actualIlkUrl= driver.getCurrentUrl();
        String expectedIlkUrl="http://webdriveruniversity.com/";
        Assert.assertEquals(actualIlkUrl,expectedIlkUrl,"ilk sayfaya gecirilemedi");

    }



}
