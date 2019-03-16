import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Lesson6Part2 {
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
        driver.get( "https://unicode-table.com/ru/");
        System.out.println("Q symbol " + driver.findElement (By.xpath("//li[@data-code='81']")).getText());
        System.out.println("& symbol " + driver.findElement(By.xpath("//li[@data-code='38']")).getText());
        System.out.println("A symbol "+driver.findElement(By.xpath("//li[@data-code='65']")).getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
