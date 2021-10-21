package tests.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class MentoringOdev1 extends TestBase {
    @Test
    public void test() throws InterruptedException {

        //    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        //    ~ click on Phones & PDAs
        driver.findElement(By.linkText("Phones & PDAs")).click();

        //    ~ get the brandName of phones
        List<WebElement> urunIsimleri= driver.findElements(By.xpath("//h4"));

        //    ~ click on add to button for all elements

        for (WebElement each:urunIsimleri) {
            System.out.println(each.getText());
        }
        //    ~ click on black total added cart button
        //    ~ get the names of list from the cart
        //    ~ compare the names from displaying list and cart list

    }
}
