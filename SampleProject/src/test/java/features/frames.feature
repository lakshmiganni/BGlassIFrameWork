Feature: iFrame feature

  Scenario: Validating the Trustpilot reviews of gumtree website

    Given I navigate to Gumtree homepage
    When I scroll down to see the Trustpilot reviews
    Then I can see the reviews given by Trustpilot
    When I click on total reviews link
    Then A new trustpilot webpage is opened
    Then I can see the total reviews in trustpilot website
    And reviews listed in Trustpilot should match with the reviews in the Gumtree website


