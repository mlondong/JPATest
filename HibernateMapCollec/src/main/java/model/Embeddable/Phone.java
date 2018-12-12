package model.Embeddable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;


/*SE USA EMBEDDED PARA ASOCIAR UNA COLECCION A LA CLASE PERSON DE PHONES */
@Embeddable
public class Phone {

	private int numero;

	public Phone(){}

	public Phone(int n){
		this.numero=n;
	}

	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
