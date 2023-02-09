package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginSaveSearchLogoffTest_hmwrk2 {

    /*
                                    Gerekli bilgiler:
                        http://gcreddy.com/project/admin/login.php
                                    Username : gcreddy
                                    Password : Temp@2020

            Aşağıdaki manuel testcase’in steplerini otomate ediniz.
            TESTCASE STEPLERİ:
     */

    WebDriver driver = new FirefoxDriver();

    public LoginSaveSearchLogoffTest_hmwrk2(){

    }

    @Before
    public void setup() throws InterruptedException {

        //   1.	Kullanıcı http://gcreddy.com/project/admin/login.php sayfasına gider.

        this.driver.get("http://gcreddy.com/project/admin/login.php");
        this.driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @After
    public void tearDown(){

        //aktif sayfa kapatilir.
        this.driver.close();
    }

    @Test
    public void loginTest() throws InterruptedException {
        //   2.	Username textbox kutusuna kullanıcı adını girer.
        WebElement userName = this.driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("gcreddy");
        //   3.	Password textbox kutusuna kullanıcı şifresini girer.
        WebElement password = this.driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("Temp@2020");
        //   4.	Login butonuna tıklar.
        WebElement login = this.driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
        login.click();
        //   5.	Sol menü bar üzerniden Customers sekmesine tıklar.
        WebElement customers = this.driver.findElement((By.cssSelector("h3[id='ui-accordion-adminAppMenu-header-2']")));
        customers.click();
        //   6.	Açılan alt menüden Customers linkine tıklar.
        WebElement customersLink = this.driver.findElement(By.cssSelector("a[href='http://gcreddy.com/project/admin/customers.php']"));
        customersLink.click();

        //Kayit yapilacak isim daha once mevcut ise silinir.
//        WebElement searchText = driver.findElement(By.xpath("//input[@name='search']"));
//        searchText.sendKeys("Emiliano");
//        searchText.sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//        WebElement delete = this.driver.findElement(By.xpath("//a[@id='tdb3']"));
//        delete.click();
//        Thread.sleep(1000);
//        WebElement deleteAccept = this.driver.findElement(By.cssSelector("button#tdb2"));
//        deleteAccept.click();
//        Thread.sleep(3000);
//        WebElement reset = driver.findElement(By.xpath("//a[@id='tdb1']"));
//        reset.click();
//        Thread.sleep(3000);

        //   7.	Sag menü kutusnudaki Edit butonuna tıklar.
        WebElement editButton = this.driver.findElement(By.cssSelector("a#tdb1"));
        editButton.click();
        //   8.	Personal bilgileri içindeki Firstname textbox kutsuna ismini girer.
        WebElement firstName = this.driver.findElement(By.xpath("//input[@name='customers_firstname']"));
        firstName.clear();
        firstName.sendKeys("Emiliano");
        //   9.	Personal bilgileri içindeki Lastname textbox kutsuna soyismini girer.
        WebElement lastName = this.driver.findElement(By.xpath("//input[@name='customers_lastname']"));
        lastName.clear();
        lastName.sendKeys("Gallardo");
        //  10.	Personal bilgileri içindeki Date of Birth textbox kutsuna doğum tarihini girer.
        WebElement dateOfBirth = this.driver.findElement(By.xpath("//input[@id='customers_dob']"));
        dateOfBirth.clear();
        //  11.	Personal bilgileri içindeki E-Mail Address textbox kutsuna e-mail adresini girer.
        dateOfBirth.sendKeys("01/07/1976");
        WebElement eMail = this.driver.findElement(By.xpath("//input[@name='customers_email_address']"));
        eMail.clear();
        eMail.sendKeys("emiliGallard@xyz.com");
        //  12.	Company bilgileri içindeki Company name textbox kutusuna şirket ismini girer.
        WebElement company = this.driver.findElement(By.xpath("//input[@name='entry_company']"));
        company.clear();
        company.sendKeys("GALLARD CO");
        //  13.	Adres bilgileri içindeki Street textbox kutsuna sokak ismini girer.
        WebElement street = this.driver.findElement(By.xpath("//input[@name='entry_street_address']"));
        street.clear();
        street.sendKeys("Gianlucca Federico street");
        //  14.	Adres bilgileri içindeki Suburb textbox kutsuna belediye ismini girer.
        WebElement suburb = this.driver.findElement(By.xpath("//input[@name='entry_suburb']"));
        suburb.clear();
        suburb.sendKeys("Campi Bisenzio");
        //  15.	Adres bilgileri içindeki Post Code textbox kutsuna posta kutusu numarasını girer.
        WebElement postCode = this.driver.findElement(By.xpath("//input[@name='entry_postcode']"));
        postCode.clear();
        postCode.sendKeys("12345 GH");
        //  16.	Adres bilgileri içindeki City textbox kutsuna Şehir ismini girer.
        WebElement city = this.driver.findElement(By.xpath("//input[@name='entry_city']"));
        city.clear();
        city.sendKeys("Prato");
        //  17.	Adres bilgileri içindeki State textbox kutsuna posta kutusu Eyalet ismini girer.
        WebElement country = this.driver.findElement(By.xpath("//input[@name='entry_state']"));
        country.clear();
        country.sendKeys("Floransa");
        //  18.	Adres bilgileri içindeki Country dropdown menüsünden ülkesini seçer.
        WebElement dropDownCountry = driver.findElement(By.name("entry_country_id"));
        Select dropdown = new Select(dropDownCountry);
        dropdown.selectByValue("105");
        //  19.	Contact bilgileri içindeki Telephone Number textbox kutsuna telefon numarasını girer.
        WebElement telNumber = this.driver.findElement(By.xpath("//input[@name='customers_telephone']"));
        telNumber.clear();
        telNumber.sendKeys("+39 0123 456789");
        //  20.	Contact bilgileri içindeki Fax Number textbox kutsuna fax numarasını girer.
        WebElement faxNumber = this.driver.findElement(By.xpath("//input[@name='customers_fax']"));
        faxNumber.clear();
        faxNumber.sendKeys("+39 9876 543210");
        //  21.	Options bilgileri içindeki Newsletter dropdown menüsünden abonelik durumunu seçer.
        WebElement dropDownNewsletter = driver.findElement(By.name("customers_newsletter"));
        Select dropdown1 = new Select(dropDownNewsletter);
        dropdown1.selectByValue("0");
        //  22.	Save butonuna tıklar.
        WebElement save = this.driver.findElement(By.cssSelector("button#tdb1"));
        save.click();
        Thread.sleep(1000);
        //  23.	Sağ üst köşedeki SEARCH kutusuna kullanıcı ismini girer ve ENTER’a basar.
        WebElement FirstName = driver.findElement(By.xpath("//input[@name='search']"));
        FirstName.sendKeys("Emiliano");
        FirstName.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        //  24.	Tablodan çıkan kullanıcı ismi ve soy isminin doğruluğu teyit edilir.
        WebElement searchCorrectLastname = driver.findElement(By.xpath("(//td[@class='dataTableContent'])[1]"));
        String correctLastname = searchCorrectLastname.getText();
        Assert.assertTrue(correctLastname.contains("Gallardo"));
        WebElement searchCorrectFirstName = driver.findElement(By.xpath("(//td[@class='dataTableContent'])[2]"));
        String correctFirstName = searchCorrectFirstName.getText();
        Assert.assertTrue(correctFirstName.contains("Emiliano"));
        Thread.sleep(1000);
        //  25.	Sağ üst köşedeki Logoff tuşuna basılarak sayfadan çıkılır.
        WebElement logoff = driver.findElement(By.xpath("(//a[@class='headerLink'])[3]"));
        logoff.click();
        Thread.sleep(1000);
    }

}
