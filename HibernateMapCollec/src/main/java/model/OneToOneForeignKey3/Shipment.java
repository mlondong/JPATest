package model.OneToOneForeignKey3;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Shipment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)// ESTA GenerationType.IDENTITY GENERA ID Y LO MANTIENE RECUPERABLE
	@Column(name="SHIPMENT_ID")
	private Long id;

	@Column(nullable=false,name="DATE_CREATION" )
	private Date createdOn = new Date();

	/*ACA GENERO LA TABLA INTERMEDIA CON LOS FK DE LAS TABLAS ITEM Y SHIPMENT, USA JOINCOLUMN Y EL INVERSOJOINCLOUMN
	 * NOMBRE DE LA TABLA INTERMEDIA : SHIPMENT_ITEM
	 * COLUMNA FK SHIPMENT_ID DE SHIPMENT
	 * COLUMNA FK ITEM_ID DE ITEM
	 * 
	 * 
	 * ESTE EJEMPLO DEMUESTRA EL ESTADO DEL ITEM
	 * EN PRIMERA INSTANCIA SE CREA UN SHIPMENT EN ESTADO TRANSIT
	 * LUEGO SE CREA EL ITEM
	 * LUEGO SE CREA OTRO SHIPMENT CON EL ITEM QUE CAMBIA DE ESTADO A CONFIRMED,
	 * EL LA TABLA SHIPMENT SE VA A GNERAR 2 REGISTROS UNO EN ESTADO TRANSIT Y OTRO EN ESTADO CONFIRMED
	 * PERO EL SEGUNDO SHIPMENT CREADO VA A TENER EL ESTADO CONFIRMED EN LA TABLA INTERMEDIA SHIPMENT_ITEM
	 * 
	 * */
	@OneToOne(fetch = FetchType.LAZY)  //aca abajo hace el join 
	@JoinTable(
			name = "SHIPMENT_ITEM", 
			joinColumns = @JoinColumn(name = "FK_SHIPMENT_ID", referencedColumnName="SHIPMENT_ID"),  
			inverseJoinColumns = @JoinColumn(name = "FK_ITEM_ID", referencedColumnName="ITEM_ID" ,	unique = true) 
			)
	private Item auction;

	/*ESTE FUNCIONA COMO UN BOOLEANO*/
	@Column(nullable=false, name="SHIPMENTSTATE")
	private ShipmentState shipmentState; // aca hago uso del ENUM shipment


	public Shipment() {
		this.shipmentState = ShipmentState.TRANSIT;
	}

	public Shipment(Item auction) {
		this.shipmentState = ShipmentState.CONFIRMED;
		this.auction = auction;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public ShipmentState getShipmentState() {
		return shipmentState;
	}

	public void setShipmentState(ShipmentState shipmentState) {
		this.shipmentState = shipmentState;
	}

	public Item getAuction() {
		return auction;
	}

	public void setAuction(Item auction) {
		this.auction = auction;
	}
	// ...
}



