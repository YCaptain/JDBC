package service;

import bean.Customer;
import dao.CustomerDao;
import dao.DaoFactory;

public class CustomerService {
	private CustomerDao customerDao;
	
	public CustomerService() {
		customerDao = DaoFactory.getInstace().createCustomerDao();
		System.out.println("customerDao: " + customerDao);
	}
	
	public void regist(Customer customer) {
		if(customer == null) {
			System.out.println("Invalid registration!!");
		} else {
			customerDao.addCustomer(customer);
		}
	}
	
	public Customer query(int SSN) {
		Customer customer = customerDao.getCustomemr(SSN);
		if(customer == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(customer.toString());
		}
		return customer;
	}
	
	public void update(Customer customer) {
		if(customer.getSSN() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			customerDao.update(customer);
		}
	}
	
	public void delete(Customer customer) {
		if(customer.getSSN() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			customerDao.delete(customer);
		}
	}
}
