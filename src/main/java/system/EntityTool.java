package system;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import system.kernel.DataBaseConnection;

public class EntityTool {
	
	DataBaseConnection mConn = new DataBaseConnection();
	DB db = mConn.getConnection();
	
	public static int nextId(String dbCollection)
	{
		int lastId = 0, nextId = 0;
		
		DataBaseConnection mConn = new DataBaseConnection();
		DB db = mConn.getConnection();
		DBCollection collection = db.getCollection("LatestIds");
		
		BasicDBObject find = new BasicDBObject();
		find.put("Collection", dbCollection);
		DBCursor cursor = collection.find(find);
		
		if (cursor.size() == 0)
		{
			nextId = 1;
			find.append("Collection", dbCollection);
			find.append("LastId", nextId);
			collection.insert(find);
		}
		else
		{
			BasicDBObject dbObject = (BasicDBObject) cursor.next();
			nextId = dbObject.getInt("LastId");
			System.out.print(nextId);
			nextId++;
			//System.out.println(nextId);
			DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("LastId", nextId));
			//find.append("LastId", nextId);
			collection.findAndModify(find, updated);
		}
		
		return nextId;
	}
	
}
