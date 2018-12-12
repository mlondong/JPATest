package model.OneToManyList;

import java.math.BigDecimal;

import dao.AbstractDAO;

public class OneToManyList {

	public static void main(String [] arg){

		/*
		 * 
		 * OJO CON ESTE EJEMPLO ES IMPORTANTE  
		 *  
		 *  ESTRATEGIA ONE TO MANY BIDIRECCIONAL
		 *
		 * 
		 * 
		 * ESTA ESTRATEGIA ES SIMILAR AL @ONETOMANY DEL PRIMER EJEMPLO  SALVO QUE 
		 * PARA ESTE CASO:
		 * 
		 * UN ITEM -> TIENE MUCHOS BID
		 * AAHORA DESDE ITEM SE ORDENAN LOS BID POR INGRESOY SE HACE UN JOINCOLUMN A ITEM_ID
		 * 
		 * Y DESDE BID SE HACE EL MANYTOONE Y SE HACE EL JOINCOLUMN CON ITEM_ID
		 *
		 * PARA ESTE CASO NO PERMTE QUE EXISTAN ITEMS SIN BIDS HACE LAS SGTES OPERACIONES PARA UN SOLO ITEM CON BIDS, PARA E CASO
		 * UN ITEM TIENE 3 BIDS Y HACE 3 INSERTS Y LUEGO HACE LOS UPDATES 
		 * 
			Hibernate: 
    	/* 				insert model.OneToManyList.Item insert  into Item (NAME) values (?)
			Hibernate: 
    	/* 				insert model.OneToManyList.Bid insert  into   Bid (AMOUNT)  values    (?)
		 				insert model.OneToManyList.Bid insert  into   Bid (AMOUNT)  values    (?)
		 				insert model.OneToManyList.Bid insert  into   Bid (AMOUNT)  values    (?)
		 				
						Update Bid  set  ITEM_ID=?,   BID_POSITION=?  where    ID=? 
						Update Bid  set  ITEM_ID=?,   BID_POSITION=?  where    ID=? 
						Update Bid  set  ITEM_ID=?,   BID_POSITION=?  where    ID=? 
		 *				
		 *			
		 * */


		 Item item = new Item("Primer Item");
		 Bid bid_1= new Bid(new BigDecimal("123.00"), item);
		 item.getBids().add(bid_1);
		 Bid bid_2= new Bid(new BigDecimal("1000.00"), item);
		 item.getBids().add(bid_2);
		 Bid bid_3= new Bid(new BigDecimal("3.00"), item);
		 item.getBids().add(bid_3);

		 AbstractDAO.almacenaEntidad(item);



		 Item item_2 = new Item("sECOND Item");
		 Bid bid_X= new Bid(new BigDecimal("4.00"), item_2);
		 item_2 .getBids().add(bid_X);
		 Bid bid_Y= new Bid(new BigDecimal("5.00"), item_2);
		 item_2.getBids().add(bid_Y);
		 AbstractDAO.almacenaEntidad(item_2);


		 Item item_3 = new Item("THIRD Item");
		 AbstractDAO.almacenaEntidad(item_3);
	


	}




}
