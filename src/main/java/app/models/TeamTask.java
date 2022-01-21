package app.models;

import java.util.Date;

import com.mongodb.BasicDBObject;

import system.EntityManager;

public class TeamTask extends Task {
	private Team team;
	
	public TeamTask() {}
	
	public TeamTask(Team team, Priority priority, Category category, Type type, String task, String detail, Date end)
	{
		super(priority, category, type, task, detail, end);
		this.team = team;
	}
	
	public TeamTask(BasicDBObject dbObject)
	{
		super(dbObject);
		
		Team team = new Team();
		EntityManager em = new EntityManager(team);
		
		team = new Team(em.findOneBy("_id", dbObject.getObjectId("Team").toString()));
		this.team = team;
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
	    
	    dbObject.append("Team", getTeam());
	    	    
	    return dbObject;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
