package atj;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	void shouldAddTwoNumbers() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("1");
		obiekt.caclulate("+");
		obiekt.caclulate("2");
		obiekt.caclulate("=");
		// then
		assertEquals("3", obiekt.getValue());
	}

	@Test
	void shouldSubstractTwoNumbers() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("1");
		obiekt.caclulate("-");
		obiekt.caclulate("2");
		obiekt.caclulate("=");
		// then
		assertEquals("-1", obiekt.getValue());
	}

	@Test
	void shouldMultiplyTwoNumbers() {

		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("*");
		obiekt.caclulate("2");
		obiekt.caclulate("=");
		// then
		assertEquals("6", obiekt.getValue());
	}

	@Test
	void shouldDivideTwoNumbers() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("/");
		obiekt.caclulate("2");
		obiekt.caclulate("=");
		// then
		assertEquals("1.5", obiekt.getValue());
	}

	@Test
	void shouldDisplayFirstNumberAndOperation() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("/");
		// then
		assertEquals("3 /", obiekt.getValue());

	}

	@Test
	void shouldDisplayFirstNumberAndOperationAndSecondNumber() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("+");
		obiekt.caclulate("7");
		// then
		assertEquals("3 + 7", obiekt.getValue());

	}

	@Test
	void shouldAddTwoNumbersAndGateNewOperation() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("1");
		obiekt.caclulate("+");
		obiekt.caclulate("2");
		obiekt.caclulate("-");
		// then
		assertEquals("3 -", obiekt.getValue());
	}

	@Test
	void shouldSubstractTwoNumbersAndGateNewOperation() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("1");
		obiekt.caclulate("-");
		obiekt.caclulate("2");
		obiekt.caclulate("+");
		// then
		assertEquals("-1 +", obiekt.getValue());
	}

	@Test
	void shouldMultiplyTwoNumbersAndGateNewOperation() {

		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("*");
		obiekt.caclulate("2");
		obiekt.caclulate("+");
		// then
		assertEquals("6 +", obiekt.getValue());
	}

	@Test
	void shouldDivideTwoNumbersAndGateNewOperation() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("/");
		obiekt.caclulate("2");
		obiekt.caclulate("*");
		// then
		assertEquals("1.5 *", obiekt.getValue());
	}

	@Test
	void shouldAfterCAddTwoNumbers() {
		// given
		CalcK obiekt = new CalcK();
		// when
		obiekt.caclulate("3");
		obiekt.caclulate("C");
		obiekt.caclulate("1");
		obiekt.caclulate("+");
		obiekt.caclulate("2");
		obiekt.caclulate("=");
		// then
		assertEquals("3", obiekt.getValue());
	}

}
