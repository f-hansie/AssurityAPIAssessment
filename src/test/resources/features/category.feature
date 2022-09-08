@category_details_for_catalogue
Feature: Validation of get method for categories catalogue

  Scenario Outline: Send a valid Request to get Categories details for id 6327

    Given I send a request to the URL to get categories details
    When the response status is 200
    And the response must return name tag <name>
    And the response must return boolean value <canRelist>
    Then the response must return category description <description>

    Examples:
      | name           | description               | canRelist |
      | Carbon credits | Good position in category | true      |