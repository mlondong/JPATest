package model.OneToManyBag;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Bid {

	/*DESDE ACA DE LA CLASE BID SE MAPEA MUCHOS A UNO Y SE AUTOGENERA UN FK_ITEM_ID QUE CORRESPONDE CON EL ID PK DE ITEM*/
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY)
	private Item item;

	private  BigDecimal amount;
	

	public Bid() {
	}

	public Bid(BigDecimal amount, Item item) {
		this.amount = amount;
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	// ...
}
