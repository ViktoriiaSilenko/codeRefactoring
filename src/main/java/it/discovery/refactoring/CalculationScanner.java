package it.discovery.refactoring;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public class CalculationScanner {
	
    public static final String DEFAULT_SCAN_FOLDER =  "c:\\test.txt";
	
	private static String report;

	public static Object scan() throws Exception {
		ScanResult scanResult = null;
		String defaultPath = CalculationScanner.DEFAULT_SCAN_FOLDER;
		
		try {

				List<String> lines = Files.readAllLines(Paths.get(defaultPath));
				
				report = lines.toString();
				
				scanResult = new ScanResult(new Vector(lines), report);
			 
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

		Object result = CalculationScanner.scan();
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

class ScanResult {
	private int lineCount;
	
	private Vector lines;
	
	private String report;
	
	public ScanResult(Vector lines, String report) {
		this.lineCount = lines.size();
		this.lines = lines;
		this.report = report;
	}

	private void printInfo(String content) {
		System.out.println(content);
	}
	
	public void printLineCount() {
		printInfo(Constants.SECOND_HEADER_LINES + getLineCount());		
	}
	
	public void printLines() {
		printInfo(Constants.HEADER_LINES + getLines());
	}

	public void printReport() {
		printInfo(Constants.FOOTER_LINES + getReport());
	}

	public int getLineCount() {
		return lineCount;
	}

	public Vector getLines() {
		return new Vector(lines); // returned copy
	}


	public String getReport() {
		return report;
	}
	
}

interface Constants {
	public static final String HEADER_LINES = "Data::Stroki";
	public static final String FOOTER_LINES = "Data::Tekst ";
	public static final String SECOND_HEADER_LINES = "Data::Chislo linij ";
}
