package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

// public class Registrhttps://mystore-testlab.coderslab.pl/index.php?controller=authentication&create_account=1

public class RegistrationAccountPage {
    private static WebDriver driver;
    Faker faker = new Faker();
    Random generator = new Random();


    public RegistrationAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void feelFields(String emailMy, String myPassWord){

        WebElement genderMr = driver.findElement(By.xpath("//*[text()='\n" +
                "              Mr.\n" +
                "            ']"));
        WebElement genderMrs = driver.findElement(By.xpath("//*[text()='\n" +
                "              Mrs.\n" +
                "            ']"));

        boolean gender = generator.nextBoolean();
        if (gender == true){
            genderMrs.click();
        }else{
            genderMr.click();
        }

        WebElement first_name = driver.findElement(By.name("firstname"));
        WebElement last_name = driver.findElement(By.name("lastname"));
        WebElement emailAdres = driver.findElement(By.name("email"));
        WebElement webPass = driver.findElement(By.name("password"));
        WebElement webSubmit = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));

        first_name.sendKeys(faker.name().firstName());
        last_name.sendKeys(faker.name().lastName());
        emailAdres.sendKeys(emailMy);
        webPass.sendKeys(myPassWord);
        webSubmit.click();

        System.out.println(emailMy);
        System.out.println(myPassWord);


    }

}



/*
    String[] name = new String[user];
    String[] lastname = new String[user];
    String[] pass = new String[user];
    String[] adress = new String[user];
    String[] code = new String[user];
    String[] city = new String[user];
    Faker faker = new Faker();
    Random generator = new Random();

        for (int i = 0; i < user; i++) {
        name[i] = faker.name().firstName();
        lastname[i] = faker.name().lastName();
        pass[i] = generator.nextInt(user) + faker.name().firstName() + generator.nextInt(user);
        adress[i] = faker.address().streetName() + faker.address().streetAddressNumber();
        code[i] = faker.address().zipCode();
        city[i] = faker.address().cityName();
        }
        for (int i = 0; i < user; i++){


        String firstName = name[generator.nextInt(user)];
        String lastName = lastname[generator.nextInt(user)];

        String Email = firstName + "." + lastName + generator.nextInt(user) + "@email.com";

        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        Thread.sleep(1000);

        WebElement singin = driver.findElement(By.className("user-info"));
        singin.click();
        Thread.sleep(1000);

        WebElement noaccount = driver.findElement(By.className("no-account"));
        noaccount.click();
        Thread.sleep(1000);
ds
        WebElement webfirstname = driver.findElement(By.name("firstname"));
        if (webfirstname.isDisplayed()) {
        webfirstname.sendKeys(firstName);
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement weblastname = driver.findElement(By.name("lastname"));
        if (weblastname.isDisplayed()) {
        weblastname.sendKeys(lastName);
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webEmail = driver.findElement(By.name("email"));
        if (webEmail.isDisplayed()) {
        webEmail.sendKeys(Email);//"Clarine.Rau0@email.com");
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webPass = driver.findElement(By.name("password"));
        if (webPass.isDisplayed()) {
        String Pass = pass[generator.nextInt(user)];
        webPass.sendKeys(Pass);
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webSubmit = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
        if (webSubmit.isEnabled()) {
        webSubmit.click();
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

       if (webSubmit.isDisplayed()==true);
        WebElement alarm = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[4]/div[1]/div"));
            if (alarm.isDisplayed() == true) {
                WebElement webPass1 = driver.findElement(By.name("password"));
                String Pass1 = pass[generator.nextInt(user)];
                webPass1.sendKeys(Pass1);
                WebElement webEmail1 = driver.findElement(By.name("email"));
                webEmail1.sendKeys(Long.toString(new java.sql.Timestamp(System.currentTimeMillis()).getTime()));
                WebElement webSubmit1 = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
                webSubmit1.click();
            }



        WebElement webUser = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
        if (webUser.isEnabled()) {
        webUser.click();
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webIconAdress = driver.findElement(By.xpath("//*[@id=\"address-link\"]/span/i"));
        if (webIconAdress.isEnabled()) {
        webIconAdress.click();
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webAdress = driver.findElement(By.name("address1"));
        if (webAdress.isDisplayed()) {
        String Adress = adress[generator.nextInt(user)];
        webAdress.sendKeys(Adress);
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webCode = driver.findElement(By.name("postcode"));
        if (webCode.isDisplayed()) {
        String postCode = code[generator.nextInt(user)];
        webCode.sendKeys(postCode);
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webCity = driver.findElement(By.name("city"));
        if (webCity.isDisplayed()) {
        String City = city[generator.nextInt(user)];
        webCity.sendKeys(City);
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webCountry = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]"));
        if (webCountry.isEnabled()) {
        webCountry.click();
        } else {
        System.out.println("Element nie jest wyswietlony");
        }

        WebElement webSubmitAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        if (webSubmitAddress.isEnabled()) {
        webSubmitAddress.click();
        } else {
        System.out.println("Element nie jest wyswietlony");
        }
        driver.quit();
        Thread.sleep(2000);
        }

        */