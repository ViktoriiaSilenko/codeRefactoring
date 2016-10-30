package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Calculate unit that implements arithmetic operations
 */
public class Calculator {
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
			System.out.println("Oshibka");
			return -1;
		}
		int secondNumber = 0;
		try {
			secondNumber = Integer.parseInt(secondOp);
		} catch (Exception ex) {
			System.out.println("Oshibka");
			return -1;
		}

		report += "Argument 1 " + convertToScale(firstNumber, scale) + "\n";
		report += "Argument 2 " + convertToScale(secondNumber, scale) + "\n";
		int sum = firstNumber + secondNumber;
		report += "Rezultat " + convertToScale(sum, scale) + "\n";
		System.out.println(sum);
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
			System.out.println("Oshibka");
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
			System.out.println("Oshibka");
			return -1;
		}
		int secondNumber = 0;
		try {
			secondNumber = Integer.parseInt(secondOp);
		} catch (Exception ex) {
			System.out.println(getErrorMessage());
			return -1;
		}

		report += "Argument 1 " + convertToScale(firstNumber, scale) + "\n";
		report += "Argument 2 " + convertToScale(secondNumber, scale) + "\n";
		firstNumber -= secondNumber;
		report += "Rezultat " + convertToScale(firstNumber, scale) + "\n";
		System.out.println(firstNumber);
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
			System.out.println(getErrorMessage());
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
			System.out.println(getErrorMessage());
			return -1;
		}
		int secondNumber = 0;
		try {
			secondNumber = Integer.parseInt(secondOp);
		} catch (Exception ex) {
			System.out.println(getErrorMessage());
			return -1;
		}
		report += "Argument 1 " + convert(firstNumber, scale) + "\n";
		report += "Argument 2 " + convert(secondNumber, scale) + "\n";
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
			System.out.println(getErrorMessage());
			return -1;
		}
		return 0;
	}

	private static String convertToScale(int value, String scale) {
		switch (scale) {
		case "2":
			String result = Integer.toBinaryString(value);
			return result;
		case "8":
			String result2 = Integer.toOctalString(value);
			return result2;
		case "16":
			String result3 = Integer.toHexString(value);
			return result3;
		default:
			String result4 = "" + value;
			return result4;
		}
	}

	private static String convert(int value, String scale) {
		int defaultScale = 10;
		try {
			defaultScale = Integer.parseInt(scale);
		} catch (NumberFormatException ex) {
			
		}
		
		String result = Integer.toString(value, defaultScale);
		return result;		
	}
	
	private static String getErrorMessage() {
		return "Oshibka";
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
