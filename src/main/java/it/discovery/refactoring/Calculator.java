package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Calculate unit that implements arithmetic operations
 */
public class Calculator {
	private static final String ERROR_MESSAGE = "Oshibka";
	public static String report = null;


	public static void main(String[] args) {
		Operation operation = new Operation(args[0], args[1], args[2]);
		String scale = null;
		try {
			scale = args[3];
		} catch (ArrayIndexOutOfBoundsException e) {
			scale = "10";
		}

		String toConsole = null;
		try {
			toConsole = args[4];
		} catch (ArrayIndexOutOfBoundsException e) {
			toConsole = "false";
		}

		calculate(operation, scale, toConsole);
	}

	/**
	 * Main function.
	 * Example of usage: create debug or run configuration with the program arguments
	 * @param operation - object, which stores name of operation, String representation of the first and second operands
	 * @param scale - scale of notation: 2, 8, 10 or 16 (optional, default is 10)
	 * @param toConsole - output in the console(false) or in the file(true) (optional)
	 * For example, + 2 2 true
	 */

	public static int calculate(Operation operation, String scale, String toConsole) {
		report = "";
		report += "Nachali rabotu\n";
		int operationResult = 0;

		boolean isConsole = false;
		if (toConsole != null && toConsole.equals("true")) {
			isConsole = true;
		}

		switch (operation.getName()) {
		case "+": {
			operationResult = calculateSum(operation, scale, isConsole);
			break;
		}

		case "-": {
			operationResult = calculateSubtraction(operation, scale, isConsole);
			break;
		}

		case "*": {
			operationResult = calculateMult(operation, scale, isConsole);
			break;
		}

		}
		return operationResult;
	}
	
	private static int calculateSum(Operation operation, String scale, boolean isConsole) {
		report += "Operaciya slojit\n";
		String firstOp = operation.getFirstOp();
		String secondOp = operation.getSecondOp();
		int firstNumber = 0;
		try {
			firstNumber = Integer.parseInt(firstOp);
		} catch (Exception ex) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		int secondNumber = 0;
		try {
			secondNumber = Integer.parseInt(secondOp);
		} catch (Exception ex) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		
		report += ReportTools.printArguments(firstNumber, secondNumber, scale);

		int result = firstNumber + secondNumber;
		report += "Rezultat " + convertToScale(result, scale) + "\n";
		System.out.println(result);
		try {
			report += "Zakonchili rabotu\n";
			if (isConsole) {
				System.out.println(report);
			} else {
				FileWriter writer = new FileWriter("c:\\test.txt");
				BufferedWriter out = new BufferedWriter(writer);
				out.write(report);
				out.close();
			}

		} catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		return 0;
		
	}
	
	private static int calculateSubtraction(Operation operation, String scale, boolean isConsole) {
		report += "Operaciya vychitanie\n";
		String firstOp = operation.getFirstOp();
		String secondOp = operation.getSecondOp();
		int firstNumber = 0;
		try {
			firstNumber = Integer.parseInt(firstOp);
		} catch (Exception ex) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		int secondNumber = 0;
		try {
			secondNumber = Integer.parseInt(secondOp);
		} catch (Exception ex) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		
		report += ReportTools.printArguments(firstNumber, secondNumber, scale);

		int result = firstNumber - secondNumber;
		report += "Rezultat " + convertToScale(result, scale) + "\n";
		System.out.println(result);
		try {
			report += "Zakonchili rabotu\n";
			if (isConsole) {
				System.out.println(report);
			} else {
				FileWriter writer = new FileWriter("c:\\test.txt");
				BufferedWriter out = new BufferedWriter(writer);
				out.write(report);
				out.close();
			}

		} catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		return 0;
	}
	
	private static int calculateMult(Operation operation, String scale, boolean isConsole) {
		report += "Operaciya umnojeniya\n";
		String firstOp = operation.getFirstOp();
		String secondOp = operation.getSecondOp();
		int firstNumber = 0;
		try {
			firstNumber = Integer.parseInt(firstOp);
		} catch (Exception ex) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		int secondNumber = 0;
		try {
			secondNumber = Integer.parseInt(secondOp);
		} catch (Exception ex) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		report += ReportTools.printArguments(firstNumber, secondNumber, scale);
		int result = firstNumber * secondNumber;
		report += "Rezultat " + convert(result, scale) + "\n";
		System.out.println(result);
		try {
			report += "Zakonchili rabotu\n";
			if (isConsole) {
				System.out.println(report);
			} else {
				FileWriter w = new FileWriter("c:\\test.txt");
				BufferedWriter out = new BufferedWriter(w);
				out.write(report);
				out.close();
			}

		} catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			return -1;
		}
		return 0;
	}

	public static String convertToScale(int value, String scale) {
		switch (scale) {
		case "2":
			return Integer.toBinaryString(value);
		case "8":
			return Integer.toOctalString(value);
		case "16":
			return Integer.toHexString(value);
		default:
			return "" + value;
		}
	}

	private static String convert(int value, String scale) {
		int defaultScale = 10;
		try {
			defaultScale = Integer.parseInt(scale);
		} catch (NumberFormatException ex) {
			
		}
		
		return Integer.toString(value, defaultScale);	
	}
	
}

class ReportTools {
	
	public static String printArguments(int firstNumber, int secondNumber, String scale) {
		String report = "Argument 1 " + Calculator.convertToScale(firstNumber, scale) + "\n";
		report += "Argument 2 " + Calculator.convertToScale(secondNumber, scale) + "\n";
		return report;
		
	}
	
}

//class OtchetTools {
//	public static void zapusk() {
//		String otchet = MainClass.otchet;
//		System.out.println(otchet);
//	}
//	
//	public static void main(String[] argumenty) {
//		OtchetTools otchet = new OtchetTools();
//		otchet.zapusk();
//	}
//}
