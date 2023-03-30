package globalsqa;

import core.BaseSeleniumTest;
import helpers.TestValues;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;

public class XyzBankTest extends BaseSeleniumTest {
    @Test
    public void checkSuccessCreate() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertFirstName(TestValues.FIRST_NAME)
                .insertLastName(TestValues.LAST_NAME)
                .insertPostCode(TestValues.POST_CODE)
                .pressSubmitBtn();

        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert != null;
        Assert.assertTrue(alert.getText().contains(TestValues.SUCCESS_CREATE));
        alert.accept();
    }

    @Test
    public void checkFailCreateOnlyFirstName() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertFirstName(TestValues.FIRST_NAME)
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkFailCreateOnlyLastName() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertFirstName(TestValues.LAST_NAME)
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkFailCreateOnlyPostCode() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertFirstName(TestValues.POST_CODE)
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkFailCreateOnlyFNameLName() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertFirstName(TestValues.POST_CODE)
                .insertLastName(TestValues.LAST_NAME)
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkFailCreateOnlyFNamePCode() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertFirstName(TestValues.POST_CODE)
                .insertPostCode(TestValues.POST_CODE)
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkFailCreateOnlyLNamePCode() {
        new ManagerPage()
                .goToAddCustomerPage()
                .insertLastName(TestValues.LAST_NAME)
                .insertPostCode(TestValues.POST_CODE)
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkFailCreateOnEmptyFields() {
        new ManagerPage()
                .goToAddCustomerPage()
                .pressSubmitBtn();
        Alert alert = null;
        try{
            alert = driver.switchTo().alert();
        }catch(Exception ignored){
        }
        assert alert == null;
    }

    @Test
    public void checkOrderByFNameDesc() {
        boolean isSorted = new ManagerPage()
                .goToListCustomersPage()
                .sortByFirstNameDesc();
        Assert.assertTrue(isSorted);
    }

    @Test
    public void checkOrderByFNameAsc() {
        boolean isSorted = new ManagerPage()
                .goToListCustomersPage()
                .sortByFirstNameAsc();
        Assert.assertTrue(isSorted);
    }

    @Test
    public void checkFindExistingCustByFName(){
        String foundCustomer = new ManagerPage()
                .goToListCustomersPage()
                .findCustomer(TestValues.SEARCH_BY_F_NAME);
        Assert.assertEquals(TestValues.REAL_CUSTOMER, foundCustomer);
    }

    @Test
    public void checkFindExistingCustByLName(){
        String foundCustomer = new ManagerPage()
                .goToListCustomersPage()
                .findCustomer(TestValues.SEARCH_BY_L_NAME);
        Assert.assertEquals(TestValues.REAL_CUSTOMER, foundCustomer);
    }

    @Test
    public void checkFindExistingCustByPCode(){
        String foundCustomer = new ManagerPage()
                .goToListCustomersPage()
                .findCustomer(TestValues.SEARCH_BY_P_CODE);
        Assert.assertEquals(TestValues.REAL_CUSTOMER, foundCustomer);
    }

    @Test
    public void checkFindExistingCustByAccountNum(){
        String foundCustomer = new ManagerPage()
                .goToListCustomersPage()
                .findCustomer(TestValues.SEARCH_BY_ACCOUNT_NUMBER);
        Assert.assertEquals(TestValues.REAL_CUSTOMER, foundCustomer);
    }

    @Test
    public void checkFindNonexistentCustomer(){
        String foundCustomer = new ManagerPage()
                .goToListCustomersPage()
                .findCustomer(TestValues.SEARCH_NONEXISTENT_CUSTOMER);
        Assert.assertEquals("[]", foundCustomer);
    }
}
