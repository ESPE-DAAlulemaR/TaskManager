package app.models;

import java.util.*;

import com.mongodb.BasicDBObject;

import system.AbstractModel;
import system.EntityManager;

public class Task extends AbstractModel {
	private Priority priority;
	private Type type;
	private Category category;
	private String task, detail;
	private Date end;
	private boolean state;
	
	public Task()
	{
		super("Tasks");
	}
	
	public Task(Priority priority, Category category, Type type, String task, String detail, Date end)
	{
		super("Tasks");
		this.priority = priority;
		this.category = category;
		this.type = type;
		this.task = task;
		this.detail = detail;
		this.end = end;
		this.state = true;
	}
	
	public Task(BasicDBObject dbObject)
	{
		super("Tasks");
		
		Priority priority = new Priority();
		Type type = new Type();
		Category category = new Category();
		EntityManager em = new EntityManager();
		
		// Priority
		em.setEntity(priority);
		priority = new Priority(em.findOneBy("_id", dbObject.getObjectId("Priority").toString()));
		this.priority = priority;
		
		// Category
		em.setEntity(category);
		category = new Category(em.findOneBy("_id", dbObject.getObjectId("Category").toString()));
		this.category = category;
		
		// Type
		em.setEntity(type);
		type = new Type(em.findOneBy("_id", dbObject.getObjectId("Type").toString()));
		this.type = type;
		
		this.task = dbObject.getString("Task");
		this.detail = dbObject.getString("Detail");
		this.end = dbObject.getDate("End");
		this.state = dbObject.getBoolean("State");
	}
	
	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("Priority", getPriority());
	    dbObject.append("Category", getCategory());
	    dbObject.append("Type", getType());
	    dbObject.append("Task", getTask());
	    dbObject.append("Detail", getDetail());
	    dbObject.append("End", getEnd());
	    dbObject.append("State", getState());
	    	    
	    return dbObject;
	}
	
	public Priority getPriority() {
		return priority;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
