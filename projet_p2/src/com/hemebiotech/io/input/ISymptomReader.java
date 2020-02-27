package com.hemebiotech.io.input;

import com.hemebiotech.exception.IllegalSymptomException;

/**
 * Interface for reading of symptoms from any kind of data source
 * @author openclassrooms, Philippe GEY
 * @version 3.0
 */
public interface ISymptomReader {
	/*
	 * Initial interface returned a raw listing of all symptoms obtained from a data source (with potential duplicates).
	 * Second version improved with a one liner command to read the whole file on a more efficient manner :
	 * ArrayList<String> lines = new ArrayList<String>(Files.readAllLines(Paths.get(filepath))).
	 * Third version designed to enable reading of big files without intrinsic file size limit :
	 * one by one reading of symptoms despite the lower performance of such a programming style.
	 */

	/**
	 * Method to open a symptom data source
	 * @author Philippe GEY
	 * @version 1.0
	 */
	void openSymptomDataSource();
	
	/**
	 * Method for the reading of a symptom from an already opened data source
	 * @return String containing the raw symptom
	 * @author Philippe GEY
	 * @version 1.0
	 */
	String readSymptom();
	
	/**
	 * Method to check an entry which has been previously read from a data source
	 * @throws IllegalSymptom when input data contains non alphanumeric characters
	 * @author Philippe GEY
	 * @version 1.0
	 */
	void checkSymptom(String symptom) throws IllegalSymptomException;
	

	/**
	 * Method to close a symptom data source
	 * @author Philippe GEY
	 * @version 1.0
	 */
	void closeSymptomDataSource();
}
