package model.OneToManyEmbeddable;


import javax.persistence.AssociationOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class Address {


	/*ESTA ES UNA CLASE EMBEDABLE, POR CONSIGUIENTE SEGN LA ESTRATEGIA LO QUE SE GENERE ACA SERA REPLICADO EN LA CLASE USER
	 * QUIN ES LA QUE LA CONTIENE
	 * 
	 * Embeddable objects (or components) are objects whose properties are mapped to the same table as the 
	 * owning entity's table. Components can, in turn, declare their own properties, components or collections

		It is possible to declare an embedded component inside an entity and even override its column mapping. Component 
		classes have to be annotated at the class level with the @Embeddable annotation. It is possible to override the column 
		mapping of an embedded object for a particular entity using the @Embedded and @AttributeOverride annotation in the associated property:
	 * */



	@Column(nullable = false,name="STREET")
	protected String street;

	@Column(nullable = false, length = 5, name="ZIPCODE")
	protected String zipcode;

	@Column(nullable = false, name="CITY")
	protected String city;


	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(
			name = "DELIVERIES",//NOMBRE DE LA TABLA NUEVA CREADA CON IDS DE USER Y SHIPMENT
			joinColumns = @JoinColumn(name = "USER_ID"), //FK DE USER
			inverseJoinColumns = @JoinColumn(name = "SHIPMENT_ID")) //FK DE SHIPMENT )
	protected Set<Shipment> deliveries = new HashSet<Shipment>();

			/* ESTRATEGIAS QUE FUNCIONARON DESDE UNA CLASE @EMBEDDABLE, SOLO ESCOPIAR Y PEGAR SOBRE Set<Shipment> deliveries
			 *  
			 *  CASO 1;
			 *  CON ESTA TECNICA @JoinTable SE GENERA UNA TABLA ADICIONAL "DELIVERIES" DE ENLACE QUE MANTIENE LOS IDS DE USER Y DE SHIPMENT
			 *  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
			 *  @JoinTable(
			 *       name = "DELIVERIES",//NOMBRE DE LA TABLA NUEVA CREADA CON IDS DE USER Y SHIPMENT
			 *       joinColumns = @JoinColumn(name = "USER_ID"), //FK DE USER
			 *       inverseJoinColumns = @JoinColumn(name = "SHIPMENT_ID") //FK DE SHIPMENT )

        CASO 2;  
			 *	CON ESTA TECNICA @JoinColumn SE CREA UN CAMPO ADICIONAL EN LA TABLA DE LA TABLA SHIPMENT LLAMADO "USER_ID"
			 *	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
			 *  @JoinColumn(name="USER_ID") // FUNCIONA OK, CREA EL USER_ID EN LA TABLA DE SHIPMENT

		CASO 3;
			 *  CON ESTA TECNICA @AssociationOverride
			 *  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
			 *  @AssociationOverride(name= "deliveries",joinColumns = @JoinColumn(name="SHIPMENT_ID")) // 
			 * 
			 * 	 *   */ 




			protected Address() {
			}

			public Address(String street, String zipcode, String city) {
				this.street = street;
				this.zipcode = zipcode;
				this.city = city;
			}

			public String getStreet() {
				return street;
			}

			public void setStreet(String street) {
				this.street = street;
			}

			public String getZipcode() {
				return zipcode;
			}

			public void setZipcode(String zipcode) {
				this.zipcode = zipcode;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public Set<Shipment> getDeliveries() {
				return deliveries;
			}

			public void setDeliveries(Set<Shipment> deliveries) {
				this.deliveries = deliveries;
			}
}
