package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class DraftPostPage extends PageBase{
    public DraftPostPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[text()=\"Title\"]")
    WebElement titleField;
    @FindBy(xpath = "//*[text()=\"Body\"]")
    WebElement postBodyfield;
    @FindBy(xpath = "//button[contains(@class, 'button-primary') and contains(text(), 'Save Draft')]\n")
    WebElement saveDraftBtn;
    @FindBy(xpath = "//span[@class='flex items-center gap-xs' and text()='Drafts']\n")
    WebElement draftLabel;
    @FindBy(xpath = "//*[contains(text(), 'Editing')]")
    WebElement daftPostRecod;

    public void enterTitle (String post_title){
        wait.until(ExpectedConditions.visibilityOf(titleField)).sendKeys(post_title);
    }
    public void enterPostBody (String postBody){
        wait.until(ExpectedConditions.visibilityOf(postBodyfield)).sendKeys(postBody);
    }
    public void clickSaveAndDraftBtn(){
        wait.until(ExpectedConditions.visibilityOf(saveDraftBtn)).click();
    }
    public void clickOnDraftLabel(){
         draftLabel.click();
    }
    public boolean draftPostdisplayed(){
        try {
            // Wait until the draft post is visible
            wait.until(ExpectedConditions.visibilityOf(daftPostRecod));
            return true;
        }catch (TimeoutException e) {
            // If the timeout exception is caught, it means the element was not found in time
            return false;
        }
    }
}