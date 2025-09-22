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

    //Позитивный тест v2
    @Test
    public void positiveTest() {
        goElements();

        PageElements pe = new PageElements();
        pe.pressTextBox();

        pe.inputData(PageElements.INPUT_TEXT_BOX_FULL_NAME, DataTest.userFullName);
        pe.inputData(PageElements.INPUT_TEXT_BOX_USER_EMAIL, DataTest.userEmail);
        pe.inputData(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS, DataTest.userCurrentAddress);
        pe.inputData(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS, DataTest.userPermanentAddress);
        pe.pressSubmit();

        //Проверка
        String onlyFullName = PageElements.onlyData(PageElements.OUTPUT_USER_FULL_NAME);
        String onlyUserEmail = PageElements.onlyData(PageElements.OUTPUT_USER_EMAIL);
        String onlyCurrentAddress = PageElements.onlyData(PageElements.OUTPUT_USER_CURRENT_ADDRESS);
        String onlyPermanentAddress = PageElements.onlyData(PageElements.OUTPUT_PERMANENT_ADDRESS);
        System.out.println("Извлеченный текст: '"
            + onlyFullName + "'"
            + " '" +onlyUserEmail+ "' "
            + " '" +onlyCurrentAddress+ "' "
            + " '" +onlyPermanentAddress+ "' ");
        Assert.assertEquals(onlyFullName, userFullName);
        Assert.assertEquals(onlyUserEmail, userEmail);
        Assert.assertEquals(onlyCurrentAddress, userCurrentAddress);
        Assert.assertEquals(onlyPermanentAddress, userPermanentAddress);

        pe.clearData(PageElements.INPUT_TEXT_BOX_FULL_NAME);
        pe.clearData(PageElements.INPUT_TEXT_BOX_USER_EMAIL);
        pe.clearData(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS);
        pe.clearData(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS);
    }

    //Негативный тест 1 v2
    @Test
    public void negativeTestHollow() {
        goElements();

        PageElements pe = new PageElements();
        pe.pressTextBox();

        pe.inputData(PageElements.INPUT_TEXT_BOX_FULL_NAME, "");
        pe.inputData(PageElements.INPUT_TEXT_BOX_USER_EMAIL, "");
        pe.inputData(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS, "");
        pe.inputData(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS, "");
        pe.pressSubmit();

        //Проверка
        String onlyFullName = PageElements.onlyData(PageElements.OUTPUT_USER_FULL_NAME);
        String onlyUserEmail = PageElements.onlyData(PageElements.OUTPUT_USER_EMAIL);
        String onlyCurrentAddress = PageElements.onlyData(PageElements.OUTPUT_USER_CURRENT_ADDRESS);
        String onlyPermanentAddress = PageElements.onlyData(PageElements.OUTPUT_PERMANENT_ADDRESS);

        Assert.assertEquals(onlyFullName, "элемент отсутствует");
        Assert.assertEquals(onlyUserEmail, "элемент отсутствует");
        Assert.assertEquals(onlyCurrentAddress, "элемент отсутствует");
        Assert.assertEquals(onlyPermanentAddress, "элемент отсутствует");

        // Проверка ошибки поля Email
        String EmailError = PageElements.inputUserEmailError();
        Assert.assertEquals(EmailError, "поле Email отработало корректно");

    }

    //Негативный тест 2 v2
    @Test
    public void negativeTest() {
        goElements();

        PageElements pe = new PageElements();
        pe.pressTextBox();

        pe.inputData(PageElements.INPUT_TEXT_BOX_FULL_NAME, DataTest.userFullNameIncorrect);
        pe.inputData(PageElements.INPUT_TEXT_BOX_USER_EMAIL, DataTest.userEmailIncorrect);
        pe.inputData(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS, DataTest.userCurrentAddressIncorrect);
        pe.inputData(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS, DataTest.userPermanentAddressIncorrect);
        pe.pressSubmit();

        //Проверка
        String onlyFullName = PageElements.onlyData(PageElements.OUTPUT_USER_FULL_NAME);
        String onlyUserEmail = PageElements.onlyData(PageElements.OUTPUT_USER_EMAIL);
        String onlyCurrentAddress = PageElements.onlyData(PageElements.OUTPUT_USER_CURRENT_ADDRESS);
        String onlyPermanentAddress = PageElements.onlyData(PageElements.OUTPUT_PERMANENT_ADDRESS);

        Assert.assertEquals(onlyFullName, "элемент отсутствует");
        Assert.assertEquals(onlyUserEmail, "элемент отсутствует");
        Assert.assertEquals(onlyCurrentAddress, "элемент отсутствует");
        Assert.assertEquals(onlyPermanentAddress, "элемент отсутствует");

        // Проверка ошибки поля Email
        String EmailError = PageElements.inputUserEmailError();
        Assert.assertEquals(EmailError, "поле Email отработало корректно");

        pe.clearData(PageElements.INPUT_TEXT_BOX_FULL_NAME);
        pe.clearData(PageElements.INPUT_TEXT_BOX_USER_EMAIL);
        pe.clearData(PageElements.INPUT_TEXT_BOX_CURRENT_ADDRESS);
        pe.clearData(PageElements.INPUT_TEXT_BOX_PERMANENT_ADDRESS);
    }
}
