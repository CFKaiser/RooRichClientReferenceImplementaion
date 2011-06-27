package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.events.DeleteAddressEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class DeleteAddressListener implements ActionListener {

    private Address address;

    public DeleteAddressListener(Address address) {
        this.address = address;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new DeleteAddressEvent(address));
    }
}
