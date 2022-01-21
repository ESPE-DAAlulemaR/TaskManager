package system.config;

public class DataBase {
	private String server, db;
	private int port;
	
	public DataBase()
	{
		this.server = "localhost";
		this.port = 27017;
		this.db = "task-manager";
	}
	
	public String getServer() {
		return server;
	}

	public int getPort() {
		return port;
	}
	
	public String getDb() {
		return db;
	}
}
