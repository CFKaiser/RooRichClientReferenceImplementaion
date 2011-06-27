package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Employee;

public class CreateEmployeeEvent {

    private Employee employee;

    public CreateEmployeeEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
