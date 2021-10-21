package tekrarTest.day1_tekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_tekrarTest {
    public static void main(String[] args) throws InterruptedException {
        //1. Yeni bir class olusturun (TekrarTesti)


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tayfu\\OneDrive\\Belgeler\\selenium dependencies\\drives\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        //(verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        Thread.sleep(2000);
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
            System.out.println("actualTitle= " + driver.getTitle());
        }
        //**********************************************************************
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
        //URL'yi yazdırın.
        String expextedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expextedUrl)) {
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
            System.out.println("actualUrl= " + driver.getCurrentUrl());
        }
        //***************************************************************************
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);
        //*************************************************************************
        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);
        //****************************************************************************
        //6. RefrSayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);
        //***************************************************************************
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);
        //*****************************************************************************
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //*******************************************************************************
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa
        //doğru başlığı(Actual Title) yazdırın.
        String expectedTitle1 = "Amazon";
        String actualTitle1 = driver.getTitle();
        if (actualTitle1.contains(expectedTitle1)) {
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
            System.out.println("actualTitle1= " + driver.getTitle());
        }
        //******************************************************************************
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
        //URL'yi yazdırın
        String expextedUrl1 = "https://www.amazon.com/";
        String actualUrl1 = driver.getCurrentUrl();
        if (actualUrl1.contains(expextedUrl1)) {
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
            System.out.println("actualUrl1= " + driver.getCurrentUrl());
        }
        //********************************************************************************
        //11.Sayfayi kapatin
        driver.close();
    }
}
