package com.testfan.UiStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 孙珑瑜
 * @version 20201021
 */
public class MtxStudy {
    WebDriver  driver;
    String name;
    @BeforeClass
    public void initDriver(){
        driver =new InitDriver().getDriver("chrome");
        driver.get("http://192.168.23.129/mtx/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String i = RandomUtil.getRndNumByLen(5);
        name = "sly"+i;
    }
    @AfterClass
    public void closeDrvier(){
        driver.close();
    }
   @Test
    public void Test1_register(){
        driver.findElement(By.linkText("注册")).click();
        driver.findElement(By.name("accounts")).sendKeys(name);
        driver.findElement(By.name("pwd")).sendKeys("123456");
        driver.findElement(By.cssSelector(".am-ucheck-checkbox.am-active.am-field-valid")).click();
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(3).click();
        String pageSource_re = driver.getPageSource();

    }
//    @Test
//    public void Test2_logout(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.linkText("退出")).click();
//    }

    //@Test
    public void Test3_login(){
        driver.findElement(By.linkText("登录")).click();
        driver.findElement(By.name("accounts")).sendKeys(name);
        driver.findElement(By.name("pwd")).sendKeys("123456");
        List<WebElement> elements = driver.findElements(By.tagName("button"));
        elements.get(2).click();
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("登录成功"));
    }



}
