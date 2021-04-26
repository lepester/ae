package testClasses;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObject.BasePage;
import pageObject.MainPage;

import java.util.concurrent.TimeUnit;

public class VerifyListAdditional extends BasePage {

    @BeforeSuite(alwaysRun = true)
    public void setProps() {
        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(groups = { "exclude-group" })
    public void verifyListAdditional() {
        String expectedResult = "Напитки";
        String actualResult = "Напитки";

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .goToFoodPage();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

}
