package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	List<String> symptoms;
	private TreeMap<String, Integer> map;

	/**
	 * Method for creating an instance of BioAnalyzerSymptomFile
	 * @param symptomRawDataFile Name of the raw symptom input file to be read
	 * @param symptomMapDataFile Name of the symptom map output file to be written
	 */
	public BioAnalyzerSymptomFile(String symptomRawDataFile)
	{
		inputFile = new SymptomReaderFile(symptomRawDataFile);
		this.symptoms = symptoms;
		map = new TreeMap<String, Integer>();
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
		
		inputFile.closeSymptomDataSource();	}
	
	@Override
	public String toString()
	{	
		String newLine = System.getProperty("line.separator");
		StringBuilder sortedMap = new StringBuilder();
		
		// Data sorting is embedded in the HashMap class for free
		map.entrySet().stream().forEach(entry -> 
			sortedMap.append(entry.getKey() + "=" + entry.getValue() + newLine));
		
		return sortedMap.toString();
	}
	
	@Override
	public void storeSortedMapFile()
	{
		// PLACEHOLDER to call output management methods
		// in the meanwhile print them all on standard output
		System.out.println(toString());
	}
}
