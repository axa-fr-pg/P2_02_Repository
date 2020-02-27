package com.hemebiotech.io.output;

/**
 * Interface for the writing of any kind of biological maps into any kind of data source
 * @author Philippe GEY
 * @version 1.0
 */
public interface IMapWriter
{
	/**
	 * Method to open a map data source
	 * @author Philippe GEY
	 * @version 1.0
	 */
	void openMapDataSource();
	
	/**
	 * Method to write a map into data source
	 * @param mapString The map in String format
	 * @author Philippe GEY
	 * @version 1.0
	 */
	void writeMapString(String mapString);
	
	/**
	 * Method to close a map data source
	 * @author Philippe GEY
	 * @version 1.0
	 */
	void closeMapDataSource();
	
}
