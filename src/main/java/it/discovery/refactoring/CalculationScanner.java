package it.discovery.refactoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class CalculationScanner {
	public static String report;
	
	public static ScanResult scanResult;
	
	public static void init() {
		scanResult = new ScanResult();
	}

	public static Object scan() throws Exception {
		String defaultPath = Constants.DEFAULT_SCAN_FOLDER;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(defaultPath));
			try {
				StringBuilder sb = new StringBuilder();
				String line = reader.readLine();
				int linesCount=-1;
				linesCount++;
				Vector lines = new Vector<>();

				while (line != null) {
					sb.append(line);
					sb.append("\n");
					line = reader.readLine();
					lines.add(line);
					linesCount = linesCount + 1;
				}
				report = sb.toString();
				scanResult.lineCount = new LineContainer();
				scanResult.lineCount.lineCount = linesCount;
				scanResult.lines = lines;
				scanResult.report = report;
			} finally {
				//Pustoy blok. Pochemu? Ya ne znayu
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}
		catch (IOException e) {
			System.out.println("Error!");
			throw new Exception("!");
		}
		return scanResult;

	}

	public static void main(String[] args) throws Exception {
		ScannerWrapper wrapper = new ScannerWrapper();
		wrapper.scanner = new CalculationScanner();
		Object result = wrapper.scan();
		try {
			ScanResult data = (ScanResult) result;
			data.printLineCount();
			data.printLines();
			data.printReport();
		} catch (Exception e) {
			System.out.println("!");
		}		
	}
}

class BaseLineContainer {
	public int lineCount;
	
	public BaseLineContainer() {
		if(!(this instanceof LineContainer)) {
			System.out.println("Error!");
		}
	}
}

class LineContainer extends BaseLineContainer{
	
}

class FutureLineContainer extends LineContainer{
	
}

class ScanResult {
	public BaseLineContainer lineCount;
	
	public Vector lines;
	
	public String report;
	
	private void printInfo(String content) {
		System.out.println(content);
	}
	
	public void printLineCount() {
		printInfo("Data::Chislo linij " + lineCount.lineCount);		
	}
	
	public void printLines() {
		printInfo(Constants.HEADER_LINES + lines);
	}

	public void printReport() {
		printInfo("Data::Tekst " + report);
	}
	
}

class ScannerWrapper {
	public CalculationScanner scanner;
	
	public Object scan() throws Exception {
		scanner.init();
		return scanner.scan();
	}
}

interface Constants {
      public static final String HEADER_LINES = "Data::Stroki";	
      
      public static final String POINT = ".";
      
      public static final String ONE = "1";
      
      public static final String DEFAULT_SCAN_FOLDER =  "c:\\test.txt";
}