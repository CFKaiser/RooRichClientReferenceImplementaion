package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Employee;

public class DeleteEmployeeEvent {

    private Employee employee;

    public DeleteEmployeeEvent(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
