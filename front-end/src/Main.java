import client.MainApp;

public class Main
{

	public static void main(String[] args)
	{
		ControlManager manager = new ControlManager();
		MainApp mapp = new MainApp();
		mapp.main(args);
		manager.start();
		System.exit(0);
		
	}

}