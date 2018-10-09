package estore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class User {
	
	@Id
	@NotEmpty(message="Username is madatory")
	private String username;
	@NotEmpty(message="Password cannot be blank")
	private String password;
	private boolean enabled;
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Authorities authorities;
	@OneToOne(mappedBy="user")
	private Customer customer;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
