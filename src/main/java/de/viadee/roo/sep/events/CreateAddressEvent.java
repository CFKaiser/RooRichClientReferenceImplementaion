package de.viadee.roo.sep.events;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.rooswingcomponents.RooAddressTable;

public class CreateAddressEvent {

	private RooAddressTable addressTable;
    private Address address;

    public CreateAddressEvent(Address address, RooAddressTable addressTable) {
        this.address = address;
        this.addressTable = addressTable;
    }

    public Address getAddress() {
        return address;
    }
    
    public RooAddressTable getAddressTable() {
		return addressTable;
	}
}
