package com.hemebiotech.client;

import com.hemebiotech.analytics.BioAnalyzerSymptomFile;

/**
 * Main class of Heme BioTech data management tool
 * @author Philippe GEY
 * @version 1.0
 */
public class HemeBioTechAnalytics {
	/**
	 * Method to launch Heme BioTech data management tool
	 * @version 0.1 ... to be continued some day ...
	 * @param args
	 * 		args[0] name of an input file containing a raw list of symptoms
	 * 		args[1] name of the expected result output file
	 * 		These parameters will be reviewed in the future, depending on the company strategy, which is not defined yet...
	 * 		For instance, a file "HemeBioTechTool.ini" could be provided instead of command line parameters.
	 */
	public static void main(String args[])
	{
		String inputFile, outputFile;
		if (args.length == 2)
		{
			inputFile = args[0];
			outputFile = args[1];
		}
		else
		{
			System.out.println("Syntax : " + HemeBioTechAnalytics.class.getSimpleName() 
					+ " <Name of the provided inputfile>"
					+ " <Name of the result outfile>" );
			inputFile = "symptoms.txt";
			outputFile = "results.out";
			System.out.println("Starting with default values " + inputFile + " & " + outputFile);
		}	
		
		BioAnalyzerSymptomFile analyzer = new BioAnalyzerSymptomFile(inputFile, outputFile);
		analyzer.buildMapFile();
		analyzer.storeMapFile();
	}
}
