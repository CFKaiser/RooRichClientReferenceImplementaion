package de.viadee.roo.sep.controller;

import de.viadee.roo.sep.events.CreateEmployeeEvent;
import de.viadee.roo.sep.events.DeleteEmployeeEvent;
import de.viadee.roo.sep.events.UpdateEmployeeEvent;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    public EmployeeController() {
        AnnotationProcessor.process(this);
    }

    @EventSubscriber(eventClass = CreateEmployeeEvent.class)
    public void create(CreateEmployeeEvent createEmployeeEvent) {
        createEmployeeEvent.getEmployee().persist();
    }

    @EventSubscriber(eventClass = DeleteEmployeeEvent.class)
    public void delete(DeleteEmployeeEvent deleteEmployeeEvent) {
        deleteEmployeeEvent.getEmployee().remove();
    }

    @EventSubscriber(eventClass = UpdateEmployeeEvent.class)
    public void update(UpdateEmployeeEvent updateEmployeeEvent) {
        updateEmployeeEvent.getEmployee().merge();
    }
}
