package it.discovery.refactoring;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	//Given_When_Then
	public void calculate_SumWithDecimalScaleAndFileOutput_Success() {
		
		assertEquals(0, Calculator.calculate(new Operation("+", "2", "3"), "10", "false"));
	}
	
	@Test
	//Given_When_Then
	public void calculate_SumWithDecimalScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate(new Operation("+", "1", "2"), "10", "true");
		//assertEquals("", Calculator.report); // red - green - refactor
		assertEquals(Calculator.report, "Nachali rabotu\n" +
		"Operaciya slojit\n" +
		"Argument 1 1\n" + 
		"Argument 2 2\n" +
		"Rezultat 3\n" +
		"Zakonchili rabotu\n");

		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
	public void calculate_DecreaseWithDecimalScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate(new Operation("-", "5", "2"), "10", "true");
		//assertEquals("", Calculator.report); // red - green - refactor
		assertEquals(Calculator.report, "Nachali rabotu\n" +
		"Operaciya vychitanie\n" +
		"Argument 1 5\n" + 
		"Argument 2 2\n" +
		"Rezultat 3\n" +
		"Zakonchili rabotu\n");

		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
	public void calculate_MultiplyWithDecimalScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate(new Operation("*", "2", "3"), "10", "true");
		//assertEquals("", Calculator.report); // red - green - refactor
		assertEquals(Calculator.report, "Nachali rabotu\n" +
		"Operaciya umnojeniya\n" +
		"Argument 1 2\n" + 
		"Argument 2 3\n" +
		"Rezultat 6\n" +
		"Zakonchili rabotu\n");

		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
	public void calculate_SumWithBinaryScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate(new Operation("+", "1", "5"), "2", "true");
		assertEquals(Calculator.report, "Nachali rabotu\n" +
		"Operaciya slojit\n" +
		"Argument 1 1\n" + 
		"Argument 2 101\n" +
		"Rezultat 110\n" +
		"Zakonchili rabotu\n");

		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
	public void calculate_SumWithOctalScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate(new Operation("+", "2", "8"), "8", "true");
		assertEquals(Calculator.report, "Nachali rabotu\n" +
		"Operaciya slojit\n" +
		"Argument 1 2\n" + 
		"Argument 2 10\n" +
		"Rezultat 12\n" +
		"Zakonchili rabotu\n");

		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
	public void calculate_SumWithHexScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate(new Operation("+", "5", "12"), "16", "true");
		assertEquals(Calculator.report, "Nachali rabotu\n" +
		"Operaciya slojit\n" +
		"Argument 1 5\n" + 
		"Argument 2 c\n" +
		"Rezultat 11\n" +
		"Zakonchili rabotu\n");

		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
		public void calculate_SumFirstArgumentNonNumber_Error() {
		int result = Calculator.calculate(new Operation("+", "aaa", "3"), "10", "true");
		assertEquals(-1, result);
	}
	
	@Test
	//Given_When_Then
		public void calculate_SumSecondArgumentNonNumber_Error() {
		int result = Calculator.calculate(new Operation("+", "2", "bb"), "10", "true");
		assertEquals(-1, result);
	}

}
