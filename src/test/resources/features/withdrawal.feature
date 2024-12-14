Feature: After a withdrawal, the client balance is decreased
  Scenario: client makes a withdrawal
    Given the client has $200 on his bank account
    When the client make a withdrawal of $10 from the account
    Then the client receives the balance $110.0

