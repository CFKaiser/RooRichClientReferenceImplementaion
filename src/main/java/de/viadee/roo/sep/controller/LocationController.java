package de.viadee.roo.sep.controller;

import de.viadee.roo.sep.events.CreateLocationEvent;
import de.viadee.roo.sep.events.DeleteLocationEvent;
import de.viadee.roo.sep.events.UpdateLocationEvent;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.springframework.stereotype.Controller;

@Controller
public class LocationController {

    public LocationController() {
        AnnotationProcessor.process(this);
    }

    @EventSubscriber(eventClass = CreateLocationEvent.class)
    public void create(CreateLocationEvent createLocationEvent) {
        createLocationEvent.getLocation().persist();
    }

    @EventSubscriber(eventClass = DeleteLocationEvent.class)
    public void delete(DeleteLocationEvent deleteLocationEvent) {
        deleteLocationEvent.getLocation().remove();
    }

    @EventSubscriber(eventClass = UpdateLocationEvent.class)
    public void update(UpdateLocationEvent updateLocationEvent) {
        updateLocationEvent.getLocation().merge();
    }
}
