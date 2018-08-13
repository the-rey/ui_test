@GetProjectFeature
Feature: Get Project

  @Positive
  Scenario: As A user I want to get data project list in Badak App
    Given [badak-app] prepare get project request data
    When [badak-app] send get project request
    Then [badak-app] the schema should be same
    And [badak-app] response time must be less than '2000' 'MILLISECONDS'