package system.kernel;

import com.mongodb.*;
import system.config.*;

public class DataBaseConnection {
	private MongoClient mongo = null;
	private DataBase dbConf = null;
	
	public DataBaseConnection()
	{
		this.dbConf = new DataBase(); 
	}
	
	public DB getConnection()
	{
		DB db = null;
		try
		{
			mongo = new MongoClient(dbConf.getServer(), dbConf.getPort());
			db = mongo.getDB(dbConf.getDb());
		}
		catch (Exception e)
		{
			//
		}
		
		return db;
	}
}
