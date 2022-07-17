package com.techpanda.user;

import com.techpanda.common.Common_01_Register_End_User;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.navigation.PageGeneratorManager;
import pageObjects.user.UserHomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.UserRegisterPageObject;
import pageObjects.user.navigations.sideBar.UserMyDashboardPageObject;

public class Level_17_Share_Data extends BaseTest {
    WebDriver driver;
    UserHomePageObject homePage;
    UserLoginPageObject loginPage;
    UserMyDashboardPageObject myDashboardPage;
    UserRegisterPageObject registerPage;

    @Parameters({"browser"})
    @Test
    public void Login_01_Valid_Email_And_Password(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-condition - Step 01 : Click to My Account link to navigate to Login Page");
        loginPage = homePage.openLoginPage();

        log.info("Login_01 - Step 1: Input a valid email address: '" + Common_01_Register_End_User.userEmail + "'");
        loginPage.inputToEmailAddressTextbox(Common_01_Register_End_User.userEmail);

        log.info("Login_01 - Step 2: Input a valid password: '" + Common_01_Register_End_User.userPassword + "'");
        loginPage.inputToPasswordTextbox(Common_01_Register_End_User.userPassword);

        log.info("Login_01 - Step 3: Click to login button");
        myDashboardPage = loginPage.clickToLoginButton();

        log.info("Login_01 - Step 4: Verify whether the user name  is correct as expected as '" + Common_01_Register_End_User.firstName + " " + Common_01_Register_End_User.lastName + "'");
        verifyTrue(myDashboardPage.getUserInfoText().contains(Common_01_Register_End_User.firstName + " " + Common_01_Register_End_User.lastName));

        log.info("Login_01 - Step 5: Verify whether the user email is correct as expected as '" + Common_01_Register_End_User.userEmail + "'");
        verifyTrue(myDashboardPage.getUserInfoText().contains(Common_01_Register_End_User.userEmail));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
