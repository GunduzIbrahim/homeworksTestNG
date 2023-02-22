package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginTestPage {
    public LoginTestPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (id = "accept-cookie-notification")
    public WebElement acceptAllButton;

    @FindBy (xpath = "//input[@id='user_full_name']")
    public WebElement fullNameTextBox;

    @FindBy(xpath = "//input[@id='user_email_login']")
    public WebElement eMailTextBox;

    @FindBy (xpath = "//input[@id='user_password']")
    public WebElement passwordTextBox;

    @FindBy (xpath = "//span[text()='Invalid Email']")
    public WebElement forAssertionEmailTextBox;

    @FindBy (id="tnc_checkbox")
    public WebElement checkBox;
    @FindBy (xpath = "//span[text()='At least 6 characters']")
    public WebElement forAssertionPasswordTextBox;

    @FindBy(id="user_submit")
    public WebElement signMeUpButton;

    @FindBy (id="skip-button-screen-1")
    public WebElement skipButton;

    @FindBy (xpath = "//button[@class= 'choose-intent__container__options__skip']")
    public WebElement iDontKnowButton;
    @FindBy (xpath = "//button[@class='modal-parent-wrapper__close']")
    public  WebElement closeXButton;

    @FindBy (id="account-menu-toggle")
    public WebElement accountMenu;

    @FindBy (partialLinkText = "Sign out")
    public WebElement forAssertionAccountMenuSignOut;
}
