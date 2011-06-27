package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.Employee;
import de.viadee.roo.sep.events.CreateEmployeeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class CreateEmployeeListener implements ActionListener {

    private Employee employee;

    public CreateEmployeeListener(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new CreateEmployeeEvent(employee));
    }
}
