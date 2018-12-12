package model.Embeddable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

/*PARA ESTE CASO LA CASE PRINCIPAL PERSONA ESTA COMPUESTA POR MUCHOS TELEFONOS PHONES QUE SON GENERADOS AUTOMATICAMENTE
 * POR HIBERNATE EN UN LIST EL ANNOTATION 	@ElementCollection
	@OrderColumn(name="order_id") HACEN QUE ESTO SEA POSIBLE Y PONE UN ORDEN AL INGRESO DE ESTO PHONES*/

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	@ElementCollection
	@OrderColumn(name="order_id")
	private List<Phone> phones;
	
	public Person(){}
	
	public Person(String name, String lastName){
		this.name=name;
		this.lastName=lastName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	
	
	
}
