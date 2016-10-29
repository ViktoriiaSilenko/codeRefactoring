package it.discovery.refactoring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorScannerTest {
	
	@Before // before all tests
	public void before() {
		CalculationScanner.init();
	}
	
	@Test
	public void testMainMethodException() {
		try {
			CalculationScanner.scan();
		} catch(Exception ex) {
			fail(ex.getMessage());
		}
	}

}
