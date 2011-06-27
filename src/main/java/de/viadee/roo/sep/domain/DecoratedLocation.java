package de.viadee.roo.sep.domain;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class DecoratedLocation extends Location {

    private ExtendedPropertyChangeSupport changeSupport = new ExtendedPropertyChangeSupport(this);

    @Override
    public void setLocationName(String locationName) {
        String oldValue = super.getLocationName();
        super.setLocationName(locationName);
        changeSupport.firePropertyChange("locationName", oldValue, locationName);
    }

    @Override
    public void setAddress(Address address) {
        Address oldValue = super.getAddress();
        super.setAddress(address);
        changeSupport.firePropertyChange("address", oldValue, address);
    }

    public void addPropertyChangeListener(PropertyChangeListener x) {
        changeSupport.addPropertyChangeListener(x);
    }

    public void removePropertyChangeListener(PropertyChangeListener x) {
        changeSupport.removePropertyChangeListener(x);
    }
}
