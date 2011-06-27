package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Address;

public class UpdateAddressEvent {

    private Address address;

    public UpdateAddressEvent(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
