package tekrarTest.day1_tekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_VerfyPageTitle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tayfu\\OneDrive\\Belgeler\\selenium dependencies\\drives\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        // Yeni bir Class olusturalim. (VerifyTitle)
        //        Amazon ana sayfasina gidelim . https://www.amazon.com/
        // Sayfa basliginin (title) “amazon” oldugunu dogrulayin. (verify)

        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);
        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("test passed");
        }else
        {
            System.out.println("test failed");
        }
    }
}
