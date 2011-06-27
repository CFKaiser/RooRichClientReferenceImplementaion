package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Address;

public class DeleteAddressEvent {

    private Address address;

    public DeleteAddressEvent(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
