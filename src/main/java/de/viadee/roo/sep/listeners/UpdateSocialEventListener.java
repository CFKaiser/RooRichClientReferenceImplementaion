package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.SocialEvent;
import de.viadee.roo.sep.events.UpdateSocialEventEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class UpdateSocialEventListener implements ActionListener {

    private SocialEvent socialEvent;

    public UpdateSocialEventListener(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new UpdateSocialEventEvent(socialEvent));
    }
}
