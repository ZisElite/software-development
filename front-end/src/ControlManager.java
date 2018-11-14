
public class ControlManager
{
	CSVPresenter csvViewer = new CSVPresenter();
	DataSetCreator dataCreator = new DataSetCreator();
	DataSetFilter filterer = new DataSetFilter();
	DataSetPresenter dataViewer = new DataSetPresenter();
	GraphCreator graphCreator = new GraphCreator();
	
	public void start()
	{
		int answer = 0;
		do
		{
			/*
			 * Ask the user what action he wants from the below:
			 * 1. View a CSV file
			 * 2. Create a data set from a CSV file
			 * 3. Create a filtered data set from an existing one
			 * 4. View an existing data set
			 * 5. Create a graph from a data set
			 * 6. Exit program
			 */
		}
		while(answer < 1 && answer > 7);
		
		if(answer == 1)
		{
			csvViewer.view();
		}
		else if(answer == 2)
		{
			dataCreator.create();
		}
		else if(answer == 3)
		{
			filterer.filter();
		}
		else if(answer == 4)
		{
			dataViewer.view();
		}
		else if(answer == 5)
		{
			graphCreator.create();
		}
		else
		{
			return;
		}
	}
	
	
}
