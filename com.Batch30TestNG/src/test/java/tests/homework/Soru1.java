package tests.homework;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Soru1 extends TestBase {
    //●Bir class olusturun: IframeTest 02
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3)
    //ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4)
    //ilk iframe'den çıkıp ana sayfaya dönünüz
    //5)
    //ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live selenium
    //project.html) tıklayınız

    //https://www.guru99.com/live-selenium-project.html
    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        driver.navigate().refresh();
       // driver.navigate().to("http://demo.guru99.com/test/guru99home/");
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

    }

}
