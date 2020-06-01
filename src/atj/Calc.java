
package atj;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//import org.mariuszgromada.math.mxparser.Expression;

public class Calc {

	String value = "0";
	String btn = " ";

//	public String getBtn() {
//		return btn;
//	}

	public void setBtn(String newBtn) {
		btn += newBtn;
	}

	public String getValue() {
		return value;
	}

//	public void setValue(String value) {
//		this.value = value;
//	}

	boolean useOldValue = false;

	public void caclulate(String input) throws ScriptException {

		// musze sprawdzac wejscie tu
		// boolean useOldValue = false;

		if (input.contains("C")) {
			btn = " ";
			value = "0";
			useOldValue = false;
		} else if (input.contains("=")) {

			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			value = engine.eval(btn).toString();
			btn = value;
			useOldValue = true;

		} else if (input.equals("1") && useOldValue || input.equals("2") && useOldValue
				|| input.equals("3") && useOldValue || input.equals("4") && useOldValue
				|| input.equals("5") && useOldValue || input.equals("6") && useOldValue
				|| input.equals("7") && useOldValue || input.equals("8") && useOldValue
				|| input.equals("9") && useOldValue || input.equals("0") && useOldValue) {
			btn = input;
			value = btn;
			
		} else if (input.equals(".") && ".".equals(btn.substring(btn.length() - 1))) {
			
		} else if (input.equals(".") && useOldValue) {
			// TODO
			btn = "0";
			setBtn(input);
			value = btn;
			useOldValue = false;

	
//		} else if (input.equals(".") && btn.substring(btn.length() - 1).equals(".")) {
//		} else if (input.equals(".") && ".".equals(btn.substring(btn.length() - 1))) {

		} else {

			setBtn(input);
			value = btn;
			useOldValue = false;
		}

	}

}
