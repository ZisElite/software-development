package server;

import java.util.ArrayList;

public class DataManager implements IDatasetManager
{

	@Override
	public int registerDataset(String datasetName, String canonicalPath)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] retrieveDataset(String datasetName, ArrayList<String[]> data)
	{
		// TODO Auto-generated method stub
		return null;
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
