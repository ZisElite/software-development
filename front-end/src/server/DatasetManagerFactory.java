package server;

public class DatasetManagerFactory {

	public DatasetManagerFactory() {
		;
	}

	/*
	 * TODO FIX THIS!!! Cannot return null!
	 */
	public IDatasetManager create(String className) {
		switch(className) {
			case "DatasetManager": return null;
			default: return null;
		}

	}
}
