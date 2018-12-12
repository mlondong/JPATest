package model.OneToOneSharedPrimaryKey;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

	/*ESTE ES UN EJEMPLO DE ONE TO ONE CON PRIMARYKEY COMPARTIDA EN USER NO ESTA EL GENERATEDVALUED
	 * LA PERSISTENCIA NO ES TRANSITIVA PORQUE HAY QUE MAPEAR PRIMERO EL ADRRESS
	 * */
	
	
	@Id
	protected Long id; /// NO SE GENERA EL GENERATEDVALUE

	protected String username;

	@OneToOne(fetch = FetchType.LAZY, optional=false) // Defaults to EAGER // Required for lazy loading with proxies!
 	@PrimaryKeyJoinColumn
	protected Address shippingAddress;


	protected User() {
	}

	public User(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	// ...
}
