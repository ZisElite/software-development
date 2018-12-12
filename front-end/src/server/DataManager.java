package server;
import java.util.ArrayList;

public class DataManager implements IDatasetManager
{
	ArrayList<DatasetCreator> datasets = new ArrayList<DatasetCreator>();

	@Override
	public int registerDataset(String datasetName, String canonicalPath)
	{
		if(datasetName.equals(""))
		{
			return -1;
		}
		
		for(DatasetCreator x : datasets)
		{
			if(datasetName.equals(x.getName()))
			{
				return -10;
			}
		}
		
		DatasetCreator newDataset = new DatasetCreator(datasetName, canonicalPath);
		datasets.add(newDataset);
		newDataset.fillData();
		return 0;
	}

	@Override
	public String[] retrieveDataset(String datasetName, ArrayList<String[]> data)
	{
		for(DatasetCreator x : datasets)
		{
			if(datasetName.equals(x.getName()))
			{
				for(String[] y : x.getData())
				{
					data.add(y);
				}
				return x.getHeader().get(0);
			}
		}
		return null;


	}

	@Override
	public int filterDataset(String originalDatasetName, String newDatasetName, String filterColumnName,
			String filterValue)
	{
		if(originalDatasetName.equals(newDatasetName))
		{
			return -1;
		}
		
		for(DatasetCreator x : datasets)
		{
			if(originalDatasetName.equals(x.getName()))
			{
				ArrayList<String[]> newData = new ArrayList<String[]>();
				int index = 0;
				
				for(String y : x.getHeader().get(0))
				{
					if(filterColumnName.equals(y))
					{
						break;
					}
					index ++;
				}
				
				newData.add(x.getHeader().get(0));
				
				for(String[] j : x.getData())
				{
					if(filterValue.equals(j[index]))
					{
						newData.add(j);
					}
				}
				
				DatasetCreator newDataset = new DatasetCreator(newDatasetName, originalDatasetName);
				datasets.add(newDataset);
				newDataset.fillData(newData);
				return 0;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<String[]> getDatasetProjection(String datasetName, ArrayList<String> attributeNames)
	{
		for(DatasetCreator x : datasets)
		{
			if(datasetName.equals(x.getName()))
			{
				ArrayList<String[]> columns = new ArrayList<String[]>();
				int horizontalIndex = 0;
				int verticalIndex = 0;
				
				for(String y : x.getHeader().get(0))
				{
					if(attributeNames.get(0).equals(y))
					{
						break;
					}
					horizontalIndex ++;
				}
				
				for(String j : x.getHeader().get(0))
				{
					if(attributeNames.get(1).equals(j))
					{
						break;
					}
					verticalIndex ++;
				}
				
				int z = 0;
				for(String[] k : x.getData())
				{
					if( z == 0)
					{
						z = 1;
						continue;
					}
					String[] temp = new String[2];
					temp[0] = k[horizontalIndex];
					temp[1] = k[verticalIndex];
					
					columns.add(temp);
				}
				for(String[] test : columns)
				{
					System.out.println(test[0] + " " + test[1]);
				}
				return columns;
			}
		}
		return null;
	}

}
