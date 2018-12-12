package model.OneToOneForeignKey;


import javax.persistence.*;


@Entity
public class Address {

	
	//value = "user" HACE REFERENCIA A la clase User, EL ID SE GENERA MANUAL POR HIBERNATE
	@Id
	@GeneratedValue(generator = "addressKeyGenerator")
	@org.hibernate.annotations.GenericGenerator(name = "addressKeyGenerator", 
	strategy = "foreign",	
	parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user" ))   
	protected Long id;

	@OneToOne(optional = false) // Create FK constraint on PK column
	@PrimaryKeyJoinColumn
	protected User user;

	@Column(nullable=false)
	protected String street;

	@Column(nullable=false)
	protected String zipcode;

	@Column(nullable=false)
	protected String city;




	protected Address() {
	}

	public Address(User user) {
		this.user = user;
	}

	public Address(User user, String street, String zipcode, String city) {
		this.user = user;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User getUser() {
		return user;
	}
	// ...
}
