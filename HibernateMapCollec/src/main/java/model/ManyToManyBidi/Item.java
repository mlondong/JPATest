package model.ManyToManyBidi;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private  Long id;

	private String name;

	@ManyToMany(mappedBy = "items") //ACA HACE REFERENCIA AL ITEMS DEFINIDO EN LA CLASE CATEGORY OJO Y CATEGORY ES QUIEN PERSISTE Y NO AL REVES
	private  Set<Category> categories = new HashSet<Category>();

	
	
	public Item() {
	}

	public Item(String name) {
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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	// ...
}



