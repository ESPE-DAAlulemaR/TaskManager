package app.controllers;

import app.models.Category;
import system.EntityManager;

public class CategoryController {
	private Category cat = new Category();
	private EntityManager em = new EntityManager(cat);
	
	public void index()
	{
		for (Object obj : em.read())
			System.out.println(obj.toString());
	}
	
	public void create(String category, boolean state)
	{
		Category cat = new Category(category, state);
		cat.save();
	}
	
	public void update(int id, String category, boolean state)
	{
		cat = new Category(em.findOne(id));
		cat.setCategory(category);
		cat.setState(state);
		cat.update();
		
		cat = new Category();
	}
	
	public void delete(int id)
	{
		cat = new Category(em.findOne(id));
		cat.delete();
		
		cat = new Category();
	}
}
