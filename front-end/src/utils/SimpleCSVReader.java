package utils;


import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Simple CSV reader
 * 
 * Shamelessly stolen from mykong
 * @author mykong https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 *
 */
public class SimpleCSVReader
{

	public ArrayList<String[]> load(String fileName)
	{

		ArrayList<String[]> lines = new ArrayList<String []>();
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {

            while ((line = br.readLine()) != null)
            {

                // use comma as separator
                String[] seperated = line.split(cvsSplitBy);
                lines.add(seperated);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
		return lines;
	}//end load

}//end class