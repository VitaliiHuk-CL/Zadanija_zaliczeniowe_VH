package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// https://mystore-testlab.coderslab.pl/index.php
public class LandingPage {
    private static WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnSingIn(){
        WebElement singInLink = driver.findElement(By.className("user-info"));
        singInLink.click();
    }

}
