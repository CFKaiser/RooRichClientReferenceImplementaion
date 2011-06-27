package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.SocialEvent;
import de.viadee.roo.sep.events.ReadSocialEventEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class ReadSocialEventListener implements ActionListener {

    private SocialEvent socialEvent;

    public ReadSocialEventListener(SocialEvent socialEvent) {
        this.socialEvent = socialEvent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new ReadSocialEventEvent(socialEvent));
    }
}
