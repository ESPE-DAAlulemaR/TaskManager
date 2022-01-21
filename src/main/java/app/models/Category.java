package app.models;

import com.mongodb.BasicDBObject;

import system.AbstractModel;

public class Category extends AbstractModel {
	private String category;
	private boolean state;
	
	public Category()
	{
		super("Categories");
	}
	
	public Category(String category, boolean state)
	{
		super("Categories");
		this.setCategory(category);
		this.setState(state);
	}
	
	public Category(BasicDBObject dbObject)
	{
		super("Categories");
		this.id = dbObject.getInt("ID");
		this.category = dbObject.getString("Category");
		this.state = dbObject.getBoolean("State");
	}
	
	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("Category", getCategory());
	    dbObject.append("State", getState());
	    	    
	    return dbObject;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
