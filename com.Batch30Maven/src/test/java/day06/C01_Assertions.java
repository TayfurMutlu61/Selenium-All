package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {

    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin







   static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }
        @Test
        public void urlTest(){
            // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
            Assert.assertEquals("test bulunamadi","https://www.bestbuy.com/",driver.getCurrentUrl());

        }
        @Test
        public void titleTest(){
            // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
            Assert.assertFalse(driver.getTitle().contains("Rest"));
        }

        @Test
        public void logoTest(){
            // ○ logoTest => BestBuy logosunun görüntülendigini test edin
            WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
            Assert.assertTrue(logo.isDisplayed());
        }

        @Test
        public void fransizcaTest(){
            // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
            WebElement fransizcaLinki= driver.findElement(By.xpath("//button[text()='Français']"));
            Assert.assertTrue(fransizcaLinki.isDisplayed());

        }

        @AfterClass
        public static void tearDown(){
            driver.close();
        }


}
