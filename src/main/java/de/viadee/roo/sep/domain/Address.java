package de.viadee.roo.sep.domain;

import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Configurable
@RooJavaBean
@RooToString
@RooEntity
public class Address{
	
    @NotNull
    @Size(max = 30)
    private String street;

    @NotNull
    @Size(min = 1, max = 3)
    private String houseNumber;

    @NotNull
    @Size(min = 4, max = 5)
    private String zipCode;

    @NotNull
    @Size(max = 25)
    private String place;

	@PersistenceContext
    transient EntityManager entityManager;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Address attached = Address.findAddress(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public Address merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Address merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static final EntityManager entityManager() {
        EntityManager em = new Address().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countAddresses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Address o", Long.class).getSingleResult();
    }

	public static List<Address> findAllAddresses() {
        return entityManager().createQuery("SELECT o FROM Address o", Address.class).getResultList();
    }

	public static Address findAddress(Long id) {
        if (id == null) return null;
        return entityManager().find(Address.class, id);
    }

	public static List<Address> findAddressEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Address o", Address.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public String getStreet() {
        return this.street;
    }

	public void setStreet(String street) {
        this.street = street;
    }

	public String getHouseNumber() {
        return this.houseNumber;
    }

	public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

	public String getZipCode() {
        return this.zipCode;
    }

	public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

	public String getPlace() {
        return this.place;
    }

	public void setPlace(String place) {
        this.place = place;
    }

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HouseNumber: ").append(getHouseNumber()).append(", ");
        sb.append("Place: ").append(getPlace()).append(", ");
        sb.append("Street: ").append(getStreet()).append(", ");
        sb.append("ZipCode: ").append(getZipCode());
        return sb.toString();
    }
}
