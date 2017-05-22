package dao;

import entity.Model;

public interface ModelDao {
	public void addMember(Model model);
	public Model getCustomemr(String modelName);
	public int update(Model model);
	public int delete(Model model);
}
