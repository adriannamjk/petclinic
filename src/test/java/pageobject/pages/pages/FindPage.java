package pageobject.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindPage{

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement findOwnerButton;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    private WebElement addOwnerButton;

    @FindBy(linkText = "has not been found")
    private WebElement textAfterTryingToSearch;

    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td//b")
    private WebElement nameField;


    public void enterOwner(String name){
        lastNameField.sendKeys(name);
    }

    public void clickOnFindButton(){
        findOwnerButton.click();
    }

    public void clickOnAddButton() {
        addOwnerButton.click();
    }





}
