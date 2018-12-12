package model.Embeddable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import dao.AbstractDAO;
import model.Embeddable.Person;
import model.Embeddable.Phone;
import model.Embeddable2.ContactAddress;
import model.Embeddable2.User;
import model.Embeddable2.UserType;

public class Test {


	public static void main(String [] arg){

		//pruebaEmbedded();
		pruebaEntity();

	}	



	public static void 	pruebaEntity(){
		User user = new User();
		user.setUserName("mike");
		user.setPassword("password");
		user.setCreationTime(new Date());
		user.setUserType(UserType.EMPLOYEE);
		
		//Creating contacts List
		List<String> contactList = new ArrayList<String>();
		contactList.add("(817) 569-8221");
		contactList.add("(817) 569-8281");
		
		//Setting contacts to User
		user.setContacts(contactList);
		
		

		//Setting Contact Address1
    	ContactAddress address = new ContactAddress();
		address.setStreetAddress("Clock Tower, Mahbub College Campus");
		address.setCity("Secunderabad");
		address.setState("Andhrapradesh");
		address.setAreaCode("500003");
		address.setAddressType("Permanent");
		
		//Setting Contact Address2
		ContactAddress currentAddress = new ContactAddress();
		currentAddress.setStreetAddress("FN 501, Vamseekuteer");
		currentAddress.setCity("Secunderabad");
		currentAddress.setState("Andhrapradesh");
		currentAddress.setAreaCode("500003");
		currentAddress.setAddressType("Current");
		
		List<ContactAddress> adr = new  ArrayList<>();
		adr.add(address);
		adr.add(currentAddress);
		
		//setting address list
		user.setAddress(adr);
		
		AbstractDAO.almacenaEntidad(user);
		
		
		
	}




	public static void pruebaEmbedded(){ 
		Person mauri = new Person("Mauricio", "London");
		List <Phone> listaphones = new ArrayList<Phone>();
		listaphones.add(new Phone(9999));
		//listaphones.add(new Phone(22222));

		mauri.setPhones(listaphones);



		//Person lore = new Person("Lorena", "London");
		//List <Phone> p2 = new ArrayList<Phone>();
		/*p2.add(new Phone(1111));
		p2.add(new Phone(333));
		p2.add(new Phone(3333));
		p2.add(new Phone(84313));

		lore.setPhones(p2);


		Person fabio = new Person("FAbio", "London");

		 */
		AbstractDAO.almacenaEntidad(mauri);
		//AbstractDAO.almacenaEntidad(lore);
		//AbstractDAO.almacenaEntidad(fabio);




	}

}
