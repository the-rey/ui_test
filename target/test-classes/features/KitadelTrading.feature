@KitadelTradingFeature
Feature: basic trading function check

  @Positive
  Scenario: User Go To Bitcoin-IDR Trading
    Given user is on landing page
    When user clicked on sign in button
    And user input "reynaldocadangan+2@gmail.com" to email box
    And user input "Cadanganpass123" to password box
    And user clicked log in
    And user clicked skip
    Then user is on homepage

    When user clicked on Marketplace Tab
    Then user can see token sales
    And user can see exchange coin pairs

    When user clicked on bitcoin/idr pair
    Then user is on bitcoin trading page


