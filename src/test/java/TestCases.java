import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DraftPostPage;
import pages.LoginPage;
import pages.SubredditPage;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class TestCases {
    private WebDriver driver;
    private pages.LoginPage loginPage;
    private  pages.DraftPostPage draftPostPage;
    private  pages.SubredditPage subredditPage;
    private utils.ConfigReader configReader;
    @BeforeMethod
    public void setup() {
        configReader = new ConfigReader();
        System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(configReader.getRedditUrl());
        loginPage = new LoginPage(driver);
        subredditPage = new SubredditPage(driver);
        draftPostPage = new DraftPostPage(driver);
    }
    @Test
    public void subscribetoSubreddit(){
        loginPage.loginWithUsernameAndPassword(configReader.getUsername(),configReader.getPassword());
        driver.get(configReader.getSubredditUrl());
        subredditPage.clickOnJoinBtn();
        Assert.assertEquals(subredditPage.joinedName(),"Joined");
    }
    @Test
    public void createPost() throws InterruptedException {
        loginPage.loginWithUsernameAndPassword(configReader.getUsername(),configReader.getPassword());
        Thread.sleep(5000);
        driver.get(configReader.createPostURL());
        draftPostPage.enterTitle(configReader.getPost_title());
        draftPostPage.enterPostBody(configReader.getPostBody());
        draftPostPage.clickSaveAndDraftBtn();
        draftPostPage.clickOnDraftLabel();
        Assert.assertTrue(draftPostPage.draftPostdisplayed(),"The post is saved");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
