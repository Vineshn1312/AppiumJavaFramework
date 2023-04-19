@theguardian
Feature: Verify the news article is valid by checking other sources

  @ValidateFirstNews
  Scenario Outline: Validate the first news in the guardian.com is valid
    Given I launch the url and navigate to '<Path>' section
#    When I select the first news in the guardians portal
#    And Search in google with the first news
#    Then I should see two or more article on same topic getting displayed

    Examples:
      | Path       |
      | /tone/news |

