Feature: print account statement

  Background:
    Given today date is "2023-12-14"

  Scenario: client ask to get the account statement
    Given the client deposit $200 into the account
    When the client make a withdrawal of $10 from the account
    And the client deposit $100 into the account
    Then the client receives
      | Date       | Amount | Balance |
      | 2023-12-14 | 200    | 200.0   |
      | 2023-12-14 | -10    | 190.0   |
      | 2023-12-14 | 100    | 290.0   |
