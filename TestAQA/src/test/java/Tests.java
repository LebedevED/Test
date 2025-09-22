import io.qameta.allure.Step;
import org.example.BaseTest;
import org.example.DataTest;
import org.example.PageElements;
import org.example.PageHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.DataTest.*;


//@Test
public class Tests {

    @Step("goElements")
    public void goElements() {
        PageHome ph = new PageHome();
        ph.openPageHome();
        ph.goElements();
    }

    //Позитивный тест
    @Test
    public void positiveTest() {
        goElements();

        PageElements pe = new PageElements();
        pe.pressTextBox();
        pe.inputFullName(PageElements.INPUT_TEXT_BOX_FULL_NAME, DataTest.userFullName);
        pe.inputUserEmail(PageElements.INPUT_TEXT_BOX_USER_EMAIL, DataTest.userEmail);
        pe.inputCurrentAddress(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS, DataTest.userCurrentAddress);
        pe.inputPermanentAddress(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS, DataTest.userPermanentAddress);
        pe.pressSubmit();

        //Проверка
        String onlyFullName = PageElements.onlyFullName();
        String onlyUserEmail = PageElements.onlyUserEmail();
        String onlyCurrentAddress = PageElements.onlyCurrentAddress();
        String onlyPermanentAddress = PageElements.onlyPermanentAddress();
        System.out.println("Извлеченный текст: '"
                + onlyFullName + "'"
                + " '" +onlyUserEmail+ "' "
                + " '" +onlyCurrentAddress+ "' "
                + " '" +onlyPermanentAddress+ "' ");
        Assert.assertEquals(onlyFullName, userFullName);
        Assert.assertEquals(onlyUserEmail, userEmail);
        Assert.assertEquals(onlyCurrentAddress, userCurrentAddress);
        Assert.assertEquals(onlyPermanentAddress, userPermanentAddress);

        pe.clearFullName(PageElements.INPUT_TEXT_BOX_FULL_NAME);
        pe.clearUserEmail(PageElements.INPUT_TEXT_BOX_USER_EMAIL);
        pe.clearCurrentAddress(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS);
        pe.clearPermanentAddress(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS);
    }

    //Негативный тест 1
    @Test
    public void negativeTestHollow() {
        goElements();

        PageElements pe = new PageElements();
        pe.pressTextBox();

        pe.inputFullName(PageElements.INPUT_TEXT_BOX_FULL_NAME, "");
        pe.inputUserEmail(PageElements.INPUT_TEXT_BOX_USER_EMAIL, "");
        pe.inputCurrentAddress(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS, "");
        pe.inputPermanentAddress(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS, "");
        pe.pressSubmit();

        //Проверка
        String onlyFullName = PageElements.onlyFullName();
        String onlyUserEmail = PageElements.onlyUserEmail();
        String onlyCurrentAddress = PageElements.onlyCurrentAddress();
        String onlyPermanentAddress = PageElements.onlyPermanentAddress();

        Assert.assertEquals(onlyFullName, "элемент Имя отсутствует");
        Assert.assertEquals(onlyUserEmail, "элемент Email отсутствует");
        Assert.assertEquals(onlyCurrentAddress, "элемент текущий Адрес отсутствует");
        Assert.assertEquals(onlyPermanentAddress, "элемент постоянный Адрес отсутствует");

        // Проверка ошибки поля Email
        String EmailError = PageElements.inputUserEmailError();
        Assert.assertEquals(EmailError, "поле Email отработало корректно");

        // Проверка цвета бордера - вытаскивает не тот цвет
        //String actualBorderColor = pe.inputUserEmailHollow(PageElements.INPUT_TEXT_BOX_USER_EMAIL);
        //String expectedBorderColor = "rgb(255, 0, 0)";
        //System.out.println(actualBorderColor);
        //Assert.assertEquals(actualBorderColor, expectedBorderColor);
    }

    //Негативный тест 2
    @Test
    public void negativeTest() {
        goElements();

        PageElements pe = new PageElements();
        pe.pressTextBox();

        pe.inputFullName(PageElements.INPUT_TEXT_BOX_FULL_NAME, DataTest.userFullNameIncorrect);
        pe.inputUserEmail(PageElements.INPUT_TEXT_BOX_USER_EMAIL, DataTest.userEmailIncorrect);
        pe.inputCurrentAddress(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS, DataTest.userCurrentAddressIncorrect);
        pe.inputPermanentAddress(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS, DataTest.userPermanentAddressIncorrect);
        pe.pressSubmit();

        //Проверка
        String onlyFullName = PageElements.onlyFullName();
        String onlyUserEmail = PageElements.onlyUserEmail();
        String onlyCurrentAddress = PageElements.onlyCurrentAddress();
        String onlyPermanentAddress = PageElements.onlyPermanentAddress();

        Assert.assertEquals(onlyFullName, "элемент Имя отсутствует");
        Assert.assertEquals(onlyUserEmail, "элемент Email отсутствует");
        Assert.assertEquals(onlyCurrentAddress, "элемент текущий Адрес отсутствует");
        Assert.assertEquals(onlyPermanentAddress, "элемент постоянный Адрес отсутствует");

        // Проверка ошибки поля Email
        String EmailError = PageElements.inputUserEmailError();
        Assert.assertEquals(EmailError, "поле Email отработало корректно");

        pe.clearFullName(PageElements.INPUT_TEXT_BOX_FULL_NAME);
        pe.clearUserEmail(PageElements.INPUT_TEXT_BOX_USER_EMAIL);
        pe.clearCurrentAddress(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS);
        pe.clearPermanentAddress(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS);
    }
}
