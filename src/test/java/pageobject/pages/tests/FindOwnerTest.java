package pageobject.pages.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.pages.pages.FindPage;
import utils.driver.WebDriverCreators;
import utils.driver.WebDriverProvider;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FindOwnerTest{

    private static final String PAGE_URL = "http://localhost:8080/owners/find";

    private WebDriver driver;

    private FindPage ownersPage;


    @Before
    public void setUp() {

        driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
        driver.manage().window().maximize();

        ownersPage = PageFactory.initElements(driver,FindPage.class);

        driver.get(PAGE_URL);
    }

    @Test
    public void findOwnerTest(){

        String name = "Kowalska";

        ownersPage.enterOwner(name);
        ownersPage.clickOnFindButton();

        //brak assercji- wiem
    }
}
