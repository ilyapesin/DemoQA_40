package manager;

import lombok.Getter;
import model.Gender;
import model.Hobby;
import model.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public interface HelperStudent extends HelperBase{


    default void selectForms() {
        if (isElementPresent(By.id("adplus-anchor"))) {
            hideAds();
        }
            click(By.xpath("//div[@class='category-cards']/div[2]"));
    }
    default void selectPracticeForm(){
        click(By.xpath("//span[.='Practice Form']"));
    }
    default void fillForm(StudentDTO studentDTO){
        type(By.id("firstName"), studentDTO.getFirstName());
        type(By.id("lastName"), studentDTO.getLastName());
        type(By.id("userEmail"), studentDTO.getEmail());
        selectGender(studentDTO.getGender());
        type(By.id("userNumber"),studentDTO.getPhone());
        //type(By.id("dateOfBirthInput"),studentDTO.getBirthday());
        typeBdaySelect(studentDTO.getBirthday());
        addSubject(studentDTO.getSubjects());
        selectHobby(studentDTO.getHobbies());
        uploadPicture();
        type(By.id("currentAddress"),studentDTO.getAddress());
        typeState(studentDTO.getState());
        typeCity(studentDTO.getCity());

    }



    default  void selectGender(Gender gender) {
        if(gender.equals(Gender.MALE)){
            click(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals(Gender.FEMALE)) {
            click(By.xpath("//label[@for='gender-radio-2']"));

        }else{

            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }
    default void addSubject(String subject){
        String[] split = subject.split(",");
        String locator="subjectsInput";
        click(By.id(locator));
        for(String sub : split){
            WD.findElement((By.id(locator))).sendKeys(sub);
            WD.findElement((By.id(locator))).sendKeys(Keys.ENTER);
        }
    }
    default void selectHobby(List<Hobby> hobbies){
        for(Hobby hobby:hobbies){
            switch (hobby){
                case SORTS:
                    click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case READING:
                    click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case MUSIC:
                    click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }

    }
    default void typeState(String state) {
        WD.findElement((By.id("react-select-3-input"))).sendKeys(state);
        WD.findElement((By.id("react-select-3-input"))).sendKeys(Keys.ENTER);
    }

    default void typeCity(String city) {
        WD.findElement((By.id("react-select-4-input"))).sendKeys(city);
        WD.findElement((By.id("react-select-4-input"))).sendKeys(Keys.ENTER);
    }
    default void submit(){
        click(By.id("submit"));
    }
    default void uploadPicture(){
        WD.findElement((By.id("uploadPicture"))).sendKeys("/Users/ilyapesin/IdeaProjects/DemoQA_40/PngItem_573946.jpg");

    }
    default void typeBdaySelect(String day) {
        // 06 29 2000
        String[] split = day.split(" ");
        click(By.id("dateOfBirthInput"));
        new Select(WD.findElement(By.className("react-datepicker__month-select"))).selectByValue(""+(Integer.parseInt(split[0])-1));
        new Select(WD.findElement(By.className("react-datepicker__year-select"))).selectByValue(split[2]);
        By data=By.xpath("//div[.='" + split[1] + "']");
        List<WebElement> datas = WD.findElements(data);
        if(datas.size()>1 && Integer.parseInt(split[1])>15){
            datas.get(1).click();
        }else {
            datas.get(0).click();
        }
       // click(data);
    }
}
