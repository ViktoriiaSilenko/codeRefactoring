package it.discovery.refactoring;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public class CalculationScanner {
	
	public static final String HEADER_LINES = "Data::Stroki";	
    
    public static final String DEFAULT_SCAN_FOLDER =  "c:\\test.txt";
	
	private static String report;
	
	private static ScanResult scanResult;
	
	public static void init() {
		scanResult = new ScanResult();
	}

	public static Object scan() throws Exception {
		String defaultPath = CalculationScanner.DEFAULT_SCAN_FOLDER;
		
		try {
			
			//BufferedReader reader = new BufferedReader(new FileReader(defaultPath));

				List<String> lines = Files.readAllLines(Paths.get(defaultPath));
				//StringBuilder sb = new StringBuilder();
				//String line = reader.readLine();
				int linesCount=0;
				//Vector lines = new Vector<>();

				/*while (line != null) {
					sb.append(line).append("\n");
					line = reader.readLine();
					lines.add(line);
					linesCount = linesCount + 1;
				}*/
				report = lines.toString();
				scanResult.lineCount = new LineContainer();
				scanResult.lineCount.lineCount = lines.size();
				scanResult.lines = new Vector(lines);
				scanResult.report = report;
			 
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}
		catch (IOException e) {
			System.out.println("Error!");
			throw new Exception("!");
		} /*finally {
			
			reader.close();
		}*/
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
		printInfo(CalculationScanner.HEADER_LINES + lines);
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
