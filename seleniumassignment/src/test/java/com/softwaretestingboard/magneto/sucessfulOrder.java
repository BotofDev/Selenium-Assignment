package com.softwaretestingboard.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class sucessfulOrder {

    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    private void Setup() {
        // Create Driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        // maximise browser window
        driver.manage().window().maximize();
    }

    @Test
    public void orderSucessTest() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

        WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
        username.sendKeys("qwerty1@hotmail.com");

        //    enter password
        WebElement password = driver.findElement(By.xpath("/html//input[@id='pass']"));
        password.sendKeys("ygSD5Zcy5vAjaYx");

        //click on login button
        WebElement loginbutton = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
        loginbutton.click();

        // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        sleep(3000);

        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("(//span[@class='product-image-wrapper'])"))).perform();


        WebElement AddtoCart = driver.findElement(By.xpath("//button[@title='Add to Cart']/span[.='Add to Cart']"));
        AddtoCart.click();

        sleep(3000);

        //Adding Size and color;
        WebElement color = driver.findElement(By.id("option-label-size-143-item-168"));
        color.click();

        WebElement size = driver.findElement(By.id("option-label-color-93-item-50"));
        size.click();
        // Add to Cart Button
        driver.findElement(By.xpath("//div[@class='actions']//button[@title='Add to Cart']//span")).click();

        // Click on Cart Button
        driver.findElement(By.xpath("/html/body//div[@class='minicart-wrapper']/a[@href='https://magento.softwaretestingboard.com/checkout/cart/']")).click();
        sleep(3000);
        //Proceed to Checkout Button
        driver.findElement(By.id("top-cart-btn-checkout")).click();
        sleep(3000);

        driver.findElement(By.xpath("//div[@id='shipping-new-address-form']/div[@name='shippingAddress.company']//input[@name='company']")).sendKeys("Nextuple");

        driver.findElement(By.xpath("//div[@class='control']//input[@name='street[0]']")).sendKeys("3rd main road kormangal Near sbi office ");

        driver.findElement(By.xpath("/html//input[@name='city']")).sendKeys("Bengaluru");
        sleep(2000);

        // DropDown Element
        Select drpCountry = new Select(driver.findElement(By.name("country_id")));
        drpCountry.selectByVisibleText("India");

        Select drpState = new Select(driver.findElement(By.name("region_id")));
        drpState.selectByVisibleText("Karnataka");




    }

    @AfterMethod(alwaysRun = true)
    private void TearDown() throws InterruptedException {

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