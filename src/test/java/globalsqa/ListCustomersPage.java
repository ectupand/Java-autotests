package globalsqa;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCustomersPage extends BaseSeleniumPage {
    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > thead > tr > td:nth-child(1) > a")
    private WebElement firstName;

    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > div > table > tbody")
    private List<WebElement> tableBody;

    @FindBy(css = "body > div > div > div.ng-scope > div > div.ng-scope > div > form > div > div > input")
    private WebElement searchBar;


    public ListCustomersPage(){
        PageFactory.initElements(driver, this);
    }


    public String[] receiveSortedCustomerListDesc() {
        String[] splitRow = new String[5];
        for (WebElement table : tableBody) {
            splitRow = table.getText().split("\n");
            Arrays.sort(splitRow, Collections.reverseOrder());
        }
        return splitRow;
    }

    public boolean sortByFirstNameDesc(){
        String[] sortedCustomers = receiveSortedCustomerListDesc();
        String[] splitRow = new String[5];
        firstName.click();
        for (WebElement table : tableBody) {
            splitRow = table.getText().split("\n");
        }
        return Arrays.toString(splitRow).equals(Arrays.toString(sortedCustomers));
    }

    public String[] receiveSortedCustomerListAsc() {
        String[] splitRow = new String[5];
        for (WebElement table : tableBody) {
            splitRow = table.getText().split("\n");
            Arrays.sort(splitRow);
        }
        return splitRow;
    }

    public boolean sortByFirstNameAsc(){
        String[] sortedCustomers = receiveSortedCustomerListAsc();
        String[] splitRow = new String[5];
        firstName.click();
        firstName.click();
        for (WebElement table : tableBody) {
            splitRow = table.getText().split("\n");
        }
        return Arrays.toString(splitRow).equals(Arrays.toString(sortedCustomers));
    }

    public String findCustomer(String value){
        searchBar.sendKeys(value);
        String[] result = receiveListOnFindBy();
        System.out.println(Arrays.toString(result));
        return Arrays.toString(result);
    }

    public String[] receiveListOnFindBy(){
        String[] splitRow = new String[2];
        for (WebElement table : tableBody) {
            splitRow = table.getText().split("\n");
        }
        return splitRow;
    }
}
