package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Soru6_YH {
    ///**
    //     * Navigate to  https://www.saucedemo.com/
    //     * Enter the user name  as standard_user
    //     * Enter the password as   secret_sauce
    //     * Click on login button
    //     * Choose price low to high
    //     * Verify item prices are sorted from low to high
    //     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //     * Navigate to  https://www.saucedemo.com/
        driver.navigate().to("https://www.saucedemo.com/");

    }@Test
    public void test1() {
        //* Enter the user name  as standard_user
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");

//     * Enter the password as   secret_sauce
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");

        //     * Click on login button
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        //     * Choose price low to high
        List<WebElement> urunFiyatlari=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> doubleFiyatlar=new ArrayList<>();
        for (int i = 0; i < urunFiyatlari.size(); i++) {
            doubleFiyatlar.add((Double.parseDouble((urunFiyatlari.get(i).getText()).replace("$", ""))));
        }
        Collections.sort(doubleFiyatlar);
        System.out.println("fiyatlarin kucukten buyuge siralanmis hali"+doubleFiyatlar);


        //     * Verify item prices are sorted from low to high
        List<Double> expectedKucuktenBuyuge=Arrays.asList(7.99, 9.99, 15.99, 15.99, 29.99,49.99);
        System.out.println("fiyatlarin sitweden alinmis actual durumlari"+expectedKucuktenBuyuge);
        for (int i = 0; i < urunFiyatlari.size(); i++) {
            Assert.assertEquals(expectedKucuktenBuyuge.get(i),doubleFiyatlar.get(i));
            System.out.println("pass");

        }

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
