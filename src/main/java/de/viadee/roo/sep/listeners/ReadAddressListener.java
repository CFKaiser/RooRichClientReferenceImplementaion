package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.events.ReadAddressEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class ReadAddressListener implements ActionListener {

    private Address address;

    public ReadAddressListener(Address address) {
        this.address = address;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new ReadAddressEvent(address));
    }
}
