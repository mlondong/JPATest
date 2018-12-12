package model.asociacionBidi;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*ESTE EJEMPLO MUESTRA LA ASOCIACION MANY TO ONE .... MUCHOS BID TIENEN UN ITEM.. PARA TAL CASO
 * EL AMY TO ONE LO PERSISTE BID  Y EL ONE TO MANY LO PERSISTE ITEM, PARA AMBAS COSAS DEBEN SER ENTIDADES*/

@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	@Column(name="ID_BID")
	private Long id;

	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="ID_ITEM", nullable=false)
	private Item item;
	
	@Column(name="AMOUNT")
	private int amount;
	
	
	
	public Bid(){}
	
	
	public Bid(int amount, Item item) {
        this.amount = amount;
        this.item = item;
    }
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
