package model.OneToOneForeignKey2;


import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;


    protected String username;

    @OneToOne(
        fetch = FetchType.LAZY,
        optional = false, // NOT NULL
        cascade = CascadeType.ALL
    )
    
/*    You don’t need any special identifier generators or primary key assignment; instead of
    @PrimaryKeyJoinColumn, you apply the regular @JoinColumn. If you’re more familiar
    with SQL than JPA, it helps to think “foreign key column” every time you see @Join-
    Column in a mapping.*/

    @JoinColumn(unique = true) // Defaults to ADDRESS_ID , en JPA se puede usara @PrimaryKeyJoinColumn, tambien dice que debe haber una direccion no nulla
    protected Address address;

    public User() {
    }

    public User(String username) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


    // ...
}
