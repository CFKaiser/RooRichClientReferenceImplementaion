package de.viadee.roo.sep.domain;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import java.beans.PropertyChangeListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DecoratedAddress extends Address {
	
    private ExtendedPropertyChangeSupport changeSupport = new ExtendedPropertyChangeSupport(this);

    @Override
    public void setStreet(String street) {
    	System.out.println(street);
        String oldValue = super.getStreet();
        super.setStreet(street);
        changeSupport.firePropertyChange("street", oldValue, street);
    }

    @Override
    public void setHouseNumber(String houseNumber) {
        String oldValue = super.getHouseNumber();
        super.setHouseNumber(houseNumber);
        changeSupport.firePropertyChange("houseNumber", oldValue, houseNumber);
    }

    @Override
    public void setZipCode(String zipCode) {
        String oldValue = super.getZipCode();
        super.setZipCode(zipCode);
        changeSupport.firePropertyChange("zipCode", oldValue, zipCode);
    }

    @Override
    public void setPlace(String place) {
        String oldValue = super.getPlace();
        super.setPlace(place);
        changeSupport.firePropertyChange("place", oldValue, place);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener x) {
        changeSupport.addPropertyChangeListener(x);
    }

    public void removePropertyChangeListener(PropertyChangeListener x) {
        changeSupport.removePropertyChangeListener(x);
    }
}
