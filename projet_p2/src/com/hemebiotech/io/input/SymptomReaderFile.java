package com.hemebiotech.io.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.hemebiotech.exception.IllegalSymptomException;

/**
 * Class for Symptom reading based on an input file.
 * @author Philippe GEY
 * @version 1.0
 * @see ISymptomReader interface
 */
public class SymptomReaderFile implements ISymptomReader {

	private String filepath;
	private BufferedReader reader;
	
	/**
	 * Method for creating an instance of SymptomReaderFile
	 * @param filepath file containing raw symptoms
	 */
	public SymptomReaderFile (String filepath) 
	{
		reader = null;
		this.filepath = filepath;
	}
	
	@Override
	public void checkSymptom(String symptom) throws IllegalSymptomException
	{
		if (symptom.length() == 0 || ! symptom.matches("[ a-zA-Z0-9]+")) throw new IllegalSymptomException();
	}
	
	@Override
	public void openSymptomDataSource()
	{
		try
		{
			reader = new BufferedReader (new FileReader(filepath));
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Input file " + filepath + " could not be opened : " + e);
		}
	}
	
	/**
	 * Method for the reading of a symptom from a file.
	 * Each symptom must be in a separate line in the input file.
	 */
	@Override
	public String readSymptom()
	{
		String line = null;
		
		try {
		    line = reader.readLine();
		}
		catch (IOException e) {
			System.out.println("Symptoms file could not be read !");
		}

		return line;
	}
	
	@Override
	public void closeSymptomDataSource()
	{
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Input file " + filepath + " could not be closed : " + e);
		}
	}
	
}
