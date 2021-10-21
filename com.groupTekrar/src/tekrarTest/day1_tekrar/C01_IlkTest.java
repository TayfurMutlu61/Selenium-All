package tekrarTest.day1_tekrar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tayfu\\OneDrive\\Belgeler\\selenium dependencies\\drives\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.navigate().to("https://www.youtube.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        driver.close();
    }
}
