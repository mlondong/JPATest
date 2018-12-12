package model.OneToManyList;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
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




	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

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
	 @ManyToOne
	 @JoinColumn(name = "ITEM_ID")
	private Item item;

	@Column(name="AMOUNT")
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

	@Override
	public String toString() {
		return "Bid [id=" + id + ", item=" + item + ", amount=" + amount + "]";
	}

	// ...
}
