Feature: After a deposit, the client balance is increased
  Scenario: client makes a deposit
    Given the client has $10 on his bank account
    When the client deposit $100 into the account
    Then the client has a balance of $110.0
