package Testscripts;

import TestData.Userdata;
import com.fox.Pages.AccountPage;
import com.fox.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    private String foxhomeurl ="https://www.fox.com";

    @BeforeSuite
    public void createDriver(){
        String current = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", current +"\\src\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(foxhomeurl);
    }

    @BeforeTest
    public void loginToFoxWebsite(){
        homePage = new HomePage(driver);
        AccountPage account = homePage.navigateToUserAccounts();
        account.clickOnSignIn();
        account.enterUsername(Userdata.username);
        account.enterPassword(Userdata.password);
        account.singInToAccount();
    }

    @AfterSuite
    public void closeEverything(){
        driver.quit();
    }



}
