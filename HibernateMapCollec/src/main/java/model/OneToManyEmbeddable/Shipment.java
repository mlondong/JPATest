package model.OneToManyEmbeddable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="SHIPMENT_ID")
    protected Long id;

    @Column(name="CREATION_DATE")
    protected Date createdOn = new Date();

   
    public Shipment() {
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}