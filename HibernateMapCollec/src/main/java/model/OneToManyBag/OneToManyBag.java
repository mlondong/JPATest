package model.OneToManyBag;

import java.math.BigDecimal;

import dao.AbstractDAO;

public class OneToManyBag {

	public static void main(String [] arg){

		/* 
		 * PARA ESTE EJEMPLO UN ITEM TIENE MUCHOS BIDS Y MUCHOS BIDS TIENE UN ITEM
		 * PARA EL CASO DESDE LA CLASE ITEM SE MAPEA ONETOMANY 
		 * Y DESDE LA CLASE BID SE MAPEA MANYTONE
		 * ASI MISMO EL ADICIONAR EL MISMO BID MAS DE UNA VEZ A UN ITEM NO LO DUPLICA
		 * 
		 * */
		
		
		Item someItem = new Item("Primer Item");
		AbstractDAO.almacenaEntidad(someItem);

		Bid someBid1 = new Bid(new BigDecimal("201.00"), someItem);
		Bid someBid2 = new Bid(new BigDecimal("202.00"), someItem);
		Bid someBid3= new Bid(new BigDecimal("203.00"), someItem);

		
		AbstractDAO.almacenaEntidad(someBid1);
		AbstractDAO.almacenaEntidad(someBid2);
		AbstractDAO.almacenaEntidad(someBid3);


		
		Item item2= new Item("Test de items.... ");
		AbstractDAO.almacenaEntidad(item2);

		Bid bid2 = new Bid(new BigDecimal("100.00"), item2);
		AbstractDAO.almacenaEntidad(bid2);

		

	}




}
