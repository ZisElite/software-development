package test;
import server.DataManager;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTests
{
	DataManager testManager = new DataManager();
	
	//Test registerDataset method
	@Test
	public void registerValidName()
	{
		int result = testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		assertEquals(0, result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void registerNoName()
	{
		int result = testManager.registerDataset("", "Resources\\NBA_team_stats.csv");
		assertEquals(-1, result);
		//fail("Not yet implemented");

	}
	
	@Test
	public void registerSameName()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		int result = testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		assertEquals(-10, result);
		//fail("Not yet implemented");


	}
	
	
	
	//Test retrieveDataset method
	@Test
	public void retrieveValidName()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		ArrayList<String[]> data = new ArrayList<String[]>();
		String[] expectedHeader = {"SeasonEnd", "Team", "Playoffs", "W", "PTS", "oppPTS", "FG", "FGA", "2P", "2PA", 
								   "3P", "3PA", "FT", "FTA", "ORB", "DRB", "AST", "STL", "BLK", "TOV"};
		String[] testHeader = testManager.retrieveDataset("Test", data);
		for(int i = 0; i < 20; i++)
		{
			assertEquals(expectedHeader[i], testHeader[i]);
		}
		//fail("Not yet implemented");
	}
	
	@Test
	public void retrieveWrongName()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		ArrayList<String[]> data = new ArrayList<String[]>();
		String[] testHeader = testManager.retrieveDataset("T", data);
		assertEquals(null, testHeader);
		//fail("Not yet implemented");
	}
	
	
	
	//Test filterDataset method
	@Test
	public void filterValid()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		int result = testManager.filterDataset("Test", "New", "W", "50");
		assertEquals(0, result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void filterSameName()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		int result = testManager.filterDataset("Test", "Test", "W", "50");
		assertEquals(-1, result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void filterNoName()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		int result = testManager.filterDataset("Test", "", "W", "50");
		assertEquals(-10, result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void filterInValidColumn()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		int result = testManager.filterDataset("Test", "New", "", "50");
		assertEquals(-11, result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void filterInvalidValue()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		int result = testManager.filterDataset("Test", "New", "W", "");
		assertEquals(-100, result);
		//fail("Not yet implemented");
	}
	
	
	
	//Test getDatasetProjection method
	@Test
	public void getProjectionValid()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		testManager.filterDataset("Test", "New", "W", "50");
		ArrayList<String[]> testProjection = new ArrayList<String[]>();
		String[] temp1 = {"1980", "50"}; testProjection.add(temp1);
		String[] temp2 = {"1981", "50"}; testProjection.add(temp2);
		String[] temp3 = {"1984", "50"}; testProjection.add(temp3);
		String[] temp4 = {"1986", "50"}; testProjection.add(temp4);
		String[] temp5 = {"1987", "50"}; testProjection.add(temp5);
		String[] temp6 = {"1988", "50"}; testProjection.add(temp6);
		String[] temp7 = {"1988", "50"}; testProjection.add(temp7);
		String[] temp8 = {"1991", "50"}; testProjection.add(temp8);
		String[] temp9 = {"1994", "50"}; testProjection.add(temp9);
		String[] temp10 = {"1994", "50"}; testProjection.add(temp10);
		String[] temp11 = {"1995", "50"}; testProjection.add(temp11);
		String[] temp12 = {"1998", "50"}; testProjection.add(temp12);
		String[] temp13 = {"2000", "50"}; testProjection.add(temp13);
		String[] temp14 = {"2000", "50"}; testProjection.add(temp14);
		String[] temp15 = {"2001", "50"}; testProjection.add(temp15);
		String[] temp16 = {"2001", "50"}; testProjection.add(temp16);
		String[] temp17 = {"2002", "50"}; testProjection.add(temp17);
		String[] temp18 = {"2002", "50"}; testProjection.add(temp18);
		String[] temp19 = {"2003", "50"}; testProjection.add(temp19);
		String[] temp20 = {"2003", "50"}; testProjection.add(temp20);
		String[] temp21 = {"2003", "50"}; testProjection.add(temp21);
		String[] temp22 = {"2004", "50"}; testProjection.add(temp22);
		String[] temp23 = {"2005", "50"}; testProjection.add(temp23);
		String[] temp24 = {"2006", "50"}; testProjection.add(temp24);
		String[] temp25 = {"2007", "50"}; testProjection.add(temp25);
		String[] temp26 = {"2008", "50"}; testProjection.add(temp26);
		String[] temp27 = {"2009", "50"}; testProjection.add(temp27);
		String[] temp28 = {"2010", "50"}; testProjection.add(temp28);
		String[] temp29 = {"2010", "50"}; testProjection.add(temp29);
		String[] temp30 = {"2010", "50"}; testProjection.add(temp30);
		String[] temp31 = {"2010", "50"}; testProjection.add(temp31);
		String[] temp32 = {"2011", "50"}; testProjection.add(temp32);
		ArrayList<String> testAttributes = new ArrayList<String>(); 
		testAttributes.add("SeasonEnd");
		testAttributes.add("W");
		ArrayList<String[]> result = testManager.getDatasetProjection("New", testAttributes);
		for(int i = 0; i < 32; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				assertEquals(testProjection.get(i)[j], result.get(i)[j]);
			}
		}
	}
	
	@Test
	public void getProjectionInvalidName()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		testManager.filterDataset("Test", "New", "W", "50");
		ArrayList<String> testAttributes = new ArrayList<String>(); 
		testAttributes.add("SeasonEnd");
		testAttributes.add("W");
		ArrayList<String[]> result = testManager.getDatasetProjection("", testAttributes);
		assertEquals(null, result);
	}
	
	@Test
	public void getProjectionInvalidAttribute()
	{
		testManager.registerDataset("Test", "Resources\\NBA_team_stats.csv");
		testManager.filterDataset("Test", "New", "W", "50");
		ArrayList<String> testAttributes = new ArrayList<String>(); 
		testAttributes.add("seasonEnd");
		testAttributes.add("W");
		ArrayList<String[]> result = testManager.getDatasetProjection("", testAttributes);
		assertEquals(null, result);
	}
}
