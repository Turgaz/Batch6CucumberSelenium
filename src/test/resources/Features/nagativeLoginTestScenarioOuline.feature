Feature: Negativ Login Test


  Scenario Outline:Negative FALSE Login Test DevEx
    Given The user is on the login page
    When The user logs in using false "<username>" and "<password>" credentials
    Then The user should not be able to login
    Examples:
      | username          | password   |
      | eurotech@gmail.co | Test12345! |
      | eurotech@gmai     | Test12345! |

  @wip
  Scenario Outline:Negative Login Test DevEx
    Given The user is on the login page
    When The user logs in using false "<userType>" and "<password>" credentials
    Then The warning message contains "<message>"
    Examples:
      | userType           | password        | message                                                                                  |
      | eurotech@gmail.com | 1               | Please lengthen this text to 6 characters or more (you are currently using 1 character). |
      | eurotech           | 1               | Please include an '@' in the email address. 'eurotech' is missing an '@'.                |
      | eurotech@          | 1               | Please enter a part following '@'. 'eurotech@' is incomplete.                            |
      | eurotech@@@        | 1               | A part following '@' should not contain the symbol '@'.                                  |
      | eurotech@gmail.com | 126tfgdhfgdgfhd | Invalid Credentials                                                                      |
      | eurot@gmail        | 126tfgdhfgdgfhd | Please include a valid email!                                                            |


