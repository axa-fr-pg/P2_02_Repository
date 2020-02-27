package com.hemebiotech.analytics;

import java.util.TreeMap;

import com.hemebiotech.exception.IllegalSymptomException;
import com.hemebiotech.io.input.SymptomReaderFile;
import com.hemebiotech.io.output.MapWriterSymptomFile;

/**
 * Class for Symptom data analysis based on file system data storage.
 * Input and output data will be handled with files.
 * @author Philippe GEY
 * @version 1.0
 * @see IBioAnalyzer interface
 */
public class BioAnalyzerSymptomFile implements IBioAnalyzer
{
	private SymptomReaderFile inputFile;
	private TreeMap<String, Integer> map;
	private MapWriterSymptomFile outputFile;

	/**
	 * Method for creating an instance of BioAnalyzerSymptomFile
	 * @param symptomRawDataFile Name of the raw symptom input file to be read
	 * @param symptomMapDataFile Name of the symptom map output file to be written
	 */
	public BioAnalyzerSymptomFile(String symptomRawDataFile, String symptomMapDataFile)
	{
		inputFile = new SymptomReaderFile(symptomRawDataFile);
		map = new TreeMap<String, Integer>();
		outputFile = new MapWriterSymptomFile(symptomMapDataFile);
	}
	
	@Override
	public void createMapEntry(String symptom)
	{
		Integer i = map.get(symptom);
		if (i == null) i = 1; else i++;
		map.put(symptom, i);
	}
	
	@Override
	public void buildMapFile()
	{
		inputFile.openSymptomDataSource();
		String symptom = inputFile.readSymptom();
		
		/*
		 * Refer to ISymptomReader interface comments to understand why symptoms are read one by one
		 */
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
			createMapEntry(symptom);
			symptom = inputFile.readSymptom();		
		}
		
		inputFile.closeSymptomDataSource();
	}
	
	@Override
	public String toString()
	{
		String newLine = System.getProperty("line.separator");
		StringBuilder sortedMap = new StringBuilder();
		
		// The map will be generated in the right order, TreeMap is always sorted
		map.entrySet().stream().forEach(entry -> sortedMap.append(entry.getKey() + "=" + entry.getValue() + newLine));
		
		return sortedMap.toString();
	}
	
	@Override
	public void storeMapFile()
	{
		outputFile.openMapDataSource();
		outputFile.writeMapString(toString());
		outputFile.closeMapDataSource();
	}
}
