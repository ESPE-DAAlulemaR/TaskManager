package system;

import java.util.ArrayList;

import com.mongodb.*;

import system.kernel.DataBaseConnection;

public class EntityManager {
	DataBaseConnection mConn = new DataBaseConnection();
	DB db = mConn.getConnection();
	DBCollection collection = null;
	
	public EntityManager() {}
	
	public EntityManager(AbstractModel model)
	{
		collection = model.getEtityCollection();
	}
	
	public void setEntity(AbstractModel model)
	{
		collection = model.getEtityCollection();
	}
	
	public void create(ArrayList<AbstractModel> models)
	{
		for (AbstractModel model : models)
			model.save();
	}
	
	public ArrayList<Object> read()
	{
		DBCursor cursor = collection.find();
		ArrayList<Object> models = new ArrayList<Object>();
		
		try
	    {
			while (cursor.hasNext())
			{
				Object model = (Object) cursor.next();
				models.add(model);
			}
		}
		finally
		{
			cursor.close();
		}
		
		return models;
	}
	
	public ArrayList<Object> find(String field, String value)
	{
		BasicDBObject find = new BasicDBObject();
		find.put(field, value);
		
		DBCursor cursor = collection.find(find);
		ArrayList<Object> models = new ArrayList<Object>();
		
		while (cursor.hasNext())
		{
			Object model = (Object) cursor.next();
			models.add(model);
		}
		
		return models;
	}
	
	public BasicDBObject findOne(int id)
	{
		BasicDBObject find = new BasicDBObject();
		find.put("ID", id);
		DBCursor cursor = collection.find(find);
		BasicDBObject dbObject = (BasicDBObject) cursor.next();
		return dbObject;
	}
	
	public BasicDBObject findOneBy(String field, String value)
	{
		BasicDBObject find = new BasicDBObject();
		find.put(field, value);
		DBCursor cursor = collection.find(find);
		BasicDBObject dbObject = (BasicDBObject) cursor.next();
		return dbObject;
	}
}
