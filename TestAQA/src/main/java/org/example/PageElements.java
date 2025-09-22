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

    //Левое навигационное меню - действия
    @Step("pressTextBox")
    public void pressTextBox() {
        WebElement peButtonElements = driver.findElement(By.xpath(PageElements.PE_XP_BUTTON_TEXT_BOX));
        peButtonElements.click();
    }

    //Подменю Text Box - ввод данных
    @Step("inputFullName")
    public void inputFullName(String fullName, String userFullName) {
        WebElement peInputFullName = driver.findElement(By.id(fullName));
        peInputFullName.click();
        peInputFullName.sendKeys(userFullName);
    }
    @Step("inputUserEmail")
    public void inputUserEmail(String UserEmail, String userEmail) {
        WebElement peInputUserEmail = driver.findElement(By.id(UserEmail));
        peInputUserEmail.click();
        peInputUserEmail.sendKeys(userEmail);
    }
    //Возвращает цвет рамки у поля Email -------------- в данный момент не используется
    @Step("inputUserEmailHollow")
    public String inputUserEmailHollow(String UserEmail) {
        WebElement peInputUserEmail = driver.findElement(By.id(UserEmail));
        return peInputUserEmail.getCssValue("border-top-color");
    }
    //----------------------------------------------------------------------------------
    @Step("inputUserEmailError")
    public static String inputUserEmailError() {
        try {
            WebElement peInputUserEmailError = driver.findElement(By.xpath(PageElements.PE_XP_INPUT_TEXT_BOX_USER_EMAIL));
            return "поле Email отработало корректно";
        } catch (NoSuchElementException e) {
            return "поле Email отработало некорректно";
        }
    }
    @Step("inputCurrentAddress")
    public void inputCurrentAddress(String CurrentAddress, String userCurrentAddress) {
        WebElement peInputCurrentAddress = driver.findElement(By.id(CurrentAddress));
        peInputCurrentAddress.click();
        peInputCurrentAddress.sendKeys(userCurrentAddress);
    }
    @Step("inputPermanentAddress")
    public void inputPermanentAddress(String PermanentAddress, String userPermanentAddress) {
        WebElement peInputPermanentAddress = driver.findElement(By.id(PermanentAddress));
        peInputPermanentAddress.click();
        peInputPermanentAddress.sendKeys(userPermanentAddress);
    }

    //Подменю Text Box - очистка данных
    @Step("clearFullName")
    public void clearFullName(String fullName) {
        WebElement peClearFullName = driver.findElement(By.id(fullName));
        peClearFullName.click();
        peClearFullName.clear();
    }
    @Step("clearUserEmail")
    public void clearUserEmail(String UserEmail) {
        WebElement peClearUserEmail = driver.findElement(By.id(UserEmail));
        peClearUserEmail.click();
        peClearUserEmail.clear();
    }
    @Step("ClearCurrentAddress")
    public void clearCurrentAddress(String CurrentAddress) {
        WebElement peClearCurrentAddress = driver.findElement(By.id(CurrentAddress));
        peClearCurrentAddress.click();
        peClearCurrentAddress.clear();
    }
    @Step("ClearPermanentAddress")
    public void clearPermanentAddress(String PermanentAddress) {
        WebElement peClearPermanentAddress = driver.findElement(By.id(PermanentAddress));
        peClearPermanentAddress.click();
        peClearPermanentAddress.clear();
    }

    //Регистрация
    @Step("pressSubmit")
    public void pressSubmit() {
        WebElement peButtonSubmit = driver.findElement(By.id(PageElements.PE_XP_BUTTON_SUBMIT));
        peButtonSubmit.click();
    }

    //Отображаемые данные пользователя - проверка
    public static String onlyFullName() {
        try {
            WebElement peOutputFullName = driver.findElement(By.xpath(PageElements.OUTPUT_USER_FULL_NAME));
            String fullTextOutputFullName = peOutputFullName.getText();
            return fullTextOutputFullName.split(":")[1].trim();
        } catch (NoSuchElementException e) {
            return "элемент Имя отсутствует";
        }
    }
    public static String onlyUserEmail() {
        try {
            WebElement peOutputUserEmail = driver.findElement(By.xpath(PageElements.OUTPUT_USER_EMAIL));
            String fullTextOutputUserEmail = peOutputUserEmail.getText();
            return fullTextOutputUserEmail.split(":")[1].trim();
        } catch (NoSuchElementException e) {
            return "элемент Email отсутствует";
    }
    }
    public static String onlyCurrentAddress() {
        try {
            WebElement peOutputCurrentAddress = driver.findElement(By.xpath(PageElements.OUTPUT_USER_CURRENT_ADDRESS));
            String fullTextOutputCurrentAddress = peOutputCurrentAddress.getText();
            return fullTextOutputCurrentAddress.split(":")[1].trim();
        } catch (NoSuchElementException e) {
            return "элемент текущий Адрес отсутствует";
        }
    }
    public static String onlyPermanentAddress() {
        try {
            WebElement peOutputPermanentAddress = driver.findElement(By.xpath(PageElements.OUTPUT_PERMANENT_ADDRESS));
            String fullTextOutputPermanentAddress = peOutputPermanentAddress.getText();
            return fullTextOutputPermanentAddress.split(":")[1].trim();
        } catch (NoSuchElementException e) {
            return "элемент постоянный Адрес отсутствует";
        }
    }
}
