package server;

public class DatasetManagerFactory {

	public DatasetManagerFactory() {
		;
	}


	public IDatasetManager create(String className) {
		switch(className) {
			case "DatasetManager":
				return new DataManager();
			default: return null;
		}

	}
}
