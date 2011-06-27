package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.SocialEvent;
import de.viadee.roo.sep.events.DeleteSocialEventEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class DeleteSocialEventListener implements ActionListener {

    private SocialEvent socialEvent;

    public DeleteSocialEventListener(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new DeleteSocialEventEvent(socialEvent));
    }
}
