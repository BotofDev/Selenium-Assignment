package com.softwaretestingboard.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class logintests {

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    private void Setup()
    {
        // Create Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        // maximise browser window
        driver.manage().window().maximize();
    }
    @Test
    public void loginTests()
    {

        System.out.println("Starting Login Tests");

        // Starting The web driver with url
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

        WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
        username.sendKeys("qwerty1@hotmail.com");

        //   * enter password
        WebElement password = driver.findElement(By.xpath("/html//input[@id='pass']"));
        password.sendKeys("ygSD5Zcy5vAjaYx");

        //click on login button
        WebElement loginbutton = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
        loginbutton.click();
        sleep(3000);


        //Check if the url matches or not (Validation)

        String expectedurl ="https://magento.softwaretestingboard.com/";
        String actualurl = driver.getCurrentUrl();
        Assert.assertEquals(actualurl,expectedurl,"The url expeted and actual are not matching ");

    }





    public void sleep(long m)
    {
        try{
           Thread.sleep(m);
        }

        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    private void TearDown() {
        driver.quit();
    }
}
