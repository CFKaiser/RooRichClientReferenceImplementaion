package de.viadee.roo.sep.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;
import de.viadee.roo.sep.domain.Location;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Size;
import de.viadee.roo.sep.domain.Employee;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class SocialEvent {

    @NotNull
    @ManyToOne
    private Location location;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date date;

    @NotNull
    @Size(max = 30)
    private String name;

    @Size(max = 140)
    private String description;

    @NotNull
    @ManyToOne
    private Employee creator;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Employee> subscribers = new HashSet<Employee>();

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Creator: ").append(getCreator()).append(", ");
        sb.append("Date: ").append(getDate()).append(", ");
        sb.append("Description: ").append(getDescription()).append(", ");
        sb.append("Location: ").append(getLocation()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Subscribers: ").append(getSubscribers() == null ? "null" : getSubscribers().size());
        return sb.toString();
    }

	public Location getLocation() {
        return this.location;
    }

	public void setLocation(Location location) {
        this.location = location;
    }

	public Date getDate() {
        return this.date;
    }

	public void setDate(Date date) {
        this.date = date;
    }

	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

	public Employee getCreator() {
        return this.creator;
    }

	public void setCreator(Employee creator) {
        this.creator = creator;
    }

	public Set<Employee> getSubscribers() {
        return this.subscribers;
    }

	public void setSubscribers(Set<Employee> subscribers) {
        this.subscribers = subscribers;
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
            SocialEvent attached = SocialEvent.findSocialEvent(this.id);
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
    public SocialEvent merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SocialEvent merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static final EntityManager entityManager() {
        EntityManager em = new SocialEvent().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countSocialEvents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SocialEvent o", Long.class).getSingleResult();
    }

	public static List<SocialEvent> findAllSocialEvents() {
        return entityManager().createQuery("SELECT o FROM SocialEvent o", SocialEvent.class).getResultList();
    }

	public static SocialEvent findSocialEvent(Long id) {
        if (id == null) return null;
        return entityManager().find(SocialEvent.class, id);
    }

	public static List<SocialEvent> findSocialEventEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SocialEvent o", SocialEvent.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
}
