package scenarios;

import static constants.NativeMobileTestConstants.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"})
    public void testSuccessfulSingIn()
        throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        //Registration activity

        getIPageObject().getElement(REGISTER_BUTTON).click();

        getIPageObject().getElement(REGISTER_EMAIL_FIELD)
                  .sendKeys(EMAIL);

        getIPageObject().getElement(REGISTER_USERNAME_FIELD)
                  .sendKeys(USERNAME);

        getIPageObject().getElement(REGISTER_PASSWORD_FIELD)
                  .sendKeys(PASSWORD);

        getIPageObject().getElement(REGISTER_CONFIRM_PASSWORD_FIELD)
                  .sendKeys(PASSWORD);

        getDriver().hideKeyboard();

        getIPageObject().getElement(REGISTER_NEW_ACCOUNT_BUTTON).click();

        //SignIn Activity

        getIPageObject().getElement(LOGIN_FIELD)
                  .sendKeys(EMAIL);

        getIPageObject().getElement(PASSWORD_FIELD)
                  .sendKeys(PASSWORD);

        getIPageObject().getElement(SIGN_IN_BUTTON).click();


        //Budget Activity

        String activityName = getIPageObject().getElement(ACTIVITY).getText();
        assertEquals(activityName, EXPECTED_ACTIVITY, "Incorrect screen name");

        System.out.println("Android native test done");

    }
}
