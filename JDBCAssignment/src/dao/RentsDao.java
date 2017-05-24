package dao;

import bean.Rents;

public interface RentsDao {
	public void addRent(Rents rents);
	public Rents getRent(int RNumber);
	public int update(Rents rents);
	public int delete(Rents rents);
}
