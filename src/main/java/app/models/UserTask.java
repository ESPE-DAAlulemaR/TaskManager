package app.models;

import java.util.Date;

import com.mongodb.BasicDBObject;

import system.EntityManager;

public class UserTask extends Task {
	private User user;
	
	public UserTask() {}
	
	public UserTask(User user, Priority priority, Category category, Type type, String task, String detail, Date end)
	{
		super(priority, category, type, task, detail, end);
		this.user = user;
	}
	
	public UserTask(BasicDBObject dbObject)
	{
		super(dbObject);
		
		User user = new User();
		EntityManager em = new EntityManager(user);
		
		user = new User(em.findOneBy("_id", dbObject.getObjectId("User").toString()));
		this.user = user;
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
	    
	    dbObject.append("User", getUser());
	    	    
	    return dbObject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
