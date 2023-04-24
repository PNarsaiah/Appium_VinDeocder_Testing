package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VinDecoderPage  {


     AndroidDriver driver;


    public VinDecoderPage(AndroidDriver driver) {

        try {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    @AndroidBy(id = "com.example.vindecoder:id/vinEditText")
     private   WebElement VIN;
    @AndroidBy(id = "com.example.vindecoder:id/submitBtn")
   private WebElement SUBMIT_BUTTON;

    @AndroidBy(id="com.example.vindecoder:id/vinDetailsTextView")
   private WebElement showApiSMS;

     public void enterVinNumber(String vin)
     {
         VIN.sendKeys(vin);
     }
     public void clickSubmitButton()
     {
         SUBMIT_BUTTON.click();
     }
     public WebElement showText()
     {
          return showApiSMS;
     }


     public void waitUntilElementContainsText(WebElement element)
     {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(showApiSMS));
     }




}
