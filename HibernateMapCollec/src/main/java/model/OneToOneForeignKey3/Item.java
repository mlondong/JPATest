package model.OneToOneForeignKey3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	/**/
    @Id
    @Column(name="ITEM_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY ) //genera id y lo mantiene 
    private Long id;

    @Column(name="NAME")
    private String name;

    
    
    
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


