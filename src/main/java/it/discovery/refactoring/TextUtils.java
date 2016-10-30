package it.discovery.refactoring;

public class TextUtils {

	static boolean isConsole(String toConsole) {
		boolean isConsole = false;
		if (toConsole != null && toConsole.equals("true")) {
			isConsole = true;
		}
		return isConsole;
	}

	static int toInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException ex) {
			System.out.println(Calculator.ERROR_MESSAGE);
			// return -1;
			throw new RuntimeException(ex);
		}
	}

	static String convert(int value, String scale) {
		int defaultScale = 10;
		try {
			defaultScale = Integer.parseInt(scale);
		} catch (NumberFormatException ex) {
	
		}
	
		return Integer.toString(value, defaultScale);
	}

}
