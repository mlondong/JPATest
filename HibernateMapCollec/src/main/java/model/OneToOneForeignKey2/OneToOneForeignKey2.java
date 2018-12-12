package model.OneToOneForeignKey2;

import dao.AbstractDAO;

public class OneToOneForeignKey2 {


	public static void main(String [] arg){
		
		/*en este ejemplo genero el objeto user para luego crgarle el objeto adress one to one y luego almacenar
		 * en la clase Adress no esta compartida el primarykey, y tampoco el objeto User, en cambio en la clase User se genera el objto Adress*/
		
		/*ESTE ES UN EJEMPLO DE ONE TO ONE JOIN COLUMN
		 * AL EJECUTAR SE GENERARA EN LA TABLA USER UN ID DE ADDRESS CON EL ID GENERADO EN USER QUE HACE LA ASOCIACION RELACIONAL 
		 * SI NO SE ADICIONA LA ADRESS AL USER SALDRA UN ERROR COMO EN EL ULTIMO EJEMPLO
		 * 
		 *  EN LA TABLA USER SE GENERA UN FOREING KEY A ADRESS
		 *  
		 *  */
		
		User user1 = new User("johndoe");
		Address someAddress = 	new Address("Some Street 123", "12345", "Some City");
		user1.setAddress(someAddress);
		AbstractDAO.almacenaEntidad(user1);

		User user2 = new User("MAURICIO");
		Address someAddress2 = 	new Address("Some Street 123", "111", "Buenos aires");
		user2.setAddress(someAddress2);
		AbstractDAO.almacenaEntidad(user2);

		User user4 = new User("Martha");
		Address ad4= new Address("Billighurts", "269", "Buenos aires");
		user4.setAddress(ad4);
		AbstractDAO.almacenaEntidad(user4); 
	
		
		User user3 = new User("Martha");
		AbstractDAO.almacenaEntidad(user3); /// aca va a saltar error porque no puede ser NULL la Adress
	
	}


}
