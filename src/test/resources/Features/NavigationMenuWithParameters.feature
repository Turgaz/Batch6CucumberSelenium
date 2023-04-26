@smoke
Feature: Navigate Menu with parameters

  Background:
    Given The user is on the login page
    When The user logs in using "eurotech@gmail.com" and "Test12345!" credentials
    Then The welcome message contains "Teacher"


  Scenario: Navigates Developer Menu
    And The user navigates to "Developers" Menu
    Then The user should be able to see header as "Filter Profiles by Skill or by Location"


  Scenario: Navigate Posts Menu
    And The user navigates to "All Posts" Menu
    Then The user should be able to see header as "Posts"


  Scenario: Navigate My Account Menu
#    Given The user is on the login page
#    When The user logs in using "eurotech@gmail.com" and "Test12345!" credentials
#    Then The welcome message contains "Teacher"
    And The user navigates to "My Account" Menu
    Then The user should be able to see header as "Dashboard"

#  @tarik
#  Scenario: Login as a Tarik
#    Given The user is on the login page
#    When The user enters "turgayakcay@gmail.com" and "TarikAsim0409" credentials
#    Then The welcome message contains "Tarik"



  Scenario Outline: Navigates menu options
    And The user navigates to "<MenuName>" Menu
    Then The user should be able to see header as "<Headers>"
    Examples:
      | MenuName   | Headers                                 |
      | Developers | Filter Profiles by Skill or by Location |
      | All Posts  | Posts                                   |
      | My Account | Dashboard                               |