package com.thetestingacademy.ex11_SeleniumDataDriven;

import org.testng.annotations.Test;

public class DataDrivenExcel {
    @Test(dataProvider ="getData",dataProviderClass=UtilExcel.class)
    public void test_VWOLogin(String email,String password){
        System.out.println("Email - "+email);
        System.out.println("Password - "+password);
    }
}
