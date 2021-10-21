package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLogintest {

    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        // https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));

        QAConcortPage qaConcortPage=new QAConcortPage();

        // login butonuna bas
        qaConcortPage.ilkLoginLinki.click();
        //test data username: manager ,
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("QACHValidUsername"));
        //test data password : Manager1!
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("QACHValidPassword"));
        qaConcortPage.loginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(qaConcortPage.basariliTesti.isDisplayed());


        Driver.closeDriver();
    }
}
