package model.OneToOneForeignKey3;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import dao.AbstractDAO;

public class OneToOneJoinTable {

	public static void main(String [] arg){

		/*ESTE EJEMPLO ES DE ONE TO ONE FOREIG KEY WITH JOJN TABLE, ES DECIR SE CREA UNA TABLA INTERMEDIA
		 * CADA SHIPMENT TIENE UN SOLO ITEM UNA VEZ CONFIRMADO EL ITEM SE GENERA EN EL SHIPMENT_ITEM Y SE CREA EL SEGUNDO REGISTRO 
		 * EN SHIPMENT CONFIRMADO EN EL CAMPOS STATE,*/

		/*
		 * CON EL JOJNTABLE GENERA LA TABLA INTERMEDIA Y LUEGO MAPEA LOS CAMPOS FK DE LAS TABLAS ITEM Y SHIPMENT
		@OneToOne(fetch = FetchType.LAZY)  //aca abajo hace el join 
		@JoinTable(
			name = "SHIPMENT_ITEM",  //ESTA ES LA TABLA INTERMEDA QUE ALMACENA
			joinColumns = @JoinColumn(name = "FK_SHIPMENT_ID", referencedColumnName="SHIPMENT_ID"),  
			inverseJoinColumns = @JoinColumn(name = "FK_ITEM_ID", referencedColumnName="ITEM_ID" ,	unique = true) 
			)*/

		Shipment someShipment = new Shipment();
		AbstractDAO.almacenaEntidad(someShipment);

		Item Item = new Item("ITEMMMMM");
		AbstractDAO.almacenaEntidad(Item);

		Shipment auctionShipment = new Shipment(Item); //ACA EL ITEM GENERADO ANTES ES CONFIRMADO CON UN NUEVO REGISTRO DE SHIPMENT Y CON ESTADO 1
		AbstractDAO.almacenaEntidad(auctionShipment);

	}


}
