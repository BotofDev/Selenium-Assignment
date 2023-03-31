package com.softwaretestingboard.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class signUp {

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
    public void singUpTesting()
    {
        driver.get("https://magento.softwaretestingboard.com/");

        driver.findElement(By.xpath("//li[@class='authorization-link']/a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']")).click();

        // Create New Account Button

        driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//div[@class='block block-new-customer']/div[@class='block-content']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']/span[.='Create an Account']")).click();

        driver.findElement(By.id("firstname")).sendKeys("Chirag");
        driver.findElement(By.id("lastname")).sendKeys("Joshi");
        driver.findElement(By.id("email_address")).sendKeys("frazageudare-3509@yopmail.com");
        driver.findElement(By.id("password")).sendKeys("Chiragis10");
        driver.findElement(By.id("password-confirmation")).sendKeys("Chiragis10");

        driver.findElement(By.xpath("//form[@id='form-validate']//button[@title='Create an Account']/span[.='Create an Account']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod(alwaysRun = true)
    private void TearDown() {
        driver.quit();
    }

}
