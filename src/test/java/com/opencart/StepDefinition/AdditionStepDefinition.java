package com.opencart.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdditionStepDefinition {
    static int firstNumber = 0, secondNumber = 0;
    static int sum = 0;
    String[] numbers;

    @Given("The two numbers are {string} and {string}")
    public void takeTwoNumbers(String firstNumber, String secondNumber) {
        this.firstNumber = Integer.parseInt(firstNumber);
        this.secondNumber = Integer.parseInt(secondNumber);
    }

    @Given("The given numbers are {string}")
    public void givenNumbersAre(String allnumbers) {
        numbers = allnumbers.split(",");
    }

    @When("Add the two numbers")
    public void addTheTwoNumbers() {
        sum = firstNumber + secondNumber;
    }

    @When("Add all the numbers")
    public void addAllTheNumbers() {
        for (String s : numbers)
            sum += Integer.parseInt(s);
    }

    @Then("Print the sum of two numbers")
    public void printingTheSumOfTwoNumbers() {
        System.out.println("The sum of the two numbers is :: " + sum);
    }
}
