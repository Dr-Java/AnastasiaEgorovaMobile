package scenarios;

import static constants.NativeMobileTestConstants.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import setup.BaseTest;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"})
    public void testSuccessfulSingIn()
        throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        /*Registration activity*/

        //Open registration page by clicking on register button
        getIPageObject().getElement(REGISTER_BUTTON).click();

        //Input register email
        getIPageObject().getElement(REGISTER_EMAIL_FIELD)
                  .sendKeys(EMAIL);

        //Input register username
        getIPageObject().getElement(REGISTER_USERNAME_FIELD)
                  .sendKeys(USERNAME);

        //Input register password
        getIPageObject().getElement(REGISTER_PASSWORD_FIELD)
                  .sendKeys(PASSWORD);

        //Confirm register password
        getIPageObject().getElement(REGISTER_CONFIRM_PASSWORD_FIELD)
                  .sendKeys(PASSWORD);

        // Hide keyboard to continue interactions
        getDriver().hideKeyboard();

        //Complete registration by clicking on register new account button
        getIPageObject().getElement(REGISTER_NEW_ACCOUNT_BUTTON).click();

        /*SignIn Activity*/

        //Input registered email
        getIPageObject().getElement(LOGIN_FIELD)
                  .sendKeys(EMAIL);

        //Input registered password
        getIPageObject().getElement(PASSWORD_FIELD)
                  .sendKeys(PASSWORD);

        //Perform login by clicking on sign in button
        getIPageObject().getElement(SIGN_IN_BUTTON).click();


        /*Budget Activity*/

        //Make sure I'm on the BudgetActivity page
        String activityName = getIPageObject().getElement(ACTIVITY).getText();
        assertEquals(activityName, EXPECTED_ACTIVITY, "Incorrect screen name");

        System.out.println("Android native test done");

    }
}
