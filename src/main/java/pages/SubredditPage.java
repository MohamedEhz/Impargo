package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubredditPage extends PageBase{
    public SubredditPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@placeholder=\"Search Reddit\"]")
    WebElement searchField;
    @FindBy(xpath = "//button[text()=\"Join\"]")
    WebElement joinBtn;
    public void searchQAData(String qa){
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).click();
        searchField.sendKeys(qa);
    }
    public String getCurrentPageUrl() {
        // Return the current URL from the WebDriver instance
        wait.until(ExpectedConditions.urlContains("https://www.reddit.com/"));
        return driver.getCurrentUrl();
    }
    public void clickOnJoinBtn(){
        wait.until(ExpectedConditions.visibilityOf(joinBtn)).click();
    }
    public String joinedName(){
        return joinBtn.getText();
    }
}
