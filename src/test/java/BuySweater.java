
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.junit.Test;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Scanner;



public class BuySweater {

    @Test

    public static void main(String[] args) throws Exception,InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");
        WebElement signInButton = driver.findElement(By.id("_desktop_user_info"));
        signInButton.click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        // zaloguje się na tego samego użytkownika z zadania 1

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement signInButtonLogin = driver.findElement(By.id("submit-login"));
        email.click();
        email.clear();
        email.sendKeys("vitalii0.7533215060600307@hotmail.com");
        password.click();
        password.clear();
        password.sendKeys("pass0.7533215060600307");
        signInButtonLogin.click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
        WebElement mainLogo = driver.findElement(By.id("_desktop_logo"));
        mainLogo.click();

        // wybierze do zakupu Hummingbird Printed Sweater (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement HPSweater = driver.findElement(By.className("thumbnail-container"));
        HPSweater.click();

        // wybierze rozmiar M

        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_product=2&id_product_attribute=9&rewrite=brown-bear-printed-sweater&controller=product#/1-size-s");
        WebElement sizeM = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]"));
        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        sizeM.click();
        Thread.sleep(1000);
        quantity.click();
        quantity.clear();

//        quantity.sendKeys("5");
//        Thread.sleep(1000);

//        Questions questions = new Questions();
//        int ilosc = questions.Questions1();
//        quantity.sendKeys(ilosc);

        // wybierze 5 sztuk według parametru podanego w teście
        // (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę sztuk (ot 1 do 5): ");
        String ilosc = scanner.nextLine();

        quantity.sendKeys(ilosc);
        Thread.sleep(3000);

        // dodaj produkt do koszyka,

        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCart.click();
        Thread.sleep(1500);

        // przejdzie do opcji - checkout,

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        proceedToCheckout.click();
        Thread.sleep(1000);

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show");
        WebElement checkoutProceed = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        checkoutProceed.click();

        // potwierdzi address (możesz go dodać wcześniej ręcznie),

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=order");
        WebElement continueButtonAdress = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        continueButtonAdress.click();

        // wybierze metodę odbioru - PrestaShop "pick up in store",

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=order");
        WebElement pickUpInStore = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/div/div[1]/div[1]/label/div"));
        WebElement continueButtonShipping = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        pickUpInStore.click();
        Thread.sleep(1000);
        continueButtonShipping.click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=order");

        // wybierze opcję płatności - Pay by Check
        // kliknie na "order with an obligation to pay",

        WebElement payByCheck = driver.findElement(By.xpath("//*[@id=\"payment-option-1-container\"]/label/span"));
        WebElement agreeTerms = driver.findElement(By.xpath("//*[@id=\"conditions-to-approve\"]/ul/li/div[2]/label"));
        WebElement orderButton = driver.findElement(By.id("payment-confirmation"));
        payByCheck.click();
        Thread.sleep(1000);
        agreeTerms.click();
        orderButton.click();

        // zrobi screenshot z potwierdzeniem zamówienia i kwotą.

        Thread.sleep(2000);
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(fpScreenshot.getImage(),"PNG",new File("C:\\CodersLab\\FullPageScreenshot.png"));
        driver.quit();

    }
}