package de.viadee.roo.sep.domain;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import de.viadee.roo.sep.domain.Address;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Location {

    @NotNull
    @Size(max = 30)
    private String locationName;

    @NotNull
    @ManyToOne
    private Address address;

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address: ").append(getAddress()).append(", ");
        sb.append("LocationName: ").append(getLocationName());
        return sb.toString();
    }

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
            Location attached = Location.findLocation(this.id);
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
    public Location merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Location merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static final EntityManager entityManager() {
        EntityManager em = new Location().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countLocations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Location o", Long.class).getSingleResult();
    }

	public static List<Location> findAllLocations() {
        return entityManager().createQuery("SELECT o FROM Location o", Location.class).getResultList();
    }

	public static Location findLocation(Long id) {
        if (id == null) return null;
        return entityManager().find(Location.class, id);
    }

	public static List<Location> findLocationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Location o", Location.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public String getLocationName() {
        return this.locationName;
    }

	public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

	public Address getAddress() {
        return this.address;
    }

	public void setAddress(Address address) {
        this.address = address;
    }
}
