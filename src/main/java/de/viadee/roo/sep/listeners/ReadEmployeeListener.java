package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.Employee;
import de.viadee.roo.sep.events.ReadEmployeeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class ReadEmployeeListener implements ActionListener {

    private Employee employee;

    public ReadEmployeeListener(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new ReadEmployeeEvent(employee));
    }
}
