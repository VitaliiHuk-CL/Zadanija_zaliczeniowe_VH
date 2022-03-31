package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// https://mystore-testlab.coderslab.pl/index.php?controller=my-account
public class MyAccountPage {
    private static WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddAddress(){

        WebElement address = driver.findElement(By.id("addresses-link"));
        address.click();
    }
    public void clickCreateNewAddress(){

        WebElement createNewAddress = driver.findElement(By.xpath("//*[text()='Create new address']"));
        createNewAddress.click();
    }
    public String getFilledAddress() {
        //WebElement addressBox = driver.findElement(By.xpath("//div[@class='address-body']"));
        WebElement addressBox = driver.findElement(By.id("content"));
        return addressBox.getText();
    }

}
