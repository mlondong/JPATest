package model.OneToOneSharedPrimaryKey;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/*
 * OJO CON LAS SECUENCIAS
 *     @GeneratedValue(strategy=GenerationType.IDENTITY) --> The key value is retrieved after INSERT, the same behavior as the
														     identity strategy.
 	 
 	   @GeneratedValue(strategy=GenerationType.SEQUENCE)-->  Uses a native database sequence named HIBERNATE_SEQUENCE. The
															 sequence is called before each INSERT of a new row. 
       
       @GeneratedValue(strategy=GenerationType.NATIVE) -->   Equivalent to JPA GenerationType.AUTO with the Old mapping.
	   
	   @GeneratedValue(strategy=GenerationType.ENHACED) -->  Always calls the database
															“sequence” before an INSERT, providing the same behavior independently of
															whether the DBMS supports real sequences. Supports an org.hibernate
															.id.enhanced.Optimizer to avoid hitting the database before each INSERT;
															defaults to no optimization and fetching a new value for each INSERT. You can
															find more examples in chapter 20. For all parameters, see the Javadoc for the
															class org.hibernate.id.enhanced.SequenceStyleGenerator. Equivalent to JPA
															GenerationType.SEQUENCE and GenerationType.AUTO 



 * */


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  ///con este GenerationType.IDENTITY puedo traer el id del adress una vez instanciado 
    protected Long id;

    @Column(nullable=false)
    protected String street;

    @Column(nullable=false)    
    protected String zipcode;

    @Column(nullable=false)
    protected String city;


    protected Address() {
    }

    public Address(String street, String zipcode, String city) {
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
    // ...
}
