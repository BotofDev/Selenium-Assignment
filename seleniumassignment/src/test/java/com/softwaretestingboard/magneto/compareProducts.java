package com.softwaretestingboard.magneto;

import io.netty.util.concurrent.AbstractScheduledEventExecutor;
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

import javax.swing.*;
import java.time.Duration;

public class compareProducts {
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
    public void compareProductTest() throws InterruptedException {

        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
        username.sendKeys("qwerty1@hotmail.com");
        WebElement password = driver.findElement(By.xpath("/html//input[@id='pass']"));
        password.sendKeys("ygSD5Zcy5vAjaYx");
        WebElement loginbutton = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
        loginbutton.click();
       WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        // Adding product 1 and Verifying
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/radiant-tee.html']/span[@class='product-image-container']/span[@class='product-image-wrapper']/img[@alt='Radiant Tee']"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[2]//ol[@class='product-items widget-product-grid']/li[1]/div[@class='product-item-info']/div[@class='product-item-details']/div[@class='product-item-inner']/div[@class='product-item-actions']/div[@class='actions-secondary']/a[@title='Add to Compare']")).click();
       Thread.sleep(5000);

        WebElement SucessMesage = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
        String ExpectedMessage = "You added product Radiant Tee to the comparison list";
        String ActualMessage = SucessMesage.getText();
        Assert.assertTrue(ActualMessage.contains(ExpectedMessage),"Both the messages are not matching ");

        // Adding product 2 and Verifying
        Actions hover1 = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//ol[@class='product-items widget-product-grid']/li[2]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/breathe-easy-tank.html']/span[@class='product-image-container']/span[@class='product-image-wrapper']/img[@alt='Breathe-Easy Tank']"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[2]//ol[@class='product-items widget-product-grid']/li[2]/div[@class='product-item-info']/div[@class='product-item-details']/div[@class='product-item-inner']/div[@class='product-item-actions']/div[@class='actions-secondary']/a[@title='Add to Compare']")).click();
        Thread.sleep(5000);
        WebElement SucessMesage1 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
        String ExpectedMessage1 = "You added product Breathe-Easy Tank to the comparison list";
        String ActualMessage1 = SucessMesage1.getText();
        Assert.assertTrue(ActualMessage1.contains(ExpectedMessage1),"Both the messages are not matching ");

        // Adding Product 3 and verifying
        Actions hover2 = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//ol[@class='product-items widget-product-grid']/li[3]/div[@class='product-item-info']/a[@href='https://magento.softwaretestingboard.com/argus-all-weather-tank.html']/span[@class='product-image-container']/span[@class='product-image-wrapper']/img[@alt='Argus All-Weather Tank']"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']/div[@class='column main']/div[2]//ol[@class='product-items widget-product-grid']/li[3]/div[@class='product-item-info']/div[@class='product-item-details']/div[@class='product-item-inner']/div[@class='product-item-actions']/div[@class='actions-secondary']/a[@title='Add to Compare']")).click();
        Thread.sleep(5000);

        WebElement SucessMesage2 = driver.findElement(By.xpath("//main[@id='maincontent']//div[@role='alert']/div/div"));
        String ExpectedMessage2 = "You added product Argus All-Weather Tank to the comparison list";
        String ActualMessage2 = SucessMesage2.getText();
        Assert.assertTrue(ActualMessage2.contains(ExpectedMessage2),"Both the messages are not matching ");









    }

    @AfterMethod(alwaysRun = true)
    private void TearDown() {
        driver.quit();
    }
}
