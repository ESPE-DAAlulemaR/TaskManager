package app.controllers;

import app.models.*;
import system.EntityManager;

public class UserController {
	private User user = new User();
	private EntityManager em = new EntityManager(user);
	
	public void index()
	{
		for (Object obj : em.read())
			System.out.println(obj.toString());
	}
	
	public void create(String name, String lastname, String username, String password)
	{
		User user = new User(name, lastname, username, password);
		user.save();
	}
	
	public void asyncTeam(int idUser, int idTeam)
	{
		Team team = new Team();
		
		User user = new User(em.findOne(idUser));
		
		em.setEntity(team);
		team = new Team(em.findOne(idTeam));
		
		user.getTeam().add(team);
		user.update();
	}
}
