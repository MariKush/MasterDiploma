Feature: Verify search goods functionality

  Background:
    Given I open ROZETKA home page

  @Automated
  Scenario: Verify that URL contains search word
    When I set IPhone value in Search field and press Enter
    Then I verify that URL contains IPhone

  @Automated
  Scenario: Verify that search results contains search word
    When I set iPhone value in Search field and press Enter
    Then I verify that search result contains iPhone word

  @Automated
  Scenario: Verify catalog empty message is displayed
    When I set wrongSearchWord value in Search field and press Enter
    Then I see catalog empty icon

  @Automated @DISABLED
  Scenario: This test should fail
    When I set wrongSearchWord value in Search field and press Enter
    Then I verify that search result contains iPhone word

  @Automated @DISABLED
  Scenario: This test should have undefined step
    When I set wrongSearchWord value in Search field and press Enter
    Then This step is undefined