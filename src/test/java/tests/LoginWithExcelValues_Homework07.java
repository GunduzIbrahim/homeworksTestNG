package tests;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.AllPages;
import utilities.Driver;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginWithExcelValues_Homework07 extends TestBase {

    /*

    ÖDEV-7 SELENIUM

        Soru 1: NEGATİF SENARYO

            Kullanıcı https://www.browserstack.com/users/sign_up sayfasına gider
            Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
            Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.
            Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERSİZ EMAİLLER Sheet’inden aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
            Kullanıcı password textbox kutusuna tıklar.
            INVALID olarak girilen MAIL adresini yarattığı hata mesajı “Invalid Email” validate(assert) edilir.

        Soru 2: NEGATİF SENARYO

            Kullanıcı https://www.browserstack.com/users/sign_up  sayfasına gider
            Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
            Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.
            Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERLİ EMAİLLER Sheet’inden aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
            Kullanıcı password textbox kutusuna EXCEL dosyasındaki GEÇERSİZ PASSWORD Sheetinden aldığı 6 karakterden kısa password’ü yazar.
            Kullanıcı “I agrre…” Checkbox’ına tıklar.
            INVALID olarak girilen PASSWORD’ün  yarattığı hata mesajı “At least 6 characters” validate(assert) edilir.

        Soru 3: POZİTİF SENARYO

            Kullanıcı https://www.browserstack.com/users/sign_up  sayfasına gider
            Kullanıcı Cookies seçeneğini Accept All seçeneği ile kabul eder.
            Kullanıcı Proje içerisindeki EXCEL dosyasından aldığı kullanıcı adı ve soyadını Full name TextBox’ına yazar.
            Kullanıcı Proje içerisindeki EXCEL dosyasındaki GEÇERLİ EMAİLLER Sheet’inden aldığı kullanıcı email adresini Business Email TextBox’ına yazar.
            Kullanıcı password textbox kutusuna EXCEL dosyasındaki GEÇERLİ PASSWORD Sheetinden aldığı şifreyi yazar.
            Kullanıcı “I agrre…” Checkbox’ına tıklar.
            Kullanıcı “Sign me up” butonuna tıklar.
            Başarılı bir şekilde kayıt yapıldığı Validate edilir.

     */
    AllPages allPages = new AllPages();

    @Test
    public void QuestionOne() throws IOException, InterruptedException {
        Driver.getDriver().get("https://www.browserstack.com/users/sign_up");
        allPages.loginTestPage.acceptAllButton.click();
        String fullName = readExcel.cellValueCall(0,1,0);
        System.out.println(fullName);
        allPages.loginTestPage.fullNameTextBox.sendKeys(fullName);
        Driver.wait(1);
        String eMail = readExcel.cellValueCall(2,1,0);
        System.out.println(eMail);
        allPages.loginTestPage.eMailTextBox.sendKeys(eMail);
        Driver.wait(1);
        allPages.loginTestPage.passwordTextBox.click();
        Driver.wait(1);
        String expectedMessage = "Invalid Email";
        String actualMessage = allPages.loginTestPage.forAssertionEmailTextBox.toString();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void QuestionTwo() throws IOException, InterruptedException {
        Driver.getDriver().get("https://www.browserstack.com/users/sign_up");
        allPages.loginTestPage.acceptAllButton.click();
        String fullName = readExcel.cellValueCall(0,1,0);
        System.out.println(fullName);
        allPages.loginTestPage.fullNameTextBox.sendKeys(fullName);
        Driver.wait(1);
        String eMail = readExcel.cellValueCall(1,1,0);
        System.out.println(eMail);
        allPages.loginTestPage.eMailTextBox.sendKeys(eMail);
        Driver.wait(1);
        String password = readExcel.cellValueCall(4,1,0);
        allPages.loginTestPage.passwordTextBox.sendKeys(password);
        Driver.wait(1);
        allPages.loginTestPage.checkBox.click();
        Driver.wait(1);
        String expectedMessage = "At least 6 characters";
        String actualMessage = allPages.loginTestPage.forAssertionPasswordTextBox.toString();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void QuestionThree() throws IOException, InterruptedException {
        Driver.getDriver().get("https://www.browserstack.com/users/sign_up");
        allPages.loginTestPage.acceptAllButton.click();
        String fullName = readExcel.cellValueCall(0,1,0);
        System.out.println(fullName);
        allPages.loginTestPage.fullNameTextBox.sendKeys(fullName);
        Driver.wait(1);
        String eMail = readExcel.cellValueCall(1,1,0);
        System.out.println(eMail);
        allPages.loginTestPage.eMailTextBox.sendKeys(eMail);
        Driver.wait(1);
        allPages.loginTestPage.checkBox.click();
        Driver.wait(1);
        String password = readExcel.cellValueCall(3,1,0);
        allPages.loginTestPage.passwordTextBox.sendKeys(password);
        Driver.wait(3);
        allPages.loginTestPage.signMeUpButton.click();
        Driver.wait(1);
//        allPages.loginTestPage.skipButton.click();
//        Driver.wait(1);
//        allPages.loginTestPage.iDontKnowButton.click();
//        Driver.wait(1);
//        allPages.loginTestPage.closeXButton.click();
//        Driver.wait(1);
        actions.moveToElement(allPages.loginTestPage.accountMenu).build().perform();
        Driver.wait(1);
        String expectedMessage = "Sign out";
        String actualMessage = allPages.loginTestPage.forAssertionAccountMenuSignOut.toString();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}
