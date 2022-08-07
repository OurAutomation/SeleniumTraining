Feature: Addition.feature
  Scenario Outline: I am adding two numbers
    Given The two numbers are "<firstNumber>" and "<secondNumber>"
    When Add the two numbers
    Then Print the sum of two numbers
    Examples:
      | firstNumber | secondNumber |
      | 1           | 2            |
      | 3           | 4            |
      | 5           | 6            |
      | 212         | 214          |
      | 1213        | "txt"        |

  Scenario Outline: I am adding the given numbers
    Given The given numbers are "<AllNumbers>"
    When Add all the numbers
    Then Print the sum of two numbers
    Examples:
      | AllNumbers                                      |
      | 1,12,3,1,5,454,6,1,65,496,56,2,65,65,6,"sravan" |