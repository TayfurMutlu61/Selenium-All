package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeTest {

        //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
        //3 Farkli test Methodunda 3 senaryoyu test et


        // - yanlisSifre
        // - yanlisKulllanici
        // - yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password : manager1!
        //2) https://qa-environment.concorthotel.com/ adresine git
        //3) Login butonuna bas
        //4) Verilen senaryolar ile giris yapilamadigini test et
        QAConcortPage qaConcortPage;
    @Test (priority = -5   , groups = "birinciGrup")
    public void yanlisPassword(){
        // - yanlisSifre
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage=new QAConcortPage();

        // login butonuna bas
        qaConcortPage.ilkLoginLinki.click();

        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("QACHValidUsername"));

        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("QACHInvalidPassword"));
        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());

    }

    @Test(dependsOnMethods = "yanlisPassword" , groups = "birinciGrup")
    public void yanlisKullanici(){
       qaConcortPage=new QAConcortPage();
       qaConcortPage.userNameKutusu.clear();
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("QACHInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("QACHValidPassword"));

        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());

    }

    @Test(dependsOnMethods = "yanlisPassword")
    public void yanlisKullaniciYanlisPassword(){
        qaConcortPage=new QAConcortPage();
        qaConcortPage.userNameKutusu.clear();
        qaConcortPage.userNameKutusu.sendKeys(ConfigReader.getProperty("QACHInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("QACHInvalidPassword"));

        qaConcortPage.loginButonu.click();

        Assert.assertTrue(qaConcortPage.isLoginFailed.isDisplayed());
        Driver.closeDriver();
    }
    }

