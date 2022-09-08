Feature: Validation of get method

  @GetUserDetails
  Scenario Outline: Send a valid Request to get Categories details

    Given I send a request to the URL to get categories details
    When the response status is 200
    Then the response will return name <name>,canRelist <canRelist> and description <description>

    Examples:
      | name           | description               | canRelist |
      | Carbon credits | Good position in category | true      |