package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading of symptoms from any kind of data source
 * @author openclassrooms, Philippe GEY
 * @version 3.0
 */
public interface ISymptomReader {
	/*
	 * Implementation below is the best choice between performance (read all lines in one single 
	 * call of method Files.readAllLines) and flexibility regarding big files (memory limits).
	 * Current version enables reading of big files without intrinsic file size limit :
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
