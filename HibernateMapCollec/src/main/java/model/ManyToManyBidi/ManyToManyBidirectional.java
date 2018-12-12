package model.ManyToManyBidi;

import dao.AbstractDAO;

public class ManyToManyBidirectional {

	
		
	public static void main(String [] arg){
		init();
	}
	
	
	
	
	public static void init(){
		
		/*ESTE EJEMPLO ES DE MANY TO MANY PARA AMBAS ENTIDADES
		 * EXISTE SI BIEN SE GENERA UNA TABA INTERMEDIA ENTRE AMBAS ENTIDADES LLAMDA CATEGORY_ITEM
		 * 
		 *  
		 *  ITEM HAS A * CATEGORY -->   @ManyToMany(mappedBy = "items") //items es la variable en Category que es una ista
		 *  
		 *  CATEGORY HAS A * ITEMS -->  @ManyToMany(cascade = CascadeType.ALL)
									    @JoinTable(
									        name = "CATEGORY_ITEM",
									        joinColumns = @JoinColumn(name = "CATEGORY_ID"),
									        inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
									    )
		 *  
		 *  PARA QUE ESTO PUEDA OCURRIR SE DEFINE LO DE ARRIBA EL @JoinTable PERMITE LA CREACION DE LA TABLA INTERMEDIA
		 * * * * * * * * * * * * * 
		 *  PARA TENER EN CUENTA  * 
		 *  * * * * * * * * * * *
		 *  
		 *   SE PUEDE INDEXAR COLECCIONES COMO UN LIST CON @MANYTOMANY, PERO SOLO DE UN LADO, RECUERDE QUE EN UNA RELACION BIDIRECCIONAL
		 *   UN LADO TIENE QUE ESTAR "MAPPED BY" EL OTRO LADO, ES DECIR QUE EL OTRO ES IGNORADO CUANDO SINCRONIZA LA DATABASE
		 *   , SI AMBOS LADOS SON LISTAS SOLO SE PUEDE HACER PERSISTENCIA DE UN LADO.
		 *   
		 *    PARA ESTE CASO SI SE TRATA DE PERSISTIR ITEMS CON VARIAS CATEGORIAS, NO SE VERAN REFLEJADAS EN LA BD DADO QUE CATEGORY
		 *    ES QUIEN MAPEA A ITEMS POR ESO SE DEBE PERSISTIR ES CATEGORY
		 *    		AbstractDAO.almacenaEntidad(someItem1); -->>> ESTE NO FUNCIONARA PORQUE PERSISTE ES CATEGORY A ITEMS
		 *			AbstractDAO.almacenaEntidad(categoria1) -->>> ESTE SI FUNCIONARA PORQUE ES CATEGORY QUIEN PERSISTE ITEMS   
		 *  */
		
		
		Category categoria1 = new Category("Category 1");
		Category categoria2= new Category("Category 2");
		
		Item someItem1 = new Item("Some Item A");
		Item someItem2 = new Item("Some Item B");
		Item someItem3 = new Item("Some Item C");
		
		System.out.println("Hola");
		
		categoria1.getItems().add(someItem1);  // CATEGORY 1 PERSISTE 3 TIPOS DE ITEMS
		categoria1.getItems().add(someItem2);
		categoria1.getItems().add(someItem3);
		AbstractDAO.almacenaEntidad(categoria1);
        
		
		categoria2.getItems().add(someItem3); //CATEGORY 2 PERSISTE A ITEM3
		AbstractDAO.almacenaEntidad(categoria2);
        
	
		
	}
}
