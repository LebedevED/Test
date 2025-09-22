package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.example.BaseTest.driver;

public class PageHome {
    //УРЛ адрес страницы
    public static final String URL_PAGE_HOME = "https://demoqa.com";

    //Кнопки разделов
    public static final String PH_XP_BUTTON_ELEMENTS = "//div[@class='card-body']/*[contains(text(),'Elements')]";
    public static final String PH_XP_BUTTON_FORMS = "//*[contains(text(),'Forms')]";

    //Действия
    //Открыть страницу в браузере
    @Step("openPageHome")
    public void openPageHome (){
        driver.get(PageHome.URL_PAGE_HOME);
    }
    //Прейти в раздел: элементы
    @Step("goElements")
    public void goElements () {
        WebElement phButtonElements = driver.findElement(By.xpath(PageHome.PH_XP_BUTTON_ELEMENTS));
        phButtonElements.click();
    }
}
