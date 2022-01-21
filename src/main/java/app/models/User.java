package app.models;

import java.util.*;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import system.AbstractModel;
import system.EntityManager;

public class User extends AbstractModel {
	private String username, name, lastname, password;
	private ArrayList<Object> teams;
	
	public User()
	{
		super("Users");
	}
	
	public User(String name, String lastname, String username, String password)
	{
		super("Users");
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	
	public User(BasicDBObject dbObject)
	{
		super("Users");
		
		this.id = dbObject.getInt("ID");
		this.name = dbObject.getString("Name");
		this.lastname = dbObject.getString("Lastname");
		this.username = dbObject.getString("Username");
		this.password = dbObject.getString("Password");
		BasicDBList teams = (BasicDBList) dbObject.get("Teams");
		
		System.out.println(teams.isEmpty());
		
		for (Object team : teams)
			this.teams.add(team);
	}
	
	@Override
	public BasicDBObject toDBObject() {
		BasicDBObject dbObject = new BasicDBObject();

		dbObject.append("ID", getId());
	    dbObject.append("Name", getName());
	    dbObject.append("Lastname", getLastname());
	    dbObject.append("Username", getUsername());
	    dbObject.append("Password", getPassword());
	    dbObject.append("Teams", getTeam());
	    	    
	    return dbObject;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Object> getTeam() {
		return teams;
	}
}
