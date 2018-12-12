package model.OneToOneForeignKey;


import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;

    protected String username;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL) /// mappedByCON ESTE MAPEA ADRESS desde user //ESTE PERMITE QUE SE PUEDAN REMOVER COLECCIONES ASOCIADAS
    protected Address shippingAddress;

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

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    // ...
}

