package model.OneToOneSharedPrimaryKey;

import dao.AbstractDAO;

public class OneToOneSharedPrimaryKey {

	public static void main(String[] arg){
		/*para la ejecucion de est ejemplo one to one se requiere primero generar la addressy luego mapearla para despues
		 * generar el user con la adress
		 * 
		 * EL MAPEO NO ES TRANSITIVO HAY QUE MAPEAR PRIMERO EL ADRESS Y LUEGO EL USER*/
		
		
        Address someAddress = new Address("Some Street 123", "12345", "Some City");
        AbstractDAO.almacenaEntidad(someAddress);
        
           
        User someUser = new User(new Long(someAddress.getId()),"johndoe");
        AbstractDAO.almacenaEntidad(someUser);
    	    
	}
	
}
