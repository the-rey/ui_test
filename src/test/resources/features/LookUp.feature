@LookUpFeature
Feature: LookUp A Definition

  @Positive @apple
  Scenario: Looking up the definition of 'apple'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'apple'
    Then they should see the definition 'A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.'

  @Positive
  Scenario: Looking up the definition of 'banana'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'banana'
    Then they should see the definition 'An elongated curved tropical fruit that grows in bunches and has a creamy flesh and a smooth skin'

  @Positive
  Scenario: Looking up the definition of 'kiwi'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'kiwi'
    Then they should see the definition 'A flightless bird of the genus Apteryx native to New Zealand.'

  @Positive
  Scenario: Looking up the definition of 'mango'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'mango'
    Then they should see the definition 'A tropical Asian fruit tree, Mangifera indica.'

  @Positive
  Scenario: Looking up the definition of 'pear'
    Given the user is on the Wikionary home page
    When the user looks up the definition of the word 'pear'
    Then they should see the definition 'An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.'