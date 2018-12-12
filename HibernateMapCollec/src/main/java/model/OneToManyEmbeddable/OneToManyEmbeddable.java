package model.OneToManyEmbeddable;

import javax.persistence.AssociationOverride;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import dao.AbstractDAO;

public class OneToManyEmbeddable {



	/*ESTE METODO UTILIZA LA RELACION USER --> ADDRESS ---> SHIPMENTS
	 * 1. PARA REALIZAR EL MAPEO SE POSTULA QUE UN USUARIO TIENE UNA ADRESS
	 * 2. SIN EMBARGO ADRESS SE MAPEA COMO EMBEDABLE ES DECIR QUE NO SOPORTARA
	 *    EMBEDABLE SIGNIFICA QUE NO TIENE SU PROPIO IDENTIFICADOR ENTONCES ES EL USER QUIEN DA ESE IDENTIFICADOR
	 * 3. SHIPMENT NO TENDRA REFERENCIA HACIA ADRESS Y LA NAVEGATION BIDIRECCIONAL ES IMPORISBLE, PORQUE LOS COMPONENTES EMBEDABLES 
	 *     NO TIENEN REFERENCIAS COMPARTIDAS.
	 *     
	 *    SI LA ASOCIACION ES OPCIONAL Y NO SE DESEA NULL COLUM SEPUEDE MAPEAR SE PUEDE MAPEAR LA ASOCICION CON UN @JOINTABLE DESDE ADRESS
	 * 
	 * 4. USER ESTA COMO @ENTITY
	 * 5. ADDRESS ESTA COMO @EMBEDABLE, Y DESD ACA SE HACE LA RELACION ONETOMANY HACIA SHIPMENT
	 * 6. SHIPMENT ESTA COMO @ENTITY
	 * 7. AL INTENTAR CREAR USUARIO SIN ADRESS NO SE PUEDE, EL ESQUEMA NO LO ACEPTA DADO QUE ESTA EMBEBIDO Y NULLABLE=FALSE 	
	 * */


	public static void main(String [] arg){

		/* SEGUN LA STRATEGIA DE MAPEO SE DEBE SEGUIR UN ORDEN DE INSTANCIACION:
		 *  CASO 1: 
		 *  @JoinTable(
		 *       name = "DELIVERIES",//NOMBRE DE LA TABLA NUEVA CREADA CON IDS DE USER Y SHIPMENT
		 *       joinColumns = @JoinColumn(name = "USER_ID"), //FK DE USER
		 *       inverseJoinColumns = @JoinColumn(name = "SHIPMENT_ID") //FK DE SHIPMENT )
     	 *	CON ESTA ESTRATEGIA SE CREA UNA TABLA INTERMEDIA LLAMADA DELIVERIES QUE CONTIENE LOS IDS DE USER Y DE SHIPMENTS
     	 * LA CLASE USER MANTIENE EMBEBIDOS LOS DATOS DE ADRESS, ESTA BUENA PORQUE CREA LA TABLA INTERMEDIA QUE MANTIENE RELACION ENTRE USER
     	 * Y SHIPMENTS ASOCIADOS EN CADA ADRESS.
		 * PARA ESTE CASO SE CREAN 3 TABLAS USER, SHIPMENT Y DELIVERIES QUE ES LA QUE CONTIENE LOS IDS DE USER Y SHIPMENT TABLA ENLACE 
		 *  
		 *  
		 
		 *  CASO 2: 
		 *  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		 *	@JoinColumn(name="USER_ID") 
		 *  SE CREAEL USUARIO, LUEGO SE LE ADICIONAN LAS ADRESS, POSTERIORMENTE SE CREAN LOS SHIPMENT ASOCIADOS A LA ADRESS
		 *  LUEGO AL DECIRLE A HIBERNATE QUE LOS CREE DEBE PRIMERO ALMACENAR USUARIO Y LUEGO LA ADRESS QUE CONTIENE LOS SHIPMENTS
		 *  LA ADRESS ESTA EMBEBIDA EN LA TABLA USER ASI QE SE ALMACENA LOS SHIPMENTS
		 * 
		 * 
		 * 1 USUARIO -> 1 ADRESS
		 * 1 ADRESS -> MUCHOS SHIPMENTS
		 * 
		 * NOTA LA TECNICA DE MAPEO @OneToMany CON @JoinColumn NO ESTA MUY BUENA PORQUE LA CLASE 
		 * USUARIO TERMINA ADICIONANDO CAMPOS DE LA CLASE ADRESS Y LA ENTIDAD SHIPMENT ADICIONA UN CAMPO USER_ID QUE ES CON EL QUE PERMITE
		 * HACER JOINT A USER ALLI SE REGISTRAN LOS SHIPMENTS Q EL USUARIO POSEE EN SU UNICA DIRECCION
		 * PARA ESTE EJEMPLO SE GENERAN 2 TABLAS USER Y SHIPMENT
		 * 
		 * 
		 *  CASO 3:
		 *  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		 *	@AssociationOverride(name= "deliveries",joinColumns = @JoinColumn(name="SHIPMENT_ID")) 
			CON ESTA TECNICA IMPLEMENTADA EN LA CLASE ADRESS EN EL ATRIBUTO DELIVERIES, SE CREA UNA TABLA ADICIONAL LLAMADA
			USER_SHIPMENTS Q ES UNA TABLA INTERMEDIA CON LOS IDS DE SHIPMENTS QUE PERTENECEN A CADA USUARIO, EN TOTAL SON 3 TABLAS QUE SE CREAN
			USER, SHIPMENT Y USER_SHIPMENT, LA TABLA USER MANTIENE LOS DATOS DE ADRESS COMO EMBEDDES
			PARA ESTE EJEMPLO SE GENERAN 3 TABLAS USER, USER_SHIPMENT Y SHIPMENT
		 * 	 * */
		
		User user1 = new User("Mauricio"); //con 1 direccion
		Address adres1= new Address("Calle 24 ", "2714", "Manizales");// dir de fabio
		user1.setShippingAddress(adres1); //dir de fabio
		Shipment shipMauro1 = new Shipment();
		Shipment shipMauro2= new Shipment();
		adres1.getDeliveries().add(shipMauro1);
		adres1.getDeliveries().add(shipMauro2);
		
		AbstractDAO.almacenaEntidad(user1);
		AbstractDAO.almacenaEntidad(shipMauro1);
		AbstractDAO.almacenaEntidad(shipMauro2);
		
		/*OJO CON EL ORDEN DE CREAR LOS OBJETOS EN RELACIONES DE ONE A MUCHOS, ES ASI COMO SE DESCRIBE EN ESTE EJEMPLO*/
		
		User user2 = new User("FABIO"); //con 1 direccion
		Address adres5= new Address("ALMAGO", "269", "BAIRES"); //dir de matha
		user2.setShippingAddress(adres5); //dir de fabio
		Shipment shipFabio1 = new Shipment();
		Shipment shipFabio2= new Shipment();
		Shipment shipFabio3= new Shipment();
		adres5.getDeliveries().add(shipFabio1);
		adres5.getDeliveries().add(shipFabio2);
		adres5.getDeliveries().add(shipFabio3);
		
		
		AbstractDAO.almacenaEntidad(user2);
		AbstractDAO.almacenaEntidad(shipFabio1);
		AbstractDAO.almacenaEntidad(shipFabio1);
		AbstractDAO.almacenaEntidad(shipFabio3);
		
		
		User user3 = new User("MAMA"); //
		Address adres6= new Address("MANIZALES", "87999", "COLOMBIA"); //dir de matha
		user3.setShippingAddress(adres6); //dir de fabio
		AbstractDAO.almacenaEntidad(user3);
			
		
		
	
		
		




	}

}
