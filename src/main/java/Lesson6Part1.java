import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Lesson6Part1 {
    private WebDriver driver;

    @Before
    public void setUp() {

        // If you want to disable infobars please use this code
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");

        // Initialize path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        // Initialize instance of ChromeDriver and add options
        driver = new ChromeDriver(options);

        // Set 10 second for implicitly wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize window
        driver.manage().window().maximize();
    }
    @Test

    public void testGetPriceTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.get( "https://supsystic.com/example/comparison-example/");
        String firstPrice = (driver.findElement(By.xpath("//div[contains(@class, 'ptsCol-2')]//span[contains (text(),'$') and contains(@style, 'line-through')]"))
                .getAttribute("textContent"));

        double firstPriceDouble = Double.parseDouble(firstPrice.substring(1));


        String secondPrice = (driver.findElement(By.xpath("//div[contains(@class, 'ptsCol-2')]//span[contains (text(),'$') and not (contains(@style, 'line-through'))]")).getAttribute("textContent"));

        double secondPriceDouble = Double.parseDouble(secondPrice.substring(1));


        double resultOfSubtraction = (firstPriceDouble-secondPriceDouble);
        System.out.println("Разница между ценами "+ resultOfSubtraction);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}