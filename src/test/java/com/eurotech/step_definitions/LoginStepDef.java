package com.eurotech.step_definitions;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user enters teacher credentials")
    public void the_user_enters_teacher_credentials() {

        loginPage.loginAsTeacher();

    }
    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {

        Assert.assertTrue(dashboardPage.welcomeMessage.getText().contains("Welcome"));
    }

    @When("The user enters student credentials")
    public void theUserEntersStudentCredentials() {

        System.out.println("I enter student username and password and click login button");
        loginPage.loginAsStudent();

    }

    @When("The user enters developer credentials")
    public void the_user_enters_developer_credentials() {

        System.out.println("I enter developer username and password and click button");
        loginPage.loginAsDeveloper();
    }

    @When("The user logs in using {string} and {string} credentials")
    public void theUserLogsInUsingAndCredentials(String username, String password) {

        System.out.println("username = " + username);
        System.out.println("password = " + password);

        loginPage.login(username,password);
    }

    @Then("The welcome message contains {string}")
    public void theWelcomeMessageContains(String expectedMessage) {

        System.out.println("expected Message= "+expectedMessage);
        Assert.assertTrue(dashboardPage.welcomeMessage.getText().contains(expectedMessage));
    }

    @When("The user enters {string} and {string} credentials")
    public void theUserEntersAndCredentials(String username, String password) {

        loginPage.login(username,password);
    }

    @When("The user logs in using false {string} and {string} credentials")
    public void the_user_logs_in_using_false_and_credentials(String username, String password) throws InterruptedException {

            System.out.println("username = " + username);
            System.out.println("password = " + password);
            loginPage.login(username, password);

        }

    @Then("The user should not be able to login")
        public void the_user_should_not_be_able_to_login () {

            Assert.assertTrue(loginPage.warningMessageAll.getText().contains("valid"));
    }

    @Then("The warning message contains {string}")
    public void theWarningMessageContains(String expectedMessage) {
//        String validationMessage=loginPage.passwordInput.getAttribute("validationMessage");
//        System.out.println("validationMessage = " + validationMessage);

        System.out.println("Actual Message = " + loginPage.getWarningMessage(expectedMessage));

        String actualMessage=loginPage.getWarningMessage(expectedMessage);
        Assert.assertEquals(expectedMessage,actualMessage);
    }



}