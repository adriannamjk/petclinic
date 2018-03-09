package pageobject.pages.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewOwnerPage{
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement telephoneField;

    @FindBy(xpath = "//button[@class='btn btn-default'][@type='submit']")
    private WebElement addNewOwnerButton;

    public void inputOwnerInformation(String firstName, String lastName, String address, String city, String telephone) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
        cityField.sendKeys(city);
        telephoneField.sendKeys(telephone);
    }


    public void clickOnNewOwnerButton() {
        addNewOwnerButton.click();
    }


}

