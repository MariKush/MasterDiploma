Feature: Verify search goods functionality

  Background:
    Given I open ROZETKA home page

  Scenario: Verify that URL contains search word
    When I set IPhone value in Search field and press Enter
    Then I verify that URL contains IPhone

  Scenario: Verify that search results contains search word
    When I set iPhone value in Search field and press Enter
    Then I verify that search result contains iPhone word

  Scenario: Verify catalog empty message is displayed
    When I set wrongSearchWord value in Search field and press Enter
    Then I see catalog empty message