package server;
import java.util.ArrayList;

public class DataManager implements IDatasetManager
{
	ArrayList<DatasetCreator> datasets = new ArrayList<DatasetCreator>();

	@Override
	public int registerDataset(String datasetName, String canonicalPath)
	{
		//Checks if the provided name is empty
		if(datasetName.equals(""))
		{
			System.out.println("-1");
			return -1;
		}
		
		//Checks if the provided name is already in use
		for(DatasetCreator x : datasets)
		{
			if(datasetName.equals(x.getName()))
			{
				System.out.println("-10");
				return -10;
			}
		}
		
		//Creates new dataset
		DatasetCreator newDataset = new DatasetCreator(datasetName, canonicalPath);
		datasets.add(newDataset);
		newDataset.fillData();
		System.out.println("0");
		return 0;
	}

	@Override
	public String[] retrieveDataset(String datasetName, ArrayList<String[]> data)
	{
		//Iterates through the existed datasets
		for(DatasetCreator x : datasets)
		{
			//Tries to find the dataset with the provided name
			if(datasetName.equals(x.getName()))
			{
				//Fills the empty data parameter
				for(String[] y : x.getData())
				{
					data.add(y);
				}
				System.out.println("Dataset loaded");
				return x.getHeader().get(0);
			}
		}
		System.out.println("Failed to load dataset");
		return null;


	}

	@Override
	public int filterDataset(String originalDatasetName, String newDatasetName, String filterColumnName,
			String filterValue)
	{
		//Checks if new name already exists
		if(originalDatasetName.equals(newDatasetName))
		{
			System.out.println("-1");
			return -1;
		}
		
		//Checks if the provided name is empty
		if(newDatasetName.equals(""))
		{
			System.out.println("-10");
			return -10;
		}
		
		//Iterates through the existing datasets
		for(DatasetCreator x : datasets)
		{
			//Tries to find the dataset with the provided name
			if(originalDatasetName.equals(x.getName()))
			{
				ArrayList<String[]> newData = new ArrayList<String[]>();
				int index = 0;
				
				//Finds the wanted columns index
				for(String y : x.getHeader().get(0))
				{
					if(filterColumnName.equals(y))
					{
						break;
					}
					index ++;
				}
				
				//Returns -11 if column can't be found
				if(index == x.getHeader().get(0).length)
				{
					System.out.println("-11");
					return -11;
				}
				
				newData.add(x.getHeader().get(0));
				
				//Fills the new dataset with the filtered data
				for(String[] j : x.getData())
				{
					if(filterValue.equals(j[index]))
					{
						newData.add(j);
					}
				}
				
				//Returns -100 if the wanted value can't be found
				if(newData.size() == 1)
				{
					System.out.println("-100");
					return -100;
				}
				
				//Creates the filtered dataset
				DatasetCreator newDataset = new DatasetCreator(newDatasetName, originalDatasetName);
				datasets.add(newDataset);
				newDataset.fillData(newData);
				System.out.println("0");
				return 0;
			}
		}
		System.out.println("-1");
		return -1;
	}

	@Override
	public ArrayList<String[]> getDatasetProjection(String datasetName, ArrayList<String> attributeNames)
	{
		//Iterates through the existing datasets
		for(DatasetCreator x : datasets)
		{
			//Tries to find the dataset with the provided name
			if(datasetName.equals(x.getName()))
			{
				ArrayList<String[]> columns = new ArrayList<String[]>();
				int horizontalIndex = 0;
				int verticalIndex = 0;
				
				//Tries to find the x-axis' attribute index
				for(String y : x.getHeader().get(0))
				{
					if(attributeNames.get(0).equals(y))
					{
						break;
					}
					horizontalIndex ++;
				}
				
				//Tries to find the y-axis' attribute index
				for(String j : x.getHeader().get(0))
				{
					if(attributeNames.get(1).equals(j))
					{
						break;
					}
					verticalIndex ++;
				}
				
				//Returns null if either attribute can't be found
				if(horizontalIndex == x.getHeader().get(0).length || verticalIndex == x.getHeader().get(0).length)
				{
					return null;
				}
				
				//Creates the array sets of the two attribute's values and adds them to the soon-to-be return data
				for(String[] k : x.getData())
				{
					String[] temp = new String[2];
					temp[0] = k[horizontalIndex];
					temp[1] = k[verticalIndex];
					
					columns.add(temp);
				}
				System.out.println("Projections retrieved");
				return columns;
			}
		}
		System.out.println("Fail to retrieve projections");
		return null;
	}

}
