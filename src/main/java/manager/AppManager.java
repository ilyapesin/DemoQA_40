package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {
    WebDriver WD = new ChromeDriver();

    default void init(){
        WD.navigate().to("https://demoqa.com/");
        WD.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterSuite
    default void tearDown(){
      //WD.quit();
    }

}
