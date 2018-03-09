package ddt;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.pages.pages.FindPage;
import pageobject.pages.pages.NewOwnerPage;
import pageobject.pages.pages.OwnersDataPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;
import static org.assertj.core.api.Assertions.*;



public class AddOwnerTest{
    @RunWith(DataProviderRunner.class)
    public static class AddNewOwner {

        private static final String URL = "http://localhost:8080/owners/find";

        private WebDriver driver;

        private FindPage findPage;
        private NewOwnerPage newOwnerPage;
        private OwnersDataPage ownersDataPage;


        @DataProvider
        public static Object[][] testAddNewOwner() {
            return new String[][]{
                    new String[]{"Anna", "Kowalska", "Agrarma 3", "Gdansk", "12435544", "Anna Kowalska"},
                    new String[]{"Jurek", "Jurkowski", "Grunwaldzka 5", "Gdańsk", "1234567", "Jurek Jurkowski"},

            };
        }

        @Before
        public void setUp() {

            driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();

            driver.manage().window().maximize();

            findPage = PageFactory.initElements(driver,FindPage.class);
            newOwnerPage = PageFactory.initElements(driver,NewOwnerPage.class);
            ownersDataPage = PageFactory.initElements(driver, OwnersDataPage.class);

            driver.get(URL);

        }

        @Test
        @UseDataProvider("testAddNewOwner")
        public void addNewOwner(String firstName, String lastName, String address, String city, String telephone, String nameField) {

            findPage.clickOnAddButton();
            newOwnerPage.inputOwnerInformation(firstName, lastName, address, city,telephone);
            newOwnerPage.clickOnNewOwnerButton();

            Assertions.assertThat(ownersDataPage.getNameMessage()).contains(nameField);

        }

        @After
        public void tearDown() {
            driver.close();
        }

    }
}

