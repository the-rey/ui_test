@OrderFeature
Feature: Order Feature

  @Positive @test1
  Scenario: Order using api until FP
    Given [x-cart] prepare delete pending cart request with properties data
    When [x-cart] send delete pending cart request
    Then [x-cart] delete pending cart response should be true
    Given [x-cart] prepare add to cart request with properties data
    When [x-cart] send add to cart request
    Then [x-cart] add to cart response should be true
    Then [x-cart] add to cart response has more or equal than 1 sku in cartItems
    Then [x-cart] add to cart response should have same item sku in cartItems
#    When [x-cart] send payOrder request
#    Then [x-cart] payOrder request response should be true


  @Positive
  Scenario: Order using api until FP with input data
    Given [x-cart] prepare delete pending cart with cartId 'hendri.antomy@gdn-commerce.com'
    When [x-cart] send delete pending cart request
    Then [x-cart] delete pending cart response should be true


  @TestTemplates
  Scenario: Hit pendingcart/payOrder API using templates
    Given [x-cart] prepare payOrder data
    When [x-cart] send payOrder request
    Then [x-cart] payOrder request response should be true




