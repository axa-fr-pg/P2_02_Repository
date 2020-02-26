package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {
		// first get input
		SymptomReaderFile inputFile = new SymptomReaderFile("symptoms.txt");
		inputFile.openSymptomDataSource();
		String symptom = inputFile.readSymptom();
		while ( symptom != null) 
		{
			try
			{
				inputFile.checkSymptom(symptom);
			}
			catch (IllegalSymptomException e)
			{
				System.err.println("Symptom input file is corrupted, aborting !");
				return;
			}
			
			// PLACEHOLDER for createMapEntry(symptom);
			// In the meanwhile print them all on standard output
			System.out.println(symptom);
			
			symptom = inputFile.readSymptom();		
		}
		
		inputFile.closeSymptomDataSource();

		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
