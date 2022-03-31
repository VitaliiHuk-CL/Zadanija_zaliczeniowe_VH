package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account
public class LogInPage {
    private static WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnNoAccount(){
        WebElement noAccount = driver.findElement(By.className("no-account"));
        noAccount.click();
    }
    public void enterEmailPassAndSingIn(String myEmailOld, String myPassWordOld){
        WebElement webEmail = driver.findElement(By.name("email"));
        WebElement webPass = driver.findElement(By.name("password"));
        WebElement submitLogin = driver.findElement(By.id("submit-login"));


        webEmail.sendKeys(myEmailOld);
        webPass.sendKeys(myPassWordOld);
        submitLogin.click();
    }


}
