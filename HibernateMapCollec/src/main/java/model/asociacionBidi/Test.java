package model.asociacionBidi;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import dao.AbstractDAO;

public class Test {

	public static void main(String [] arg){

		/*INSTANCE  BID -> ITEM*/
		
		Item it1 = new Item("fabio");
		Bid b1 = new Bid(1,it1);
		Bid b2 = new Bid(2,it1);
		Bid b3 = new Bid(3,it1);
		it1.add(b1);;
		it1.add(b2);;
		it1.add(b3);;

		
		
		AbstractDAO.almacenaEntidad(it1);
		AbstractDAO.almacenaEntidad(b1);
		AbstractDAO.almacenaEntidad(b2);
		AbstractDAO.almacenaEntidad(b3);
		
		/*Item it1 = new Item("Lorenzo");
		Bid b1 = new Bid(555,it1);
		
		AbstractDAO.almacenaEntidad(it1);
		AbstractDAO.almacenaEntidad(b1);
		*/

	}

}
