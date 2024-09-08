package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "//input[(@name = \"username\")]")
    WebElement userNameField;
    @FindBy(xpath = "//input[(@name = \"password\")]")
    WebElement passwordField;
    public void loginWithUsernameAndPassword(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(userNameField)).click();
        userNameField.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).click();
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.ENTER);
    }
}
