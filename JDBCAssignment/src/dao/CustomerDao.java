package dao;

import entity.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public Customer getCustomemr(int SSN);
	public int update(Customer customer);
	public int delete(Customer customer);
}
