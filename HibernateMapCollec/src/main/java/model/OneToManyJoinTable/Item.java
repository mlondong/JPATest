package model.OneToManyJoinTable;

import javax.persistence.*;


@Entity
public class Item {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	private String name;

	//@ManyToOne(fetch = FetchType.LAZY)
	/*@JoinTable(
			name = "ITEM_BUYER",
			joinColumns =@JoinColumn(name = "ITEM_ID"), 
			inverseJoinColumns =@JoinColumn(nullable = false, unique=true) // Defaults to BUYER_ID
			)*/
	
	
		
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

	
	// ...
}
