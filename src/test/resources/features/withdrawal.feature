Feature: Make a withdrawal
  Scenario: client makes a withdrawal then balance is decreased
    Given the client has $200 on his bank account
    When the client make a withdrawal of $10 from the account
    Then the client has a balance of $190.0

  Scenario: client try to withdraw when balance is 0
    Given the client has $0 on his bank account
    When the client make a withdrawal of $10 from the account
    Then the client has a balance of $0
