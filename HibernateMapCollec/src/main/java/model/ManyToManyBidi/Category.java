package model.ManyToManyBidi;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.JoinTable;
	import javax.persistence.ManyToMany;
	import java.util.HashSet;
	import java.util.Set;

	@Entity
	public class Category {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "CATEGORY_ITEM",
	        joinColumns = @JoinColumn(name = "CATEGORY_ID"),
	        inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
	    )
	    private Set<Item> items = new HashSet<Item>();

	 
	    
	    public Category() {
	    }

	    public Category(String name) {
	        this.name = name;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Set<Item> getItems() {
	        return items;
	    }

	    public void setItems(Set<Item> items) {
	        this.items = items;
	    }

	    // ...
	}
