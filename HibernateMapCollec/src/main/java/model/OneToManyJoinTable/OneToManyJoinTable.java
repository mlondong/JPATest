package model.OneToManyJoinTable;

import dao.AbstractDAO;

public class OneToManyJoinTable {



	/*
	 * Perhaps one-to-many is one of the most commonly used associations in Object/Relational Mapping. 
	 * The best practice is to use a separate join table for a one-to-many association to gain flexibility and scalability.
	 *
	 * PARA ESTE CASO SE CREAN 3 TABLAS USER, ITEM Y USERS_ITEMS ESTA ULTIMA CONTIENE LOS IDS DE USERS Y DE ITEMS COMO UNA
	 * TABLA INTERMEDIA, ASI MISMO SE GUARDAN LOS ITEMS SIN IMPORTAR SI TIENEN DENO O NO
	 * 
	 * */

	public static void main(String [] arg){

		
		/*creo los items*/
		Item someItem = new Item("Some Item");
		Item otherItem = new Item("Other Item");
		Item trosiemeItem = new Item("Item 3 q no tiene user");

		AbstractDAO.almacenaEntidad(otherItem);
		AbstractDAO.almacenaEntidad(someItem);
		AbstractDAO.almacenaEntidad(trosiemeItem);

		
		/*creo los user con items*/		
		User user1 = new User("Mauro");
		User user2 = new User("Fabio");
		
		user1.addItem(someItem); // Link
		user1.addItem(otherItem);
		
		AbstractDAO.almacenaEntidad(user1);
		AbstractDAO.almacenaEntidad(user2);


	}


}
