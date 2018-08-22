package automationtest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWorkTest {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void userLoginTest() {
        driver.findElement(By.xpath("//span[@id='header_user_menu_parent']")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("annvolkova844@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("PASSWORD844");
        driver.findElement(By.xpath("//span[@class='exponea-close']")).click();
        driver.findElement(By.xpath("//button[@name='auth_submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='header_user_menu_parent']")).isDisplayed());
    }

    @Test
    public void openCategoryTest(){
        driver.findElement(By.xpath("//ul[@class='f-menu-l']/li[2]")).click();
        driver.findElement(By.xpath("//a[@class='pab-h3-link']")).click();
        driver.findElement(By.xpath("//span[@class='arrow-link-inner']")).click();

        Assert.assertEquals("https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/",driver.getCurrentUrl());
    }

    @Test
    public void addIntoCart(){
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/");
        driver.findElement(By.xpath("//div[@class='g-i-tile-i-title clearfix']")).click();
        driver.findElement(By.xpath("//button[@class='btn-link-i']")).click();
        driver.findElement(By.xpath("//a[@class='popup-close']")).click();
        driver.findElement(By.xpath("//a[contains(@class,'hub-i-link hub-i')]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(@href,'samsung_sm_a72')]")).isDisplayed());

    }

}

