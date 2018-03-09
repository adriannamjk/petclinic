package pageobject.pages.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnersDataPage{
    @FindBy(xpath = "//table[@class='table table-striped']//tbody//tr//td//b")
    private WebElement nameField;

    public String getNameMessage() {
        return nameField.getText();
    }


}
