package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHatelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C03_PositiveTestConfigReaderIle extends TestBase {


    @Test
    public void positiveTestConfig(){
        driver.get(ConfigReader.getProperty("CHUrl"));


        ConcortHatelPage concortHatelPage=new ConcortHatelPage(driver);
        concortHatelPage.ilkLoginLinki.click();
        concortHatelPage.userNameKutusu.sendKeys(ConfigReader.getProperty("CHValidUsername"));
        concortHatelPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHatelPage.loginButonu.click();
        Assert.assertTrue(concortHatelPage.basariliTesti.isDisplayed());


    }

}
