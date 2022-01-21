package app.controllers;

import java.util.*;
import app.models.*;
import system.EntityManager;

public class TeamController {

	public void index()
	{
		Team team = new Team();
		EntityManager em = new EntityManager(team);
				
		for (Object obj : em.read())
			System.out.println(obj.toString());
	}
	
	public void create(String name, ArrayList<Object> members)
	{
		Team team = new Team(name, members, true);
		team.save();
	}
	
	public void addMember(User user, Team team)
	{
		team.getMembers().add(user);
	}
}
