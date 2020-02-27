package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {

		BioAnalyzerSymptomFile analyzer = new BioAnalyzerSymptomFile("symptoms.txt", "results.out");
		analyzer.buildMapFile();
		analyzer.storeSortedMapFile();
	}
}
