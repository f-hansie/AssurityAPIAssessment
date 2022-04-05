Feature: Validation of get method

  @GetUserDetails
  Scenario Outline: Send a valid Request to get Categories details

    Given I send a request to the URL to get categories details
    Then the response will return id <id> ,name "<name>" and description "<description>"

    Examples:
      | id   | name           | description               |
      | 6327 | Carbon credits | Good position in category |