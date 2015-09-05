package Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TutByPage {

    public static WebDriver instance;

    public static void open() {

        instance = new FirefoxDriver();
        instance.manage().window().maximize();
        instance.get("http://tut.by");
    }

    public static void goToWorkPage() {

        instance.findElement(By.linkText("Работа")).click();
    }

    public static void searchText(String findText) {

        instance.findElement(By.xpath("//input[@data-qa='vacancy-serp__query']")).sendKeys(findText);
        instance.findElement(By.xpath("//button[@data-qa='navi-search__button']")).click();
    }


    public static Integer checkCountForConditions(String findText) {

        Integer res = 0;
        List<WebElement> elements = instance.findElements(By.xpath("//div[@class='search-result-item__description']"));

        for (WebElement element : elements) {
            String text = element.getText().toLowerCase();

            if (text.contains(findText.toLowerCase())) {
                res++;
            }
        }
        return res;
    }

    public static void close() {
        instance.quit();
    }
}
