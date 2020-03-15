package org.o7planning.sbshoppingcart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "CUSTOMER_ADDRESS")
	private String address;
	@Column(name = "CUSTOMER_EMAIL")
	private String email;
	@Column(name = "CUSTOMER_NAME")
	private String name;
	@Column(name = "CUSTOMER_PHONE")
	private String phone;
	
	
	
	public Products(int id, String address, String email, String name, String phone) {
		this.id = id;
		this.address = address;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", address=" + address + ", email=" + email + ", name=" + name + ", phone="
				+ phone + "]";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
