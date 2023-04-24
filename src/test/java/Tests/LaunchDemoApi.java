package Tests;

import Pages.VinDecoderPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class LaunchDemoApi {


   public AndroidDriver driver;

   public VinDecoderPage vinDecoderPage;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        ///Users/pokkulalaxminarsaiah/AndroidStudioProjects/VINDECODER/app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk
        File app = new File("/Users/pokkulalaxminarsaiah/AndroidStudioProjects/VinDecoderAssignment/app/build/outputs/apk/debug/app-debug.apk");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
       // options.setPlatformVersion("11.0");
        options.setApp(app.getAbsolutePath());
        options.setDeviceName("emulator-5554");
        options.setAutomationName("UIAutomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), options);
         vinDecoderPage=new VinDecoderPage(driver);
    }

    @Test(priority = 0)
    public void checkTextValue() throws InterruptedException {
        String expectedValue="VIN: JNKCA21A4XT770979\nVehicle Type: PASSENGER CAR\nPlant City: YOKOSUKA CITY\nPlant Company Name: Oppama Plant\nPlant Country: JAPAN\nPlant State: KANAGAWA\nMake: INFINITI\n";
        driver.findElement(AppiumBy.id("com.example.vindecoder:id/vinEditText")).sendKeys("JNKCA21A4XT770979");
        driver.findElement(AppiumBy.id("com.example.vindecoder:id/submitBtn")).click();
        Thread.sleep(3000);

        String actualValue=  driver.findElement(AppiumBy.id("com.example.vindecoder:id/vinDetailsTextView")).getText();
        Assert.assertEquals(actualValue,expectedValue);
    }
    @Test(priority = 1)
    public void invalidCase() throws InterruptedException
    {
        String expectedValue="VIN: abc\nVehicle Type: \nPlant City: \nPlant Company Name: \nPlant Country: \nPlant State: \nMake: \n";
        driver.findElement(AppiumBy.id("com.example.vindecoder:id/vinEditText")).sendKeys("abc");
        driver.findElement(AppiumBy.id("com.example.vindecoder:id/submitBtn")).click();
        Thread.sleep(3000);
        String actualValue=  driver.findElement(AppiumBy.id("com.example.vindecoder:id/vinDetailsTextView")).getText();
        Assert.assertEquals(actualValue,expectedValue);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

