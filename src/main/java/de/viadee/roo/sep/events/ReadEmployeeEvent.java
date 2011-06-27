package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Employee;

public class ReadEmployeeEvent {

    private Employee employee;

    public ReadEmployeeEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
