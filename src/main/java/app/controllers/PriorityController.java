package app.controllers;

import app.models.Priority;
import system.EntityManager;

public class PriorityController {
	private Priority pr = new Priority();
	private EntityManager em = new EntityManager(pr);
	
	public void index()
	{
		for (Object obj : em.read())
			System.out.println(obj.toString());
	}
	
	public void create(String category, boolean state)
	{
		pr = new Priority(category, state);
		pr.save();
		
		pr = new Priority();
	}
	
	public void update(int id, String priority, boolean state)
	{
		pr = new Priority(em.findOne(id));
		pr.setPriority(priority);
		pr.setState(state);
		pr.update();
		
		pr = new Priority();
	}
	
	public void delete(int id)
	{
		pr = new Priority(em.findOne(id));
		pr.delete();
		
		pr = new Priority();
	}
}
