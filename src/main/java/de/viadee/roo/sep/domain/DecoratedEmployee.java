package de.viadee.roo.sep.domain;

import com.jgoodies.binding.beans.ExtendedPropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class DecoratedEmployee extends Employee {

    private ExtendedPropertyChangeSupport changeSupport = new ExtendedPropertyChangeSupport(this);

    @Override
    public void setFirstName(String firstName) {
        String oldValue = super.getFirstName();
        super.setFirstName(firstName);
        changeSupport.firePropertyChange("firstName", oldValue, firstName);
    }

    @Override
    public void setLastName(String lastName) {
        String oldValue = super.getLastName();
        super.setLastName(lastName);
        changeSupport.firePropertyChange("lastName", oldValue, lastName);
    }

    @Override
    public void setEmployeeShortCut(String employeeShortCut) {
        String oldValue = super.getEmployeeShortCut();
        super.setEmployeeShortCut(employeeShortCut);
        changeSupport.firePropertyChange("employeeShortCut", oldValue, employeeShortCut);
    }

    @Override
    public void setEmail(String email) {
        String oldValue = super.getEmail();
        super.setEmail(email);
        changeSupport.firePropertyChange("email", oldValue, email);
    }

    public void addPropertyChangeListener(PropertyChangeListener x) {
        changeSupport.addPropertyChangeListener(x);
    }

    public void removePropertyChangeListener(PropertyChangeListener x) {
        changeSupport.removePropertyChangeListener(x);
    }
}
