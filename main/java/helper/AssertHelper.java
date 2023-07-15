package helper;

import org.testng.asserts.SoftAssert;

public class AssertHelper {

    static SoftAssert sa = new SoftAssert();
    public static void verifyDisplay(Boolean display, String message){
        sa.assertTrue(display,message);
    }

    public static void verifyText(String actualText, String expectedText, String message){
        sa.assertEquals(actualText,expectedText,message);
    }

    public static void assertAll(){
        sa.assertAll();
    }
}
