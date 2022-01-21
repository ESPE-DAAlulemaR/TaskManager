package system;

import java.util.*;
import com.mongodb.*;
import system.kernel.*;

public abstract class AbstractModel {
	
	protected int id;
	private String dbCollection = null;
	
	DataBaseConnection mConn = new DataBaseConnection();
	DB db = mConn.getConnection();
	DBCollection collection = null;
	
	public AbstractModel(String dbCollection)
	{
		this.setDbCollection(dbCollection);
		collection = db.getCollection(dbCollection);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDbCollection() {
		return dbCollection;
	}

	public void setDbCollection(String dbCollection) {
		this.dbCollection = dbCollection;
	}
	
	public void save()
	{
		setId(EntityTool.nextId(this.dbCollection));
		collection.insert(this.toDBObject());
	}
	
	public void update()
	{
		DBObject find = new BasicDBObject("ID", getId());
		DBObject updated = toDBObject();
		collection.findAndModify(find, updated);
	}
	
	public void delete()
	{
		DBObject model = new BasicDBObject("ID", getId());
		collection.remove(model);
	}
	
	public DBCollection getEtityCollection()
	{
		return this.collection;
	}
	
	public abstract BasicDBObject toDBObject();
}
