package day05;

import org.junit.Test;

public class C01_notasyon {
    //javadaki gibi selenium da da belirli islevleri yapan method lar olusturabiliriz
    //ancak bu methodlar cagrilmadikca calismazlar
    public void ilkTestMetodu(){
        System.out.println("ilk test metodu");

    }
//JUNIT ILE NOTASYON KULLANARAK siradan methodlari test methoduna donustureniliriz
    //bir test methodu bagimsiz olarak calisabilen test yapmamiza imkana verir

    //@Test notasyonu sayesinde main method mecburuyeti ortadan kalkar
    @Test
    public void notasyonluilkTestMetodu(){
        System.out.println("notasyonluilk test metodu");

    }
}
