@TrainingFeature
  Feature: For QA Training

    @positive @Regression
    Scenario: Add wonderful quotes
      Given user open wonderful quotes page
      When user input "Quote" on quote field
      And user input "Argo" on author field
      And user input "aqua" on background field
      And user click on add quote
      Then user should see "Quote" and author "Argo" on panel and background color is "aqua"

      When user click table view
      And user hover blue button
      Then table is visible

      When user hover red button
      Then table is invisible

      When user click green button
      Then table is visible after "10" seconds



