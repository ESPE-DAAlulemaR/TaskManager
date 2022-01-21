package app.controllers;

import java.util.*;

import app.models.*;
import system.EntityManager;
import system.Session;

public class TaskController {
	
	public void index()
	{
		Task task = new Task();
		EntityManager em = new EntityManager(task);
				
		for (Object obj : em.read())
			System.out.println(obj.toString());
	}
	
	public void create(Priority priority, Category category, Type type, String task, String detail, Date end, Team team)
	{
		if (category.getCategory() == "User")
			createTaskUser(priority, category, type, task, detail, end);
		if (category.getCategory() == "Team")
			createTaskTeam(team, priority, category, type, task, detail, end);
	}
	
	public void createTaskUser(Priority priority, Category category, Type type, String task, String detail, Date end)
	{
		Session auth = new Session(); 
		UserTask userTask = new UserTask(auth.authUser(), priority, category, type, task, detail, end);
		userTask.save();
	}
	
	public void createTaskTeam(Team team, Priority priority, Category category, Type type, String task, String detail, Date end)
	{
		TeamTask teamTask = new TeamTask(team, priority, category, type, task, detail, end);
		teamTask.save();
	}
	
	public void divideTask(TeamTask taskTeam, User person, String detail, Date end)
	{
		if (taskTeam.getCategory().getCategory() == "Team")
		{
			PartTeamTask part = new PartTeamTask(taskTeam, person, detail, end);
			part.save();
		}
	}
}
