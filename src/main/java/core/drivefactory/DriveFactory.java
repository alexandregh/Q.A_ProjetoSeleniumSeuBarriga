package core.drivefactory;

import core.properties.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriveFactory {
    private static WebDriver driver;
    private DriveFactory(){}

    public static WebDriver getDriver() {
        final String tipoDriver = "webdriver.chrome.driver";
        final String caminhoDriver = "src/main/resources/drivers/chromedriver-win64/chromedriver.exe";
        if (driver == null) {
            System.setProperty(tipoDriver, caminhoDriver);
            switch (Properties.browser) {
                case FIREFOX: driver = new FirefoxDriver(); break;
                case CHROME: driver = new ChromeDriver(); break;
                case EDGE: driver = new EdgeDriver(); break;
            }
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
