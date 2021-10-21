package tests.day15;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassKullanimi {
    @Test
    public  void test(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));


      //  Driver driver=new Driver();
        //Driver class indan obje uretilememsi istedigimiz icin driver class SINGLETON yapiyoruz
        //bunun icin defoult constructor yerine bir coinstrotur olusturup access mofifieri private yapiyoruz

       // Driver driver=new Driver("ben istedium ama olmadi");
        //Driver classinda parametreli constructor olmadigi icin kullanamayiz


        Driver.closeDriver();
    }
}
