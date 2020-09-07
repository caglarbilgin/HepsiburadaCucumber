package base;


import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    public static WebDriver driver;


    //Tüm testlerden önce ayarların yapıldı yer
    @Before
    public void setUp() {
        PropertyConfigurator.configure("properties/log4j.properties");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com");
        driver.manage().window().maximize();
    }

    //Tüm testlerden sonra browser'ın kapandığı yer
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
