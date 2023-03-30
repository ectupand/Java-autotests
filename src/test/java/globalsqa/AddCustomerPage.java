package globalsqa;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends BaseSeleniumPage {
    @FindBy(css="body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(1) > input")
    private WebElement fName;

    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(2) > input")
    private WebElement lName;

    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > div:nth-child(3) > input")
    private WebElement pCode;

    @FindBy(css="body > div > div > div.ng-scope > div > div.ng-scope > div > div > form > button")
    private WebElement submitBtn;

    public AddCustomerPage(){
        PageFactory.initElements(driver, this);
    }


    public AddCustomerPage insertFirstName(String fNameValue){
        fName.sendKeys(fNameValue);
        return this;
    }

    public AddCustomerPage insertLastName(String lNameValue){
        lName.sendKeys(lNameValue);
        return this;
    }

    public AddCustomerPage insertPostCode(String pCodeValue){
        pCode.sendKeys(pCodeValue);
        return this;
    }

    public void pressSubmitBtn(){
        submitBtn.click();
    }



}
