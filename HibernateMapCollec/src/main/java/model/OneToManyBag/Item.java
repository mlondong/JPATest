package model.OneToManyBag;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {

	/*DESDE ACA SE MAPEA ONE A MUCHOS PORQUE UN ITE  TIENE MUCHOS BIDS*/
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item")
    public Collection<Bid> bids = new ArrayList<>();

    
    
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

    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }

    // ...
}

