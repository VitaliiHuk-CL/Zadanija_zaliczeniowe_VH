package Steps;

import Pages.LandingPage;
import Pages.LogInPage;
import Pages.MyAccountPage;
import Pages.NewAddressPage;
import Utils.DataInMyTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressSteps {
    WebDriver driver;

    @Given("User open page with {string}")
    public void userOpenPageWith(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("User click Sign in and then log in to system and click Create new address")
    public void userClickSignInAndAll() throws InterruptedException {
        LandingPage onlandingPage = new LandingPage(driver);
        LogInPage onlogInPage = new LogInPage(driver);
        DataInMyTest dataInMyTest = new DataInMyTest();
        MyAccountPage onmyAccountPage = new MyAccountPage(driver);


        onlandingPage.clickOnSingIn();
        onlogInPage.enterEmailPassAndSingIn(dataInMyTest.getMyEmailAfterGen(),dataInMyTest.getMyPassAfterGen());
        onmyAccountPage.clickAddAddress();
        onmyAccountPage.clickCreateNewAddress();

    }

    @And("User feel form  New address with {string}{string}{string}{string}{string} and click SAVE")
    public void userFeelFormNewAddress(String alias, String address, String postcode, String city, String phone) {
        NewAddressPage onNewAddressPage = new NewAddressPage(driver);
        onNewAddressPage.fillAddressForm(alias,address,postcode,city,phone);
        onNewAddressPage.selectCountry();
        onNewAddressPage.clickSaveBttn();
    }

    @Then("Success alert appears, comparing input and output data {string} {string} {string} {string} {string}>")
    public void checkSuccessAdd(String alias, String address, String postcode, String city, String phone) {
        MyAccountPage onmyAccountPage = new MyAccountPage(driver);
        String addressText = onmyAccountPage.getFilledAddress();
        System.out.println(addressText);


        Assert.assertTrue(addressText.contains(address));
        Assert.assertTrue(addressText.contains(alias));
        Assert.assertTrue(addressText.contains(postcode));
        Assert.assertTrue(addressText.contains(city));
        Assert.assertTrue(addressText.contains(phone));
    }

    @And("User close page")
    public void userClosePage() {
        // driver.quit();
    }

}
