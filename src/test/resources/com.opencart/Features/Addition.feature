Feature: Addition.feature
  Scenario: I am adding two numbers
    Given The two numbers are "1" and "2"
    When Add the two numbers
    Then Print the sum of two numbers
  Scenario: I am adding two different numbers
    Given The two numbers are "3" and "4"
    When Add the two numbers
    Then Print the sum of two numbers