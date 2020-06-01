package atj;

import java.math.BigDecimal;

public class CalcK {

	private String value = "0";
	private String firstNumber = "";
	private String secondNumber = "";
	private String operation;

	private boolean haveFirstNumber;
	private boolean haveOperation;
	private boolean afterEqual;

	public String getValue() {
		return value;
	}

	public void addNewStringToNumberOne(String newInput) {
		firstNumber += newInput;
	}

	public void addNewStringToNumberTwo(String newInput) {
		secondNumber += newInput;
	}

	public void caclulate(String input) {

		switch (input) {
		case "C":
			value = "0";
			firstNumber = "";
			secondNumber = "";
			haveFirstNumber = false;
			afterEqual = false;
			break;
		case "=":
			if (haveFirstNumber && haveOperation) {
				countResult(firstNumber, secondNumber, operation);
				haveOperation = false;
				firstNumber = value;
				secondNumber = "";
				afterEqual = true;

			}
			break;

		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case "0":
			if(afterEqual) {
				haveFirstNumber = false;
				firstNumber= "";
			}
			if (!haveFirstNumber) {
				addNewStringToNumberOne(input);
				value = firstNumber;
			} else {
				addNewStringToNumberTwo(input);
				value = firstNumber + " " + operation + " " + secondNumber;
			}
			afterEqual = false;
			break;
		case "+":
		case "-":
		case "*":
		case "/":
			if (!haveOperation) {
				operation = input;
				haveOperation = true;
				haveFirstNumber = true;
				value = firstNumber + " " + operation;
			} else if (haveFirstNumber) {
				countResult(firstNumber, secondNumber, operation);
				firstNumber = value;
				haveFirstNumber = true;
				operation = input;
				value = firstNumber + " " + operation;
				secondNumber = "";
				haveOperation = true;
			}
			afterEqual = false;
			break;

		// cd case ..... sqrt % +/-

		}
	}

	private void countResult(String firstNumber, String secondNumber, String operation) {

		switch (operation) {
		case "+":
			value = String.valueOf((new BigDecimal(firstNumber).add(new BigDecimal(secondNumber))));
			break;
		case "-":
			value = String.valueOf((new BigDecimal(firstNumber).subtract(new BigDecimal(secondNumber))));
			break;
		case "*":
			value = String.valueOf((new BigDecimal(firstNumber).multiply(new BigDecimal(secondNumber))));
			break;
		case "/":
			value = String.valueOf((new BigDecimal(firstNumber).divide(new BigDecimal(secondNumber))));
			break;
		}

	}

}
