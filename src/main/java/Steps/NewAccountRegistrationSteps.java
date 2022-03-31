package Steps;

import Pages.LandingPage;
import Pages.LogInPage;
import Pages.RegistrationAccountPage;
import Utils.DataInMyTest;
import Utils.RandomGen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NewAccountRegistrationSteps {

    WebDriver driver;

    @Given("User open browser with {string}")
    public void userOpenBrowserWith(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("User click Sign in and then - No account? Create one here and feeling registration form  and click Save")
    public void userRegistration(){
        LandingPage onlandingPage = new LandingPage(driver);
        LogInPage onlogInPage = new LogInPage(driver);
        RegistrationAccountPage onregistrationAccountPage = new RegistrationAccountPage(driver);

        onlandingPage.clickOnSingIn();
        onlogInPage.clickOnNoAccount();


//        double a = Math.random();
//
//        String myEmail = ("vitalii" + a + "@hotmail.com");
//        String myPassWord = ("pass"+ a);

        RandomGen randomGen = new RandomGen();
        DataInMyTest dataInMyTest = new DataInMyTest();

        String myEmail = randomGen.getMyEmailGen();
        String myPassWord = randomGen.getMyPassWordGen();
        dataInMyTest.setMyEmailAfterGen(myEmail);
        dataInMyTest.setMyPassAfterGen(myPassWord);

        onregistrationAccountPage.feelFields(myEmail, myPassWord);


    }

    @Then("User account are added")
    public void userAccountAreAdded() {
    }

    @And("user close page")
    public void userClosePage() {
       // driver.quit();
    }
}
