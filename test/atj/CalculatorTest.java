package atj;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

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
		assertEquals("3.0", obiekt.getValue());
	}
}
