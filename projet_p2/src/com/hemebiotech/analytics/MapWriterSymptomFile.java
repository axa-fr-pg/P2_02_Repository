package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for the writing of symptom maps based on an output file.
 * @author Philippe GEY
 * @version 1.0
 * @see IMapWriter interface
 */
public class MapWriterSymptomFile implements IMapWriter 
{

	FileWriter writer;
	private String filepath;

	/**
	 * Method for creating an instance of MapWriterSymptomFile
	 * @param filepath of file to be written
	 */
	public MapWriterSymptomFile (String filepath) 
	{
		writer = null;
		this.filepath = filepath;
	}

	@Override
	public void openMapDataSource()
	{
		try
		{
			writer = new FileWriter(filepath);
		}
		catch (IOException e)
		{
			System.err.println("Ouput file " + filepath + " could not be opened : " + e);
		}
	}
	
	@Override
	public void writeMapString(String mapString)
	{
		try {
			writer.write(mapString);
		} catch (IOException e) {
			System.err.println("Error while writing, incomplete output file !");
		}
	}
	
	@Override
	public void closeMapDataSource()
	{
		try {
			writer.close();
		} catch (IOException e) {
			System.err.println("Error while closing output file, " + filepath + " might be corrupted !");
		}
	}
	
}
