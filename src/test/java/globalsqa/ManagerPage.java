package globalsqa;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class ManagerPage extends BaseSeleniumPage {
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    private WebElement addCustomerBtn;

    public ManagerPage(){
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public AddCustomerPage goToAddCustomerPage(){
        addCustomerBtn.click();
        return new AddCustomerPage();
    }
}
