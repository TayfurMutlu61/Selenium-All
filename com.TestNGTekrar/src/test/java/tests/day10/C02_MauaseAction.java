package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utulities.Database;

import javax.swing.*;
import java.util.Set;

public class C02_MauaseAction extends Database {

    @Test
    public void test() {
        //Yeni bir class olusturalim: D14_MouseActions1

        //https://the internet.herokuapp.com/context_menu sitesine gidelim

        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlan).perform();
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedText="You selected a context menu";
        String actualText=driver.switchTo().alert().getText();
        Assert.assertEquals(actualText,expectedText,"text dogrulanmadi");

        //Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine tiklayalim
        String ilkSayfaHandle= driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> toplamHandle= driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each:toplamHandle
             ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;

            }


        }
        driver.switchTo().window(ikinciSayfaHandle);

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedTextIkinci="Elemental Selenium";
        String actualTextIkinci=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualTextIkinci,expectedTextIkinci,"ikinci sayfa text dogrulanmadi");
    }
}
