package model.OneToManyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.Cascade;

@Entity
public class Item {

	
	/*The @JoinColumn annotation combined with a @OneToOne mapping indicates 
	 * that a given column in the owner entity refers to a primary key in the reference entity:
	 * 
	 * PARA ESTE CASO DESDE ITEM SE USA @ONETOMANY Y DESDE BID SE USA @MANYTOONE
	 * 
	 * */
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    /**/
	/*PARA EL CASO DE BID HAY 2 ALTERNATIVAS LA PRIMERA QUE SE MANEJE 
	 *
	 *  @ManyToOne
	    @JoinColumn(name = "ITEM_ID")
	    EN ESTE CASO  EL cascade= CascadeType.ALL OCURRE EN ITEM


	EL OTRO CASO ES QUE YO USE EL cascade= CascadeType.ALL DESDE BID, PARA ESE CASO  QUEDARIA ASI
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID")

	EN AMBOS CASOS DEBERIA HACER DIFERENTE EL MAPEO DESDE EL MAIN , AL INSTANCIAR OJO AHI 

	 * */

    @OneToMany(cascade= CascadeType.ALL)  //OJO ACA EL cascade= CascadeType.ALL REFERENCIA A SU CHILD Y MANTIENE EL ID DEL ITEM PARA ERADICIONADO 
    @JoinColumn(name = "ITEM_ID")
    @OrderColumn(name = "BID_POSITION")
    public List<Bid> bids = new ArrayList<>();

    
    
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

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    // ...
}

