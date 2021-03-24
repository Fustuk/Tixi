package org.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class AppTest {
    public WebDriver driver;

    @Test
    public void RegisterValidData() throws InterruptedException {
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/register']")).click();
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Doe");
        driver.findElement(By.id("email")).sendKeys("JohnDoe123@email.com");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.id("has_agreed_to_tos")).click();
        driver.findElement(By.id("has_agreed_to_privacy_policy")).click();
        driver.findElement(By.xpath("(//span[contains(.,'Регистрация')])[3]")).click();
        driver.quit();
    }

    @Test
    public void RegisterInvalidEmail() throws InterruptedException {
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/register']")).click();
        driver.findElement(By.id("email")).sendKeys("IsThisValidEmail123");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.id("has_agreed_to_tos")).click();
        driver.findElement(By.id("has_agreed_to_privacy_policy")).click();
        driver.findElement(By.xpath("(//span[contains(.,'Регистрация')])[3]")).click();
        Thread.sleep(1000);

        boolean invalidEmail = driver.findElement(By.xpath("(//div[contains(@class,'invalid-feedback')])[3]")).isDisplayed();

        if (invalidEmail) {
            System.out.println("Invalid email Registration - Passed!");
        } else {
            assertFalse("Invalid email Registration - Failed!", true);
        }



        driver.quit();
    }
    @Test
    public void LoginValidData() throws InterruptedException {
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/login']")).click();
        driver.findElement(By.id("email")).sendKeys("JohnDoe@email.com");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.xpath("(//span[contains(.,'Вход')])[3]")).click();
        driver.close();

    }
    @Test
    public void LoginInvalidData() throws InterruptedException {
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/login']")).click();
        driver.findElement(By.id("email")).sendKeys("JohnDoe");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.xpath("(//span[contains(.,'Вход')])[3]")).click();
        Thread.sleep(1000);
        boolean invalidLogin = driver.findElement(By.xpath("(//div[contains(@class,'invalid-feedback ng-tns-c46-1')])[1]")).isDisplayed();

        if (invalidLogin) {
            System.out.println("Invalid Login Email - Passed!");
        } else {
            assertFalse("Invalid Login Email - Failed!", true);
        }
        driver.close();

    }
    @Test
    public void ChangePassword() throws InterruptedException {
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/login']")).click();
        driver.findElement(By.id("email")).sendKeys("doe343378@gmail.com");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.xpath("(//span[contains(.,'Вход')])[3]")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//button[contains(@class,'navbar-toggler ng-star-inserted')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(.,'Профил')]")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//i[contains(@class,'far fa-edit ng-tns-c52-3')]")).click();
        driver.findElement(By.id("old_password")).sendKeys("StrongPassword");
        driver.findElement(By.id("new_password")).sendKeys("StrongerPassword");
        Thread.sleep(300);
        driver.findElement(By.xpath("//span[@class='loader'][contains(.,'Запази')]")).click();
        driver.close();
    }
    @Test
    public void ChangeProfileInfo() throws InterruptedException {
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/login']")).click();
        driver.findElement(By.id("email")).sendKeys("doe343378@gmail.com");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.xpath("(//span[contains(.,'Вход')])[3]")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//button[contains(@class,'navbar-toggler ng-star-inserted')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[contains(.,'Профил')]")).click();
        Thread.sleep(750);
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.id("first_name"));
        action1.doubleClick(element1).perform();
        element1.sendKeys("Lorem");
        Actions action2 = new Actions(driver);
        WebElement element2 = driver.findElement(By.id("last_name"));
        action2.doubleClick(element2).perform();
        element2.sendKeys("Ipsum");
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Запази')]")).click();
        Thread.sleep(500);
        driver.close();
    }
    @Test
    public void LogOut()throws InterruptedException{
        System.setProperty("webriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sofia.mpass.bg/bg/");
        driver.findElement(By.xpath("//a[@href='/bg/login']")).click();
        driver.findElement(By.id("email")).sendKeys("doe343378@gmail.com");
        driver.findElement(By.id("password")).sendKeys("StrongPassword");
        driver.findElement(By.xpath("(//span[contains(.,'Вход')])[3]")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//button[contains(@class,'navbar-toggler ng-star-inserted')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@href='javascript:;'][contains(.,'Изход')]")).click();
    }
}
