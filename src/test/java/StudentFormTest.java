import manager.HelperBase;
import manager.HelperStudent;
import model.Gender;
import model.Hobby;
import model.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTest extends TastBase implements HelperStudent {
    @BeforeMethod
    public void precondition() {
        selectForms();
        selectPracticeForm();
    }

    @Test
    public void testFormPositive() {
        List<Hobby> hobbies = new ArrayList<Hobby>();
        hobbies.add(Hobby.MUSIC);
        hobbies.add(Hobby.READING);
        StudentDTO studentDTO = StudentDTO.builder()
                .firstName("Sarah")
                .lastName("Connor")
                .email("sarah@mail.com")
                .gender(Gender.FEMALE)
                .phone("1234567890")
                .birthday("6 29 2000")
                .subjects("Maths,Physics,Accounting,English")
                .hobbies(hobbies)
                .address("Main street, 5")
                .state("NCR")
                .city("Delhi")
                .build();
        hideFooter();
        //hideDiv();
        fillForm(studentDTO);
        submit();
       Assert.assertTrue(isElementPresent(By.xpath("//*[@id='closeLargeModal']")));
    }
    @AfterMethod
    public void postConditions() throws Exception {
        WebElement element=WD.findElement(By.xpath("//*[@id='closeLargeModal']"));
        scrollToElement(WD,element);
        //Assert.assertTrue(isElementPresent(By.xpath("//*[@id='closeLargeModal']")));
        //element.click();
        //click(By.xpath("//*[@id='closeLargeModal']"));
    }
}
