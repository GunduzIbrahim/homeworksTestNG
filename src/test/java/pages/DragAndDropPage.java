package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReUsableMethods;
import utilities.TestBase;

import java.util.List;

public class DragAndDropPage extends TestBase {
    public DragAndDropPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[text()='Reject All']")
    public WebElement rejectAllButton;

    @FindBy (xpath = "//span[text()='Reject']")
    public WebElement rejectButton;

    @FindBy(xpath = "//li[@id='credit2']")
    public WebElement sourceValueBank;

    @FindBy(xpath = "//ol[@id='bank']")
    public WebElement targetInDebitSideAccountLeft;

    @FindBy(xpath = "//li[@id='credit1']")
    public WebElement sourceValueSales;

    @FindBy(xpath = "//ol[@id='loan']")
    public WebElement targetInCreditSideAccountLeft;

    @FindBy(xpath = "//li[@id='fourth']")
    public WebElement sourceValue5000;

    @FindBy(xpath = "//ol[@id='amt7']")
    public WebElement targetInDebitSideAmountLeft;

    @FindBy(xpath = "(//li[@id='fourth'])[2]")
    public WebElement sourceValueSecond5000;

    @FindBy(xpath = "//ol[@id='amt8']")
    public WebElement targetInDebitSideAmountRight;

    @FindBy (id = "t7")
    public WebElement savedValueInTableDebitMovementResult;

    @FindBy (id = "t8")
    public WebElement savedValueInTableCreditMovementResult;

    @FindBy (xpath = "//a[@class='button button-green']")
    public WebElement dragAndDropFinallyResult;

}
