Feature: Verify filtering and sorting functionality in catalog

  Background:
    Given I open ROZETKA home page
    And I set iPhone value in Search field and press Enter

  Scenario: Verify that all goods prices greater than min cost
    When I set 30000 value in min cost field and press OK
    Then I verify that all prices greater than 30000

  Scenario: Verify that all goods prices less than max cost
    When I set 30000 value in max cost field and press OK
    Then I verify that all prices less than 30000

  Scenario: Verify cheap first sorting option of price
    When I choose cheap first sort option
    Then I verify that all goods are sorted in ascending order of price

  Scenario: Verify expensive first sorting option of price
    When I choose expensive first sort option
    Then I verify that all goods are sorted in descending order of price

  Scenario: Verify 64GB memory filtering
    When I choose 64GB option in memory filter
    Then I verify that all goods descriptions contains 65GB