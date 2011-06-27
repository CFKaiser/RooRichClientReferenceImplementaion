package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.Location;
import de.viadee.roo.sep.events.CreateLocationEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class CreateLocationListener implements ActionListener {

    private Location location;

    public CreateLocationListener(Location location) {
        this.location = location;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new CreateLocationEvent(location));
    }
}
