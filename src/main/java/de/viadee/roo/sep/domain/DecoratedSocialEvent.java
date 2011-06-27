package de.viadee.roo.sep.domain;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Set;

public class DecoratedSocialEvent extends SocialEvent {

    private ExtendedPropertyChangeSupport changeSupport = new ExtendedPropertyChangeSupport(this);

    @Override
    public void setLocation(Location location) {
        Location oldValue = super.getLocation();
        super.setLocation(location);
        changeSupport.firePropertyChange("location", oldValue, location);
    }

    @Override
    public void setDate(Date date) {
        Date oldValue = super.getDate();
        super.setDate(date);
        changeSupport.firePropertyChange("date", oldValue, date);
    }

    @Override
    public void setName(String name) {
        String oldValue = super.getName();
        super.setName(name);
        changeSupport.firePropertyChange("name", oldValue, name);
    }

    @Override
    public void setDescription(String description) {
        String oldValue = super.getDescription();
        super.setDescription(description);
        changeSupport.firePropertyChange("description", oldValue, description);
    }

    @Override
    public void setCreator(Employee creator) {
        Employee oldValue = super.getCreator();
        super.setCreator(creator);
        changeSupport.firePropertyChange("creator", oldValue, creator);
    }

    @Override
    public void setSubscribers(Set<Employee> subscribers) {
        Set oldValue = super.getSubscribers();
        super.setSubscribers(subscribers);
        changeSupport.firePropertyChange("subscribers", oldValue, subscribers);
    }

    public void addPropertyChangeListener(PropertyChangeListener x) {
        changeSupport.addPropertyChangeListener(x);
    }

    public void removePropertyChangeListener(PropertyChangeListener x) {
        changeSupport.removePropertyChangeListener(x);
    }
}
