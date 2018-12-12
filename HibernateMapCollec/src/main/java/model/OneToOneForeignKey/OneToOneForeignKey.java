package model.OneToOneForeignKey;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import dao.AbstractDAO;

public class OneToOneForeignKey {

	public static void main(String [] arg){

		/*ESTE EJEMPLO ES ONETOONE SIN EMBARGO MAPEA DESDE SER MAPEDBY HACIENDOLO BIDIRECCIONAL
		 * Note that with this mapping, you won’t get lazy loading of User#shippingAddress (it’s
			optional/nullable), but you can load Address#user on demand with proxies (it’s nonoptional).
		 	CON ESTE EJEMPLO SE GENERA UN KEY @OneToOne(mappedBy = "user", cascade = CascadeType.ALL ESTE ALLPERMITE QUE SE HAGA
		 	LA TRANSITIVIDAD Y UEGO DESDE ADRESS SE GENERA EL KEY CON GenericGenerator HACIENDO REFERENCIA A USER
		 	AL ELIMINAR UN USUARIO NO PERMITE QUE SE ELIMINE POR LA ASOCIACION HACIA ADRESS PERO AL REVES SI PERMITE BORRAR 
		 	PARA ESTE CASO EL ID QUE GENERA USUARIO LO COMPARTE TAMBIEN ADDRESS, EN LA TABLA QUEDA MARCADO COMO FOREIN KEY
		 */


		User someUser = new User("johndoe");
		Address someAddress = new Address(someUser , "Some Street 123", "12345", "Some City");
		someUser.setShippingAddress(someAddress); // Link

		AbstractDAO.almacenaEntidad(someUser); // Transitive persistence of shippingAddress

		
		User someUser2 = new User("Lily");
		
		Address someAddress2 = new Address(someUser2 , "Bogota cartier colina", "123", "AC");
		someUser2.setShippingAddress(someAddress2); // Link

		AbstractDAO.almacenaEntidad(someUser2); // Transitive persistence of shippingAddress

	}

}
