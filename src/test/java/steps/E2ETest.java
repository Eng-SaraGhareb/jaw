package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.*;

import utilities.Helper;
import java.time.Duration;


public class E2ETest {
    HomePage home;
    public static WebDriver driver;
    public final static int TIMEOUT = 120;

    @Before
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));

    }

    @Given("the user in the home page")
    public void the_user_in_the_home_page()
    {
        driver.get("https://subscribe.stctv.com/sa-ar");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://subscribe.stctv.com/sa-ar"));
    }
    @When("the user click on country button and choose “السعودية” then click on it")
    public void the_user_click_on_country_button_and_choose_السعودية_then_click_on_it() {
        home = new HomePage(driver);
        home.countryDisplaying();
        home.ksaSelection();
        Assert.assertTrue(home.countryNamebtn.getText().contains("السعودية"));
    }
    @Then("The subscription packages displayed successfully for ksa")
    public void the_subscription_packages_displayed_successfully_for_ksa() {
        Assert.assertTrue(home.lightOneprice.getText().contains("15"));
        Assert.assertTrue(home.standardOneprice.getText().contains("25"));
        Assert.assertTrue(home.premiumOneprice.getText().contains("60"));
        Assert.assertTrue(home.lightOnecurrency.getText().contains("ريال سعودي/شهر"));
    }


    @When("the user click on country button and choose “الكويت” then click on it")
    public void the_user_click_on_country_button_and_choose_الكويت_then_click_on_it() {
        home = new HomePage(driver);
        home.kuwaitSelection();
        Assert.assertTrue(home.countryNamebtn.getText().contains("الكويت"));
    }
    @Then("The subscription packages displayed successfully for kuwait")
    public void the_subscription_packages_displayed_successfully_for_kuwait() {
        Assert.assertTrue(home.lightSecondprice.getText().contains("1.2"));
        Assert.assertTrue(home.standardSecondprice.getText().contains("2.5"));
        Assert.assertTrue(home.premiumSecondprice.getText().contains("4.8"));
        Assert.assertTrue(home.lightOnecurrency.getText().contains("دينار كويتي/شهر"));
    }

    @When("the user click on country button and choose “البحرين” then click on it")
    public void the_user_click_on_country_button_and_choose_البحرين_then_click_on_it() {
        home = new HomePage(driver);
        home.bahrainSelection();
        Assert.assertTrue(home.countryNamebtn.getText().contains("البحرين"));
    }
    @Then("The subscription packages displayed successfully for bahrain")
    public void the_subscription_packages_displayed_successfully_for_bahrain() {
        Assert.assertTrue(home.lightThirdprice.getText().contains("2"));
        Assert.assertTrue(home.standardThirdprice.getText().contains("3"));
        Assert.assertTrue(home.premiumThirdprice.getText().contains("6"));
        Assert.assertTrue(home.lightOnecurrency.getText().contains("دينار بحريني/شهر"));
    }


    @After
    public void stopDriver()
    {
        driver.quit();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenshot(driver, result.getName());
        }
    }


}
