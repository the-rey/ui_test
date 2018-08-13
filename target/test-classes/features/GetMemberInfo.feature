Feature: Get member info

  Narrative:
  As a merchant
  I want to get my existing members

  @member
  Scenario: create member response must equals with request
    Given [MemberSteps] create member request with userId 'hafiztesting@mailinator.com'
    When [MemberSteps] send get member request
    Then [MemberSteps] create member response must equals with request