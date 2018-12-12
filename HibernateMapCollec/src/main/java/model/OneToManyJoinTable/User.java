package model.OneToManyJoinTable;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

	
	/*LA CLASE USER MANTIENE UNA RELACION ONETOMANY CON ITEMS, A TRAVES DE UNA TABLA ENLACE USER_ITEMS 
	 * QUE SE CREA DESDE LA TABLA USER EN LA CONFIGURACION DE ITEMS
	 * ESA TABLA CONTIENE LOS IDS DE USERS Y DE ITEMS EN CASO DE QUE LOS TENGA */
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USERS_ITEMS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private Set<Item> boughtItems = new HashSet<Item>();

    private String username;
    

    
    
    public User() { }

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

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

   public void addItem(Item it){
	   this.boughtItems.add(it);
   }

    // ...
}
