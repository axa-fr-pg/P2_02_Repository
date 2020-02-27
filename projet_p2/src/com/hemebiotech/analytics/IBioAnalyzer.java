package com.hemebiotech.analytics;

/**
 * Interface for analysis of any kind of biological data
 * @author Philippe GEY
 * @version 1.0
 */
public interface IBioAnalyzer {

	/**
	 * Method containing all business intelligence of the biological analysis
	 * @param symptom input for new entry
	 */
	void createMapEntry(String symptom);

	/**
	 * Method to create a map of biological data from an input file
	 */
	void buildMapFile();
	
	/**
	 * Method for converting a map of biological entries into a String
	 * @return String of sorted map entries
	 */
	String toString();
	
	/**
	 * Method to store a map containing biological data into an output file.
	 * Entries are written in the format "biological key"="biological value".
	 * Each map entry will be followed by a line separator.
	 */
	void storeMapFile();
	
}
