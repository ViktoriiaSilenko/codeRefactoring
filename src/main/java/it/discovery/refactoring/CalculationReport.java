package it.discovery.refactoring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CalculationReport {

	static void saveToFile(String content) throws IOException {
		FileWriter writer = new FileWriter(CalculationScanner.DEFAULT_SCAN_FOLDER);
		BufferedWriter out = new BufferedWriter(writer);
		out.write(content);
		out.close();
	}

}
