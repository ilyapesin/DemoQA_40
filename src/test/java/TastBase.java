import manager.AppManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TastBase implements AppManager {
    @BeforeSuite
    public void setup(){
        init();
    }

    @AfterSuite
    public void stop(){
        tearDown();
    }
}
