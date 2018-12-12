package model.OneToManyEmbeddable;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="USER_ID")
    protected Long id;

    @Column(name="USERNAME")
    protected String username;
    
    // UN USUARIO SOLO PUEDE TENER 1 DIRECCION Y EN ESA DIRECCION PUEDEN HABER MUCHOS SHIMENTS
    @Embedded
    protected Address shippingAddress;

    
    public Long getId() {
        return id;
    }

    
    public User() {
    }

    public User(String username) {
        this.username = username;
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

}
