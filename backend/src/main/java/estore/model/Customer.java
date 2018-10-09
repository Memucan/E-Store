package estore.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int id;
	@NotEmpty(message="Firstname cannot be blank")
	private String firstname;
	private String lastname;
	@Email(message="Email address is not well formed")
	@NotEmpty
	@Column(unique=true)
	private String email;
	@Size(max=10,min=10,message="Enter 10 digits phone number")
	private String phonenumber;
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private User user;
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private BillingAddress billingaddress;
	@OneToOne(cascade=CascadeType.ALL)
	@Valid
	private ShippingAddress shippingaddress;
	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BillingAddress getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(BillingAddress billingaddress) {
		this.billingaddress = billingaddress;
	}
	public ShippingAddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(ShippingAddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
		public Cart getCart() {
			return cart;
		}
		public void setCart(Cart cart) {
			this.cart = cart;
		
	}
	
}
