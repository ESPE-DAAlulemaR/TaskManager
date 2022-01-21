package app.models;

import java.util.Date;

import com.mongodb.BasicDBObject;

import system.AbstractModel;
import system.EntityManager;

public class PartTeamTask extends AbstractModel {
	private TeamTask taskTeam;
	private User person;
	private String detail;
	private Date end;
	
	public PartTeamTask()
	{
		super("PartsTeamTasks");
	}
	
	public PartTeamTask(TeamTask taskTeam, User person, String detail, Date end)
	{
		super("PartsTeamTasks");
		this.taskTeam = taskTeam;
		this.person = person;
		this.detail = detail;
		this.end = end;
	}
	
	public PartTeamTask(BasicDBObject dbObject)
	{
		super("PartsTeamTasks");
		
		EntityManager em = new EntityManager();
		TeamTask task = new TeamTask();
		User user = new User();
		
		this.id = dbObject.getInt("ID");
		
		em.setEntity(user);
		user = new User(em.findOneBy("_id", dbObject.getObjectId("Person").toString()));
		this.person = user;
		
		em.setEntity(task);
		task = new TeamTask(em.findOneBy("_id", dbObject.getObjectId("TaskTeam").toString()));
		this.taskTeam = task;
		
		this.detail = dbObject.getString("Detail");
		this.end = dbObject.getDate("End");
	}

	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("TaskTeam", getTaskTeam());
	    dbObject.append("Person", getPerson());
	    dbObject.append("Detail", getDetail());
	    dbObject.append("End", getEnd());
	    	    
	    return dbObject;
	}
	
	public TeamTask getTaskTeam() {
		return taskTeam;
	}

	public void setTaskTeam(TeamTask taskTeam) {
		this.taskTeam = taskTeam;
	}

	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
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
}
