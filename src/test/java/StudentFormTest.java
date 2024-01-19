import manager.HelperBase;
import manager.HelperStudent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TastBase implements HelperStudent {
    @BeforeMethod
    public void precondition(){
        selectForms();
        selectPracticeForm();
    }

    @Test
    public void test(){

    }
}
