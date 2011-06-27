package de.viadee.roo.sep.listeners;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.events.CreateAddressEvent;
import de.viadee.roo.sep.rooswingcomponents.RooAddressTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.bushe.swing.event.EventBus;

public class CreateAddressListener implements ActionListener {

    private Address address;
    private RooAddressTable addressTable;

    public CreateAddressListener(Address address, RooAddressTable addressTable) {
        this.address = address;
        this.addressTable = addressTable;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new CreateAddressEvent(address, addressTable));
    }
}
