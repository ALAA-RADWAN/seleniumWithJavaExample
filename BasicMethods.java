import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class BasicMethods {

  public static WebDriver driver = new ChromeDriver();
    private static By textfield;

    public static void main(String[] args) throws InterruptedException, IOException {
        openChrome("https://the-internet.herokuapp.com/upload");
        manageScreen();
       uploadFileBySendkeys("F:\\Java\\SeleniumQabilahPractice\\src\\main\\resources\\Screenshot1.png");


    }

    public static void openChrome(String Url){
                driver.get(Url);
    }
    public static void navigateTo(String Url){
        driver.navigate().to(Url);
    }
    public static void Forward(){
        driver.navigate().forward();
    }
    public static void Back(){driver.navigate().back();}
    public static void Refresh(){driver.navigate().refresh();}
    public static void manageScreen(){
        driver.manage().window().maximize();
          //driver.manage().window().fullscreen();
        //driver.manage().window().setPosition(new Point(500,500));
        //driver.manage().window().setSize(new Dimension(430,932));
    }
    public static void getTheURLOfThePage(){
        System.out.println("URL: " + driver.getCurrentUrl());
    }
    public static void printTitle(){
        String title = driver.getTitle();
        System.out.println("Title: " + title);
    }
    public static void sourceCode(){
        System.out.println("Source Code: " + driver.getPageSource());
    }
    public static void getWindowHandle(){
        System.out.println("Tab1 : " + driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("Tab2: " + driver.getWindowHandle());
    }
    public static void closeBrowser(){driver.close();}
    public static void quitBrowser(){driver.quit();}
    public static void acceptAlert(){
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    public static void dismissAlert(){
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
    }
    public static void Promot(){
        driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Alaa Automation");
        alert.accept();
    }
    public static WebElement byToWebElement(By locator) {
        return driver.findElement(locator);
    }
    public static void keysUsingSendKeys(){
        driver.findElement(By.id("target")).sendKeys(Keys.ARROW_LEFT);
    }
    public static void keysUsingActions(){
        By textfield = By.id("target");
        new Actions(driver).keyDown(byToWebElement(textfield),Keys.SHIFT)
                .sendKeys(byToWebElement(textfield), "alaa" )
                .build()
                .perform();
    }
    public static void scrollingUsingActions(){
        new Actions(driver).scrollToElement(byToWebElement(By.cssSelector("a[href='/tinymce']"))).perform();
        //driver.findElement(By.cssSelector("a[href='/tinymce']")).sendKeys("");
    }
    public static void takingScreenShot(String imageName) throws IOException {
        String path = "F:\\Java\\SeleniumQabilahPractice\\src\\main\\resources\\";
        //File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File scr = ((TakesScreenshot)byToWebElement(By.cssSelector("a[href='/abtest']"))).getScreenshotAs(OutputType.FILE);
        File target = new File(path + imageName + ".png");
        FileUtils.copyFile(scr,target);
    }
    public static void uploadFileBySendkeys(String path){
        driver.findElement(By.id("file-upload")).sendKeys(path);
    }

}
