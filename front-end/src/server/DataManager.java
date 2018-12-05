package server;
import  utils.SimpleCSVReader;

import java.util.ArrayList;

public class DataManager implements IDatasetManager
{
	ArrayList<String[]> dataHandler = new ArrayList<String[]>();
	SimpleCSVReader reader = new SimpleCSVReader();

	@Override
	public int registerDataset(String datasetName, String canonicalPath)
	{
		String[] temp = {datasetName, canonicalPath};
				
		if (dataHandler.size() == 0 && !datasetName.equals(""))
		{
			dataHandler.add(temp);
			return 0;
		}
		
		if (datasetName.equals(""))
		{
			return (-1);
		}
		
		for (String[] x : dataHandler)
		{
			if (x[0].equals(datasetName))
			{
				return (-10);
			}
		}
		dataHandler.add(temp);
		return 0;
	}

	@Override
	public String[] retrieveDataset(String datasetName, ArrayList<String[]> data)
	{
		boolean findName = false;
		String[] temp = new String[2];
		for (String[] x : dataHandler)
		{
			
			if (x[0].equals(datasetName))
			{
				findName = true;
				temp[0] = x[0];
				temp[1] = x[1];
				break;
			}
		}
		if (findName == false)
		{
			return null;
		}
		data = reader.load(temp[1]);
		return data.get(0);
	}

	@Override
	public int filterDataset(String originalDatasetName, String newDatasetName, String filterColumnName,
			String filterValue)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String[]> getDatasetProjection(String datasetName, ArrayList<String> attributeNames)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
