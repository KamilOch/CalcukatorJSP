package atj;

public class CalcK {

	private String value = "0";
	private String firstNumber = " ";
	private String secondNumber = " ";
	private String operation;

	private boolean haveFirstNumber;
	private boolean haveSecondNumber;
	private boolean haveOperation;

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
			firstNumber = " ";
			secondNumber = " ";
			haveFirstNumber = false;
			haveSecondNumber = false;
			break;
		case "=":
			if (haveFirstNumber /* && haveSecondNumber */ && haveOperation) {
				countResult(firstNumber, secondNumber, operation);
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
			if (!haveFirstNumber) {
				addNewStringToNumberOne(input);
				value = firstNumber;
			} else if (haveFirstNumber) {
				addNewStringToNumberTwo(input);
				value = firstNumber + " " + operation + " " + secondNumber;
			}
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
			} else if (haveFirstNumber /* && haveSecondNumber */) {
				countResult(firstNumber, secondNumber, operation);
				firstNumber = value;
				haveFirstNumber = true;
//				haveSecondNumber = false;
				secondNumber = " ";
				haveOperation = true;
			}
			break;

		// cd case ..... sqrt % +/-

		}
	}

	private void countResult(String firstNumber, String secondNumber, String operation) {
		// TODO Auto-generated method stub
		switch (operation) {
		case "+":
			value = String.valueOf((Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber)));
		case "-":
			value = String.valueOf((Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber)));
		case "*":
			value = String.valueOf((Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber)));
		case "/":
			value = String.valueOf((Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber)));
		}

	}

}
