package globalsqa;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class ManagerPage extends BaseSeleniumPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    private WebElement addCustomerBtn;

    @FindBy(css = "body > div > div > div.ng-scope > div > div.center > button:nth-child(3)")
    private WebElement customersBtn;

    public ManagerPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public AddCustomerPage goToAddCustomerPage(){
        addCustomerBtn.click();
        return new AddCustomerPage();
    }

    public ListCustomersPage goToListCustomersPage(){
        customersBtn.click();
        return new ListCustomersPage();
    }
}
