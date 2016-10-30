package it.discovery.refactoring;

import java.io.IOException;

/**
 * Calculate unit that implements arithmetic operations
 */
public class Calculator {
	static final String ERROR_MESSAGE = "Error";
	private static String report = null;

	public static void main(String[] args) {

		String scale = "10";
		if(args.length > 3) {
			scale = args[3];
		} 

		String toConsole = "false";
		if(args.length > 4) {
			toConsole = args[4];
		}

		calculate(new Operation(args[0], args[1], args[2], scale, toConsole));
	}

	/**
	 * Main function. Example of usage: create debug or run configuration with
	 * the program arguments
	 * 
	 * @param operation
	 *            - object, which stores name of operation, String
	 *            representation of the first and second operands
	 * @param scale
	 *            - scale of notation: 2, 8, 10 or 16 (optional, default is 10)
	 * @param toConsole
	 *            - output in the console(false) or in the file(true) (optional)
	 *            For example, + 2 2 true
	 */

	public static void calculate(Operation operation) {

		String report = "";
		try {
			report += calculateReport(operation);
		} catch (Exception e) {
			System.out.println(ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
		Calculator.setReport(report);
	}

	public static String calculateReport(Operation calcOperation) throws IOException {
		
		String report = "Nachali rabotu\n";

		switch (calcOperation.getName()) {
		case "+": {
			report += calculateSum(calcOperation);
			break;
		}

		case "-": {
			report += calculateSubtraction(calcOperation);
			break;
		}

		case "*": {
			report += calculateMult(calcOperation);
			break;
		}

		}
		//Calculator.report += report;
		Calculator.setReport(report);
		
		return report;
	}
	
	public static String getReport() {
		return report;
	}
	
	private static String calculateSum(Operation operation) throws IOException {
		String report = "Operaciya slojit\n";
		String firstOp = operation.getFirstOp();
		String secondOp = operation.getSecondOp();
		String scale = operation.getScale();
		boolean isConsole = TextUtils.isConsole(operation.getToConsole());
		int firstNumber = TextUtils.toInt(firstOp);
		int secondNumber = TextUtils.toInt(secondOp);

		report += ReportTools.getArguments(firstNumber, secondNumber, scale);

		int result = firstNumber + secondNumber;
		report += "Rezultat " + TextUtils.convert(result, scale) + "\n";
		System.out.println(result);
		report += "Zakonchili rabotu\n";
		if (isConsole) {
			System.out.println(report);
		} else {
			CalculationReport.saveToFile(report);
		}

		//Calculator.report += report;
		Calculator.setReport(report);
		return report;

	}

	private static String calculateSubtraction(Operation operation) throws IOException {
		String report = "Operaciya vychitanie\n";
		String firstOp = operation.getFirstOp();
		String secondOp = operation.getSecondOp();
		int firstNumber = TextUtils.toInt(firstOp);
		int secondNumber = TextUtils.toInt(secondOp);
		String scale = operation.getScale();
		boolean isConsole = TextUtils.isConsole(operation.getToConsole());

		report += ReportTools.getArguments(firstNumber, secondNumber, scale);

		int result = firstNumber - secondNumber;
		report += "Rezultat " + TextUtils.convert(result, scale) + "\n";
		System.out.println(result);

		report += "Zakonchili rabotu\n";
		if (isConsole) {
			System.out.println(report);
		} else {
			CalculationReport.saveToFile(report);
		}

		//Calculator.report += report;
		Calculator.setReport(report);
		return report;
	}

	private static String calculateMult(Operation operation) throws IOException {
		String report = "Operaciya umnojeniya\n";
		String firstOp = operation.getFirstOp();
		String secondOp = operation.getSecondOp();
		int firstNumber = TextUtils.toInt(firstOp);
		int secondNumber = TextUtils.toInt(secondOp);
		String scale = operation.getScale();
		boolean isConsole = TextUtils.isConsole(operation.getToConsole());
		
		report += ReportTools.getArguments(firstNumber, secondNumber, scale);
		int result = firstNumber * secondNumber;
		report += "Rezultat " + TextUtils.convert(result, scale) + "\n";
		System.out.println(result);

		report += "Zakonchili rabotu\n";
		if (isConsole) {
			System.out.println(report);
		} else {
			CalculationReport.saveToFile(report);
		}

		//Calculator.report += report;
		Calculator.setReport(report);
		return report;
	}

	/*public static String convertToScale(int value, String scale) {
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
	}*/

	private static void setReport(String report) {
		Calculator.report = report;
	}

}

class ReportTools {

	public static String getArguments(int firstNumber, int secondNumber, String scale) {
		String report = "Argument 1 " + TextUtils.convert(firstNumber, scale) + "\n";
		report += "Argument 2 " + TextUtils.convert(secondNumber, scale) + "\n";
		return report;

	}

}

// class OtchetTools {
// public static void zapusk() {
// String otchet = MainClass.otchet;
// System.out.println(otchet);
// }
//
// public static void main(String[] argumenty) {
// OtchetTools otchet = new OtchetTools();
// otchet.zapusk();
// }
// }
