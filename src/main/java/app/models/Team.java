package app.models;

import java.util.*;

import com.mongodb.*;

import system.AbstractModel;

public class Team extends AbstractModel {
	private String team;
	private ArrayList<Object> members;
	private boolean state;
	
	public Team()
	{
		super("Teams");
	}
	
	public Team(String team, ArrayList<Object> members, boolean state)
	{
		super("Teams");
		this.team = team;
		this.members = members;
		this.state = state;
	}
	
	public Team(BasicDBObject dbObject)
	{
		super("Teams");
		this.id = dbObject.getInt("ID");
		this.team = dbObject.getString("Team");
		BasicDBList members = (BasicDBList) dbObject.get("Members");
		
		for (Object member : members)
			this.members.add(member);
		
		this.state = dbObject.getBoolean("State");
	}
	
	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("Members", getMembers());
	    dbObject.append("State", getState());
	    	    
	    return dbObject;
	}
	
	public ArrayList<Object> getMembers() {
		return members;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
}
