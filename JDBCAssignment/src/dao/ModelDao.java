package dao;

import bean.Model;

public interface ModelDao {
	public void addModel(Model model);
	public Model getModel(int modelNum);
	public int update(Model model);
	public int delete(Model model);
}
