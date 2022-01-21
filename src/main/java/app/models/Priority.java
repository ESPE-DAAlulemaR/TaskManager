package app.models;

import com.mongodb.BasicDBObject;

import system.AbstractModel;

public class Priority extends AbstractModel {
	private String priority;
	private boolean state;
	
	public Priority()
	{
		super("Priorities");
	}
	
	public Priority(String priority, boolean state)
	{
		super("Priorities");
		this.priority = priority;
		this.state = state;
	}
	
	public Priority(BasicDBObject dbObject)
	{
		super("Priorities");
		this.id = dbObject.getInt("ID");
		this.priority = dbObject.getString("Category");
		this.state = dbObject.getBoolean("State");
	}
	
	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("Priority", getPriority());
	    dbObject.append("State", getState());
	    	    
	    return dbObject;
	}
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
