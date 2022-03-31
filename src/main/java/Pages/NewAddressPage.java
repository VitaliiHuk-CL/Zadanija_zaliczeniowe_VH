package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//https://mystore-testlab.coderslab.pl/index.php?controller=address

public class NewAddressPage {
    private static WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillAddressForm(String alias, String address, String postcode, String city, String phone) {

        WebElement aliasField = driver.findElement(By.name("alias"));
        WebElement addressField = driver.findElement(By.name("address1"));
        WebElement postcodeField = driver.findElement(By.name("postcode"));
        WebElement cityField = driver.findElement(By.name("city"));
        WebElement phoneField = driver.findElement(By.name("phone"));


        aliasField.sendKeys(alias);
        addressField.sendKeys(address);
        postcodeField.sendKeys(postcode);
        cityField.sendKeys(city);
        phoneField.sendKeys(phone);
    }

    public void selectCountry() {
        WebElement countryDropdown = driver.findElement(By.name("id_country"));
        Select dropdown = new Select(countryDropdown);
        dropdown.selectByVisibleText("United Kingdom");
    }

    public void clickSaveBttn() {
        WebElement saveBttn = driver.findElement(By.cssSelector(".btn.btn-primary.float-xs-right"));
        saveBttn.click();
    }

}
