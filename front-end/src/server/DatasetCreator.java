package server;
import java.util.ArrayList;
import utils.SimpleCSVReader;

public class DatasetCreator
{
	private String name = new String();
	private String canonicalPath = new String();
	private ArrayList<String[]> data = new ArrayList<String[]>();
	private ArrayList<String[]> header = new ArrayList<String[]>();
	private SimpleCSVReader reader = new SimpleCSVReader();
	
	public DatasetCreator(String newName, String newPath)
	{
		name = newName;
		canonicalPath = newPath;
	}
	
	//Holds the dataset's Header and Data, in separate arrayLists
	public void fillData()
	{
		data = reader.load(canonicalPath);
		for(String[] x : data)
		{
			header.add(x);
			break;
		}
		data.remove(0);
	}
	
	//Holds the dataset's Header and Data, in separate arrayLists, only used when filtering
	public void fillData(ArrayList<String[]> newData)
	{
		data = newData;
		for(String[] x : data)
		{
			header.add(x);
			break;
		}
		data.remove(0);
	}
	
	public ArrayList<String[]> getHeader()
	{
		return header;
	}
	
	public ArrayList<String[]> getData()
	{
		return data;
	}
	
	public String getName()
	{
		return name;
	}
	public String getPath()
	{
		return canonicalPath;
	}
}
