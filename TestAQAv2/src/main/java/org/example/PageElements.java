package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.example.BaseTest.driver;

public class PageElements {
    //УРЛ адрес страницы
    public static final String URL_PAGE_ELEMENTS = "https://demoqa.com/text-box";
    //Левое навигационное меню
    public static final String PE_XP_BUTTON_TEXT_BOX = "//*[contains(text(),'Text Box')]";

    //Поля ввода для Text Box
    public static final String INPUT_TEXT_BOX_FULL_NAME = "userName";
    public static final String INPUT_TEXT_BOX_USER_EMAIL = "userEmail";
    public static final String INPUT_TEXT_BOX_CURRENT_ADDRESS = "currentAddress";
    public static final String INPUT_TEXT_BOX_PERMANENT_ADDRESS = "permanentAddress";
    //Поля ввода для Text Box - ошибка ввода
    public static final String PE_XP_INPUT_TEXT_BOX_USER_EMAIL =  "//input[@id='userEmail' and contains(@class, 'field-error')]";

    //Кнопка регистрации
    public static final String PE_XP_BUTTON_SUBMIT = "submit";

    //Отображаемые данные пользователя
    public static final String OUTPUT_USER_FULL_NAME = "//p[@id='name']";
    public static final String OUTPUT_USER_EMAIL = "//p[@id='email']";
    public static final String OUTPUT_USER_CURRENT_ADDRESS = "//p[@id='currentAddress']";
    public static final String OUTPUT_PERMANENT_ADDRESS = "//p[@id='permanentAddress']";

    //====================================================================================================== V2

    //Левое навигационное меню - действия
    @Step("pressTextBox")
    public void pressTextBox() {
        WebElement peButtonElements = driver.findElement(By.xpath(PageElements.PE_XP_BUTTON_TEXT_BOX));
        peButtonElements.click();
    }

    //Подменю Text Box - ввод данных
    @Step("inputData")
    public void inputData(String inputName, String inputData) {
        WebElement peInputName = driver.findElement(By.id(inputName));
        peInputName.click();
        peInputName.sendKeys(inputData);
    }

    //Подменю Text Box - поле Email - проверка ошибки
    @Step("inputUserEmailError")
    public static String inputUserEmailError() {
        try {
            WebElement peInputUserEmailError = driver.findElement(By.xpath(PageElements.PE_XP_INPUT_TEXT_BOX_USER_EMAIL));
            return "поле Email отработало корректно";
        } catch (NoSuchElementException e) {
            return "поле Email отработало некорректно";
        }
    }

    //Подменю Text Box - очистка данных
    @Step("clearData")
    public void clearData(String clearInputData) {
        WebElement clearData = driver.findElement(By.id(clearInputData));
        clearData.click();
        clearData.clear();
    }

    //Регистрация
    @Step("pressSubmit")
    public void pressSubmit() {
        WebElement peButtonSubmit = driver.findElement(By.id(PageElements.PE_XP_BUTTON_SUBMIT));
        peButtonSubmit.click();
    }

    //Отображаемые данные пользователя - проверка
    public static String onlyData(String outPutData) {
        try {
            WebElement peOutputData = driver.findElement(By.xpath(outPutData));
            String fullTextOutputData = peOutputData.getText();
            return fullTextOutputData.split(":")[1].trim();
        } catch (NoSuchElementException e) {
            return "элемент отсутствует";
        }
    }
}
