package manager;

import org.openqa.selenium.By;

public interface HelperStudent extends HelperBase{

    default void selectForms(){
        click(By.xpath("//div[@class='category-cards']/div[2]"));

    }
    default void selectPracticeForm(){
        click(By.xpath("//span[.='Practice Form']"));
    }
}
