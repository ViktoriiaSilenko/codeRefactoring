package it.discovery.refactoring;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	//Given_When_Then
	public void calculate_SumWithDecimalScaleAndFileOutput_Success() {
		assertEquals(0, Calculator.calculate("+", "2", "3", "10", "false"));
	}
	
	@Test
	//Given_When_Then
	public void calculate_SumWithDecimalScaleAndConsuleOutput_Success() {
		int result = Calculator.calculate("+", "1", "2", "10", "true");
		assertEquals(0, result);
	}
	
	@Test
	//Given_When_Then
		public void calculate_SumFirstArgumentNonNumber_Error() {
		int result = Calculator.calculate("+", "aaa", "3", "10", "true");
		assertEquals(-1, result);
	}
	
	@Test
	//Given_When_Then
		public void calculate_SumSecondArgumentNonNumber_Error() {
		int result = Calculator.calculate("+", "2", "bb", "10", "true");
		assertEquals(-1, result);
	}

}
