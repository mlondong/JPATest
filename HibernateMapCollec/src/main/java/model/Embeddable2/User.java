package model.Embeddable2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;


import org.hibernate.annotations.CollectionId;

/*EN ESTE EJEMPLO SE USAN DOS OBJETOS DE COLECCIONES QUE HASSET QUE LUEGO SON MAPEADAS
 * */


@Entity
public class User  {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="CREATED_TIME")
	private Date creationTime;
	
	
	@ElementCollection
	@CollectionTable(name="CONTACT_ADDRESS", joinColumns= @JoinColumn(name="USER_ID"))
	@AttributeOverride(name="streetAddress", column = @Column(name="STREET_ADDRESS"))
	private List<ContactAddress> address;
	
	@ElementCollection
	@CollectionTable(name="Contacts", joinColumns=@JoinColumn(name="ID"))
	@Column(name="CONTACT_NO")
	private Collection<String> contacts;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="USER_TYPE")
	private UserType userType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public List<ContactAddress> getAddress() {
		return address;
	}

	public void setAddress(List<ContactAddress> address) {
		this.address = address;
	}

	public Collection<String> getContacts() {
		return contacts;
	}

	public void setContacts(Collection<String> contacts) {
		this.contacts = contacts;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	
}
