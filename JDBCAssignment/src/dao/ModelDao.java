package dao;

import entity.Model;

public interface ModelDao {
	public void addModel(Model model);
	public Model getModel(String modelName);
	public int update(Model model);
	public int delete(Model model);
}
