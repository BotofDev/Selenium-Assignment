package com.softwaretestingboard.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class createWishListTests {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    private void Setup() {
        // Create Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        // maximise browser window
        driver.manage().window().maximize();
    }


    @Test
    public void createWishList() {
        // Starting The web driver with url
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

        WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
        username.sendKeys("qwerty1@hotmail.com");

        //    enter password
        WebElement password = driver.findElement(By.xpath("/html//input[@id='pass']"));
        password.sendKeys("ygSD5Zcy5vAjaYx");

        //click on login button
        WebElement loginbutton = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
        loginbutton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Add Elements to th wishlist afterlogin
        /*JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("var element = document.querySelector('locator'); element.value = 'whatever';");

*/
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])"))).perform();
        sleep(2000);
        driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[2]//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/div[@class='product-item-details']/div[@class='product-item-inner']/div[@class='product-item-actions']/div[@class='actions-secondary']/a[@title='Add to Wish List']")).click();

        //  WebElement addtowishlist = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[2]//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/div[@class='product-item-details']/div[@class='product-item-inner']/div[@class='product-item-actions']/div[@class='actions-secondary']/a[@title='Add to Wish List']"));
        //  WebElement addtowishlist = driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])"));
        //  addtowishlist.click();

        // Check if Sucess Message is shown in Website
        sleep(3000);
        WebElement sucessmessage = driver.findElement(By.xpath(".//div[contains(text(),'has been added to your Wish List')]"));
        String ActualMessage = sucessmessage.getText();
/*
        System.out.println(ActualMessage);
*/
        Assert.assertEquals("has been added to your Wish List", ActualMessage.substring(12, 44), "Both The Sucess and actual message are not matching ");


    }

    @AfterMethod(alwaysRun = true)
    private void TearDown() {
        driver.quit();
    }

    public void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
