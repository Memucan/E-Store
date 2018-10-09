package estore.dao;

import estore.model.Customer;
import estore.model.User;

public interface CustomerDao {
	 
	void registerCustomer(Customer customer);
	boolean isEmailValid(String email);
	boolean isUsernameValid(String username);
	User getUser(String username);
	
}
