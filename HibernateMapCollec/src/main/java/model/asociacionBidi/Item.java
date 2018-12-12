package model.asociacionBidi;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/* ESTA ESUNA ASOCIACION BIDIRECCIONAL
 * EN ESTA CLASE ITEM SE TIENE UNA COLLECION DE BIDS ES UNA RELACION UNO A MUCHOS Y DESDE BID ES DE MUCHOS A UNO
 * PARA MAPEAR ES NECESARIO @OneToMany(mappedBy="item"  item representa el que contiene los otros datos Y DE SDE BID SE HACE AL CONTRARIO*/


@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ITEM")
    private Long id;
    
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="item" ,    //mappedBy se usa qie mantiene la relacion de 1 a muchos en este caso item
			   fetch=FetchType.LAZY,
			   cascade= CascadeType.PERSIST)
	private Set<Bid> bids = new HashSet<>();

	
    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Bid> getBids() {
		return bids;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public void add(Bid e){
		this.bids.add(e);
	}
	
}
