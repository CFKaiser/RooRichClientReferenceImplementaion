package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Employee;

public class UpdateEmployeeEvent {

    private Employee employee;

    public UpdateEmployeeEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
