package service;

import dao.DaoFactory;
import dao.ModelDao;
import entity.Model;

public class ModelService {
	private ModelDao modelDao;
	
	public ModelService() {
		modelDao = DaoFactory.getInstace().createModelDao();
		System.out.println("modelDao: " + modelDao);
	}
	
	public void regist(Model model) {
		if(model.getModelNum() <= 0) {
			System.out.println("Invalid registration!!");
		} else {
			modelDao.addModel(model);
		}
	}
	
	public Model query(String modelName) {
		Model model = modelDao.getModel(modelName);
		if(model.getModelNum() <= 0) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(model.toString());
		}
		return model;
	}
	
	public void delete(Model model) {
		if(model.getModelNum() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			modelDao.delete(model);
		}
	}
}
