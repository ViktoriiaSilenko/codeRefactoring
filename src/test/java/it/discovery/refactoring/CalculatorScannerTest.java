package it.discovery.refactoring;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorScannerTest {
	
	/*@Before 
	public void before() {
		CalculationScanner.init();
	}*/
	
	@BeforeClass // before all tests
	public static void before() {
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
	
	@Test
	public void scan_ReportFileNonEmpty_ScanResultGenerate() {
		try {
			Object obj = CalculationScanner.scan();
			assertNotNull(obj);
			assertTrue(obj instanceof ScanResult);
			ScanResult result = (ScanResult) obj;
			assertEquals(result.lineCount.lineCount, 5);
			assertEquals(result.report, 
							"Operaciya slojit\n" +
							"Argument 1 2\n" + 
							"Argument 2 3\n" +
							"Rezultat 5\n" +
							"Zakonchili rabotu\n");
			assertEquals(result.lines.size(), 5);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
