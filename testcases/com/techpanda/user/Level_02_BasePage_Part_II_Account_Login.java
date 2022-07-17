package com.techpanda.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_BasePage_Part_II_Account_Login {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        // Che giấu hàm khởi tạo
        basePage = BasePage.getBasePageInstance();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        basePage.openPageUrl(driver, "https://live.techpanda.org/");
    }

    @BeforeMethod
    public void beforeMethod() {
        basePage.clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
    }

    @Test
    public void Login_01_Empty_Email_Password() {
        basePage.sendkeyToElement(driver, "//input[@id='email']", "");
        basePage.sendkeyToElement(driver, "//input[@id='pass']", "");
        basePage.clickToElement(driver, "//button[@id='send2']");

        assertEquals(basePage.getElementText(driver, "//div[@id='advice-required-entry-email']"),
                "This is a required field.");
        assertEquals(basePage.getElementText(driver, "//div[@id='advice-required-entry-pass']"),
                "This is a required field.");
    }

    @Test
    public void Login_02_Invalid_Email() {
        basePage.sendkeyToElement(driver, "//input[@id='email']", "123@456.789");
        basePage.sendkeyToElement(driver, "//input[@id='pass']", "123456");
        basePage.clickToElement(driver, "//button[@id='send2']");
        assertEquals(basePage.getElementText(driver, "//div[@id='advice-validate-email-email']"),
                "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test(description = "Email not exist in application")
    public void Login_03_Incorrect_Email() {
        basePage.sendkeyToElement(driver, "//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
        basePage.sendkeyToElement(driver, "//input[@id='pass']", "123456");
        basePage.clickToElement(driver, "//button[@id='send2']");
        assertEquals(basePage.getElementText(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");
    }

    @Test(description = "Password less than 6 characters")
    public void Login_04_Invalid_Password() {
        basePage.sendkeyToElement(driver, "//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
        basePage.sendkeyToElement(driver, "//input[@id='pass']", "123");
        basePage.clickToElement(driver, "//button[@id='send2']");
        assertEquals(basePage.getElementText(driver, "//div[@id='advice-validate-password-pass']"),
                "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void Login_05_Incorrect_Password() {
        basePage.sendkeyToElement(driver, "//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
        basePage.sendkeyToElement(driver, "//input[@id='pass']", randomNumber() + "");
        basePage.clickToElement(driver, "//button[@id='send2']");
        assertEquals(basePage.getElementText(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");
    }

    @Test
    public void Login_06_Valid_Email_And_Password() {
        basePage.sendkeyToElement(driver, "//input[@id='email']", "automationfc.vn@gmail.com");
        basePage.sendkeyToElement(driver, "//input[@id='pass']", "123123");
        basePage.clickToElement(driver, "//button[@id='send2']");
        assertTrue(basePage
                .getElementText(driver,
                        "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")
                .contains("Automation FC"));
        assertTrue(basePage
                .getElementText(driver,
                        "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p")
                .contains("automationfc.vn@gmail.com"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999999);
    }

}
