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
			
			//BufferedReader reader = new BufferedReader(new FileReader(defaultPath));

				List<String> lines = Files.readAllLines(Paths.get(defaultPath));
				//StringBuilder sb = new StringBuilder();
				//String line = reader.readLine();
				//int linesCount=0;
				//Vector lines = new Vector<>();

				/*while (line != null) {
					sb.append(line).append("\n");
					line = reader.readLine();
					lines.add(line);
					linesCount = linesCount + 1;
				}*/
				report = lines.toString();
				
				scanResult = new ScanResult(new LineContainer(lines.size()), new Vector(lines), report);
				/*scanResult.setLineCount(new LineContainer());
				scanResult.getLineCount().setLineCount(lines.size());
				scanResult.setLines(new Vector(lines));
				scanResult.setReport(report);*/
			 
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
		//ScannerWrapper wrapper = new ScannerWrapper();
		//wrapper.scanner = new CalculationScanner();
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

class BaseLineContainer {
	private int lineCount;
	
	public BaseLineContainer(int lineCount) {
		this.lineCount = lineCount;
	}

	public BaseLineContainer() {
		if(!(this instanceof LineContainer)) {
			System.out.println("Error!");
		}
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
}

class LineContainer extends BaseLineContainer{
	public LineContainer(int lineCount) {
		super(lineCount);
	}
	
}

class ScanResult {
	private BaseLineContainer lineCount;
	
	private Vector lines;
	
	private String report;
	
	public ScanResult(BaseLineContainer lineCount, Vector lines, String report) {
		super();
		this.lineCount = lineCount;
		this.lines = lines;
		this.report = report;
	}

	private void printInfo(String content) {
		System.out.println(content);
	}
	
	public void printLineCount() {
		printInfo(Constants.SECOND_HEADER_LINES + getLineCount().getLineCount());		
	}
	
	public void printLines() {
		printInfo(Constants.HEADER_LINES + getLines());
	}

	public void printReport() {
		printInfo(Constants.FOOTER_LINES + getReport());
	}

	public BaseLineContainer getLineCount() {
		return lineCount;
	}

	public Vector getLines() {
		return lines;
	}


	public String getReport() {
		return report;
	}
	
}

class ScannerWrapper {
	
	public Object scan() throws Exception {
		//CalculationScanner.init();
		ScanResult scanResult = null;
		return CalculationScanner.scan();
	}
}

interface Constants {
	public static final String HEADER_LINES = "Data::Stroki";
	public static final String FOOTER_LINES = "Data::Tekst ";
	public static final String SECOND_HEADER_LINES = "Data::Chislo linij ";
}
