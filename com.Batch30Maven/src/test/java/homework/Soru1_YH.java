package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Soru1_YH {
    //Navigate to "https://react-shopping-cart-67954.firebaseapp.com/"
    // List all the elements on the website
    // Create a String Arraylist and put Product Names into the ArrayList
    // Choose 5 items randomly, add to cart and print the names of item
    // (Each product cannot be added more then 1 time!)

// CHECK THE PRICES!
// Sum each item's price and compare your result with the website
// If results are matching print success message
// Get string price values from Website, convert them to double and add to <Double> ArrayList and print the price list
// Click Checkout


    static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://react-shopping-cart-67954.firebaseapp.com/");

    }

    @Test
    public void test1() throws InterruptedException {

        List<WebElement> urunAdlari = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        List<WebElement> urunFiyatlari=driver.findElements(By.xpath("//div[@class='val']"));
        Random random=new Random();


        List<Double> sepetToplam=new ArrayList<>();


        for (int i = 0; i < 5; i++) {
          int rastgeleEleman=random.nextInt(urunAdlari.size());



            System.out.println("rastgele gelen urun: "+ urunAdlari.get(rastgeleEleman).getText());

            System.out.println("(urunFiyatlari.getText()) = " + (urunFiyatlari.get(rastgeleEleman).getText()));

            Thread.sleep(2000);
            sepetToplam.add(Double.parseDouble((urunFiyatlari.get(rastgeleEleman).getText()).replace("$", "")));

            urunAdlari.get(rastgeleEleman).click();

        }

        double sToplam=0;
        for (double toplam:sepetToplam) {
            sToplam+=toplam;
        }

        double gercekfiyat=Double.parseDouble(driver.findElement(By.className("sub-price__val")).getText().replace("$", ""));


        System.out.println(sToplam);
        if (sToplam==gercekfiyat){
            driver.findElement(By.xpath("//div[@class='buy-btn']")).click();
        }


    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}