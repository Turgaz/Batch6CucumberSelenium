package com.eurotech.Pages;

import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{

    @FindBy(id = "rcc-confirm-button")
    public WebElement iUnderstandButton;

    @FindBy(name = "email")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(id = "loginpage-form-btn")
    public WebElement loginButton;

    @FindBy(xpath = "//div[text()='Invalid Credentials!']")
    public WebElement warningMessage;

    @FindBy(xpath = "//div[text()='Please include a valid email!']")
    public WebElement warningMessage2;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement warningMessageAll;


    //@FindAll
    //To use multiple locator if at least one of them is matching it will find the web element.
    @FindAll({
            @FindBy(id = "loginpage-input-email"),
            @FindBy(name="emailfhfdjkhfjkdshfkjdshfjkdhjkfhdskj")})

    public WebElement usernameInputFindAll;

    //@FindBys
    // if the locators are matching with element then it will return it. And logic applies here
    @FindBys({
            @FindBy(xpath="//input[@type='email']"),
            @FindBy(id="loginpage-input-email")})

    public WebElement passwordInputFindBys;


    public void login(String username, String password){
        iUnderstandButton.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsTeacher(){
        String username = ConfigurationReader.get("usernameTeacher");
        String password = ConfigurationReader.get("passwordTeacher");
        login(username, password);
    }

    public void loginAsStudent(){
        String username = ConfigurationReader.get("usernameStudent");
        String password = ConfigurationReader.get("passwordStudent");
        login(username, password);
    }

    public void loginAsDeveloper(){
        String username = ConfigurationReader.get("usernameDeveloper");
        String password = ConfigurationReader.get("passwordDeveloper");
        login(username, password);

    }


    public String getWarningMessage(String expectedErrorMessage){
        String actualMessage=null;
        if(expectedErrorMessage.contains("@")){
            actualMessage=usernameInput.getAttribute("validationMessage");
        } else if (expectedErrorMessage.contains("characters")) {
            actualMessage=passwordInput.getAttribute("validationMessage");
        }else {
            actualMessage=warningMessageAll.getText();
        }
        return actualMessage;
    }


}