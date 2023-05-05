package com.eurotech.step_definitions;

import com.eurotech.Pages.DashboardPage;
import com.eurotech.Pages.LoginPage;
import com.eurotech.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DashboardMenuStepDef {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
    @Then("The user should be able to see following menu")
    public void the_user_should_be_able_to_see_following_menu(List<String> expectedList) {
        System.out.println("Menu options size: "+ expectedList.size());
        System.out.println("Menu options: "+ expectedList);

        List<String > actualList= BrowserUtils.getElementsText(dashboardPage.menuList);
        Assert.assertEquals(expectedList,actualList);
    }

    @When("The user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userCredentials) {
        System.out.println("userCredentials = " + userCredentials);
        String username=userCredentials.get("username");
        String password=userCredentials.get("password");
        loginPage.login(username,password);

        String expectedMessage=userCredentials.get("message");
        Assert.assertTrue(dashboardPage.welcomeMessage.getText().contains(expectedMessage));
//        Assert.assertEquals(expectedMessage,dashboardPage.welcomeMessage.getText());
    }

    @When("The user clicks {string}")
    public void theUserClicks(String menuName) {
        dashboardPage.navigateMenu(menuName);
    }


    @Then("The user should see the experience added message")
    public void theUserShouldSeeTheExperienceAddedMessage() {
        Assert.assertTrue(dashboardPage.experienceAddedMessage.isDisplayed());
    }


}
