package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class CreateAccountTest_hmwrk3 {

//    sign in => create a new account
//    1 AssertFalse ile negatif testcase yazımı (checkbox üzerinden)
//    1 AssertTrue veya Equal ile pozitif test yazımı.
//    1 Tane login test case oluşturulması.
//    Ayrıca bu testlerden negatif testcase'in basamaklarını yani steplerini manuel olarak da yazın lütfen.
//    İlgili testcase in içine yorum satırı olarak en üste ekleyin.
//    Testcaseleri yeni TestNG Framework üzerinde yazınız.

    Faker faker = new Faker();

    @BeforeMethod
    public void testBefore(){
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Test
    public void assertFalseTest() {


        /*
        1. Chrome browser acilir ve https://courses.ultimateqa.com/ adresine gidilir.
        2. Acilan sayfada sag ust kosedeki 'Sign In' linki'ne girilir.
        3. Acilan sayfanin alt ortasindaki 'Create a new account' linki'ne girilir.
        4. Acilan sayfada First Name kutusuna isim girilir.
        5. Ayni sayfada Last Name kutusuna soyad girilir.
        6. Ayni sayfada Email kutusuna eposta adresi girilir.
        7. Ayni sayfada Password kutusuna sifre girilir.
        8. Ayni sayfada 'I have read and agree to the Terms of Use and Customer Privacy Policy' kutucugu "isaretlenmez".
        9. Ayni sayfada 'Sign Up' butonu tiklanir.
        10. Checkbox kutucugu isaretlenmedigi icin 'First Name' kismi uzerinde 'Terms must be accepted' hatasi geldigi dogrulanir.

         */

        WebElement signInLink = Driver.getDriver().findElement(By.partialLinkText("Sign In"));
        signInLink.click();


        WebElement createNewAccountButton = Driver.getDriver().findElement(By.partialLinkText("Create a new account"));
        createNewAccountButton.click();



        WebElement firstName = Driver.getDriver().findElement(By.id("user[first_name]"));
        firstName.sendKeys("Emiliano");


        WebElement lastName = Driver.getDriver().findElement(By.id("user[last_name]"));
        lastName.sendKeys("Gallardo");


        WebElement eMail = Driver.getDriver().findElement(By.id("user[email]"));
        eMail.sendKeys("emilianogallardo@abc.com");


        WebElement password = Driver.getDriver().findElement(By.id("user[password]"));
        password.sendKeys("abcdef1.");



        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();



        WebElement formErrorCheckedBox = Driver.getDriver().findElement(By.xpath("//li[@class='form-error__list-item']"));
        Assert.assertTrue(formErrorCheckedBox.getText().contains("Terms must be accepted"));


//        WebElement checkboxControl= Driver.getDriver().findElement(By.id("user[terms]"));
//        Assert.assertFalse(checkboxControl.isSelected());

    }

    @Test
    public void assertTrueTest() {

        WebElement signInLink = Driver.getDriver().findElement(By.partialLinkText("Sign In"));
        signInLink.click();


        WebElement createNewAccountLink = Driver.getDriver().findElement(By.partialLinkText("Create a new account"));
        createNewAccountLink.click();



        WebElement firstName = Driver.getDriver().findElement(By.id("user[first_name]"));
        firstName.sendKeys("Emiliano");


        WebElement lastName = Driver.getDriver().findElement(By.id("user[last_name]"));
        lastName.sendKeys("Gallardo");


        WebElement eMail = Driver.getDriver().findElement(By.id("user[email]"));
        eMail.sendKeys("emilianogallardo@abc.com");


        WebElement password = Driver.getDriver().findElement(By.id("user[password]"));
        password.sendKeys("abcdef1.");


        WebElement checkboxButton = Driver.getDriver().findElement(By.id("user[terms]"));
        checkboxButton.click();
        Assert.assertTrue(checkboxButton.isSelected());


        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();


        WebElement dashboardName = Driver.getDriver().findElement(By.xpath("//button[@class='dropdown__toggle-button']"));
        Assert.assertTrue(dashboardName.getText().contains("Emiliano"));
//        dashboardName.click();
//        WebElement signOut = Driver.getDriver().findElement(By.partialLinkText("Sign Out"));
//        signOut.click();


    }

    @Test
    public void loginTest (){

        WebElement signInLink = Driver.getDriver().findElement(By.partialLinkText("Sign In"));
        signInLink.click();

        WebElement userEmail = Driver.getDriver().findElement(By.xpath("//input[@id='user[email]']"));
        userEmail.sendKeys("emilianogallardo@abc.com");


        WebElement userPassword = Driver.getDriver().findElement(By.xpath("//input[@id='user[password]']"));
        userEmail.sendKeys("abcdef1.");


        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        signUpButton.click();


        WebElement dashboardName = Driver.getDriver().findElement(By.xpath("//button[@class='dropdown__toggle-button']"));
        Assert.assertTrue(dashboardName.getText().contains("Emiliano"));
        dashboardName.click();
        WebElement signOut = Driver.getDriver().findElement(By.partialLinkText("Sign Out"));
        signOut.click();


    }

    @AfterMethod
    public void testAfter(){
        Driver.closeDriver();
    }

}

