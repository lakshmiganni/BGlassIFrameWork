Feature: Login to Guntree

  Scenario Outline: Verify login with invalid credentials

    Given I navigate to Gumtree homepage
    When I click on Login/SinUp button
    Then I enter Email as "<Email>"
    And I enter Password as "<Password>"
    When I click on Login button
    Then I get the email error message as "<EmailErrorMessage>"
    And Password error message as "<PasswordErrorMessage>"
    And I click on Login button


    Examples:

    |Email|Password|EmailErrorMessage|PasswordErrorMessage|
    |  |   |Please enter a valid email address.| Too short. Please enter at least 6 characters.|
    |test |   |Please enter a valid email address.| Too short. Please enter at least 6 characters.|
    |  test@   |   | Please enter a valid email address. | Too short. Please enter at least 6 characters. |
    |  test@   | test  | Please enter a valid email address. | Too short. Please enter at least 6 characters. |




