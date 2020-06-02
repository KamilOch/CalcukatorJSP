package atj;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
			if (haveFirstNumber && haveOperation && secondNumber.length() > 0) {

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
			if (afterEqual) {
				haveFirstNumber = false;
				firstNumber = "";
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
			} else if (haveFirstNumber && secondNumber.length() > 0) {
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

		case ".":
			if (!haveFirstNumber) {
				if (firstNumber.isEmpty()) {
					firstNumber = "0";
				}
				if (!firstNumber.contains(".")) {
					addNewStringToNumberOne(input);
					value = firstNumber;
				}
			} else {
				if (secondNumber.isEmpty()) {
					secondNumber = "0";
				}
				if (!secondNumber.contains(".")) {
					addNewStringToNumberTwo(input);
					value = firstNumber + " " + operation + " " + secondNumber;
				}
			}
			afterEqual = false;
			break;

		case "sqrt":

			// .setScale( 3, BigDecimal.ROUND_HALF_UP);

			value = formatValue(String.valueOf(new BigDecimal(Math.sqrt(Double.parseDouble(firstNumber)))));
			
//			NumberFormat format = new DecimalFormat("0.####");
//			value = format.format(new BigDecimal(Math.sqrt(Double.parseDouble(firstNumber))));
			firstNumber = value;
			haveFirstNumber = true;
			afterEqual = true;
			break;

		case "%":
			if (!haveFirstNumber) {
				if (firstNumber.isEmpty()) {
					firstNumber = "0";
				}
				if (!value.contains("%")) {
					value = firstNumber + "%";
					firstNumber = String.valueOf(BigDecimal.valueOf(Double.parseDouble(firstNumber) / 100));
					haveFirstNumber = true;
					secondNumber = "0";
					operation = "+";
					haveOperation = true;
				}
			} else {
				if (secondNumber.isEmpty()) {
					secondNumber = "0";
				}
				if (!value.substring(value.length() - 1).equals("%")) {
					value = firstNumber + " " + operation + " " + secondNumber + "%";
					secondNumber = String.valueOf(new BigDecimal(firstNumber).multiply(new BigDecimal(secondNumber))
							.divide(new BigDecimal(100)));

				}
			}
			afterEqual = false;
			break;

		case "+/-":
			value = formatValue(String.valueOf(new BigDecimal(firstNumber).multiply(new BigDecimal("-1"))));
			firstNumber = value;
			haveFirstNumber = true;
			afterEqual = true;
			break;

		}
	}

	private void countResult(String firstNumber, String secondNumber, String operation) {

		switch (operation) {
		case "+":
			value = formatValue(String.valueOf((new BigDecimal(firstNumber).add(new BigDecimal(secondNumber)))));
			break;
		case "-":
			value = formatValue(String.valueOf((new BigDecimal(firstNumber).subtract(new BigDecimal(secondNumber)))));
			break;
		case "*":
			value = formatValue(String.valueOf((new BigDecimal(firstNumber).multiply(new BigDecimal(secondNumber)))));
			break;
		case "/":
			try {

				value = formatValue(String.valueOf(
						(new BigDecimal(firstNumber).divide(new BigDecimal(secondNumber), 8, RoundingMode.HALF_EVEN))));

//				Locale.setDefault(new Locale("en", "US"));
//				NumberFormat format = new DecimalFormat("0.####");
//				value = format.format(
//						(new BigDecimal(firstNumber).divide(new BigDecimal(secondNumber), 8, RoundingMode.HALF_EVEN)));

			} catch (ArithmeticException e) {
				value = "ERR";
//				throw new ArithmeticException(
//						"Non-terminating decimal expansion; " + "no exact representable decimal result.");
			}
			break;
		}

	}

	private String formatValue(String inputValue) {

		Locale.setDefault(new Locale("en", "US"));
		NumberFormat format = new DecimalFormat("0.#######");
		return format.format(new BigDecimal(inputValue));

	}

}
