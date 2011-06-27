package de.viadee.roo.sep.controller;

import de.viadee.roo.sep.events.CreateSocialEventEvent;
import de.viadee.roo.sep.events.DeleteSocialEventEvent;
import de.viadee.roo.sep.events.UpdateSocialEventEvent;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.springframework.stereotype.Controller;

@Controller
public class SocialEventController {

    public SocialEventController() {
        AnnotationProcessor.process(this);
    }

    @EventSubscriber(eventClass = CreateSocialEventEvent.class)
    public void create(CreateSocialEventEvent createSocialEventEvent) {
        createSocialEventEvent.getSocialEvent().persist();
    }

    @EventSubscriber(eventClass = DeleteSocialEventEvent.class)
    public void delete(DeleteSocialEventEvent deleteSocialEventEvent) {
        deleteSocialEventEvent.getSocialEvent().remove();
    }

    @EventSubscriber(eventClass = UpdateSocialEventEvent.class)
    public void update(UpdateSocialEventEvent updateSocialEventEvent) {
        updateSocialEventEvent.getSocialEvent().merge();
    }
}
