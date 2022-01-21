package app.models;

import com.mongodb.BasicDBObject;

import system.AbstractModel;

public class Type extends AbstractModel {
	private String type;
	private boolean state;
	
	public Type()
	{
		super("Types");
	}
	
	public Type(String type, boolean state)
	{
		super("Types");
		this.type = type;
		this.state = state;
	}
	
	public Type(BasicDBObject dbObject)
	{
		super("Types");
		this.id = dbObject.getInt("ID");
		this.type = dbObject.getString("Type");
		this.state = dbObject.getBoolean("State");
	}
	
	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("Type", getType());
	    dbObject.append("State", getState());
	    	    
	    return dbObject;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
