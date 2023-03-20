package com.softwaretestingboard.magneto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class validateOrder {
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
    public void validatetests()
    {
        //Login
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        WebElement username = driver.findElement(By.xpath("/html//input[@id='email']"));
        username.sendKeys("qwerty1@hotmail.com");
        WebElement password = driver.findElement(By.xpath("/html//input[@id='pass']"));
        password.sendKeys("ygSD5Zcy5vAjaYx");
        WebElement loginbutton = driver.findElement(By.xpath("/html//form[@id='login-form']/fieldset[@class='fieldset login']//button[@name='send']/span[.='Sign In']"));
        loginbutton.click();
        sleep(3000);


        driver.findElement(By.xpath("/html/body[@class='cms-home cms-index-index page-layout-1column']//div[@class='panel wrapper']/div/ul[@class='header links']//span[@role='button']/button[@type='button']")).click();
        driver.findElement(By.xpath("/html/body[@class='cms-home cms-index-index page-layout-1column']//div[@class='panel wrapper']/div/ul[@class='header links']//div[@class='customer-menu']/ul[@class='header links']//a[@href='https://magento.softwaretestingboard.com/customer/account/']")).click();

        // Recent Order Clicking
        Actions hover = new Actions(driver);
        hover.moveToElement(driver.findElement(By.xpath("/html//table[@id='my-orders-table']/tbody/tr[1]/td[@class='col id']"))).perform();
        driver.findElement(By.xpath("//table[@id='my-orders-table']/tbody/tr[1]/td[6]/a[@href='https://magento.softwaretestingboard.com/sales/order/view/order_id/1274/']/span[.='View Order']")).click();
        sleep(5000);
        String ExpectedUrlInOrder= "https://magento.softwaretestingboard.com/sales/order/view/order_id/1274/";
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl, ExpectedUrlInOrder, "Actual Url is not same as the expected url");
        sleep(1000);

        // Order No Verification
        WebElement ActualOrderno = driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//span[@class='base']"));
        String actual = ActualOrderno.getText();
        Assert.assertEquals(actual,"Order # 000001274", "The expected and actual orders are not matching");





        // Print Order Verfication
        WebElement print= driver.findElement(By.xpath("/html//main[@id='maincontent']/div[@class='columns']//a[@href='https://magento.softwaretestingboard.com/sales/order/print/order_id/1274/']/span[.='Print Order']"));
        print.click();
        sleep(1000);

        //expected page
        String ExpectedUrlPrintOrder = "https://magento.softwaretestingboard.com/sales/order/view/order_id/1274/";
        String ActualUrl5 = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl5,ExpectedUrlPrintOrder, "Actual Url is not same as the expected url");
        sleep(1000);


    }
    @AfterMethod(alwaysRun = true)
    private void TearDown() {
        driver.quit();


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

}
