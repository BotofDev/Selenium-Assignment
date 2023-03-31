package com.softwaretestingboard.magneto;

import org.openqa.selenium.By;
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

public class editWishLst {

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
    public void wishListEdit()
    {

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

        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])"))).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[2]//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/div[@class='product-item-details']/div[@class='product-item-inner']/div[@class='product-item-actions']/div[@class='actions-secondary']/a[@title='Add to Wish List']")).click();

        // Updating The WishList
        Actions hovering = new Actions(driver);
       hovering.moveToElement(driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])"))).perform();
       driver.findElement(By.xpath("//div[@class='product-item-actions']//a[@class='action edit']")).click();     // First Xpath

       sleep(5000);
       driver.findElement(By.xpath("//div[@id='product-options-wrapper']//div[@class='swatch-opt']/div[1]/div[@role='listbox']/div[2]")).click();
       driver.findElement(By.xpath("//div[@id='product-options-wrapper']//div[@class='swatch-opt']/div[2]/div[@role='listbox']/div[2]")).click();

       // Clicking on update Wislist
       driver.findElement(By.xpath("/html//main[@id='maincontent']//div[@class='product-addto-links']/a[1]/span[.='Update Wish List']")).click();

        sleep(5000);

        WebElement SucessMessage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div[.='Radiant Tee has been updated in your Wish List.']"));
        String ActualMessage = SucessMessage.getText();
        Assert.assertEquals("Radiant Tee has been updated in your Wish List.",ActualMessage,"The Sucess Message is not Matching ");





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
