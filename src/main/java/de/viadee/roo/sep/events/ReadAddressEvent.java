package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Address;

public class ReadAddressEvent {

    private Address address;

    public ReadAddressEvent(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
