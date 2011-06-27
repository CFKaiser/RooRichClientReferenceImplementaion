package de.viadee.roo.sep.controller;

import java.util.List;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.domain.DecoratedAddress;
import de.viadee.roo.sep.events.AddressDataChangedEvent;
import de.viadee.roo.sep.events.CreateAddressEvent;
import de.viadee.roo.sep.events.DeleteAddressEvent;
import de.viadee.roo.sep.events.UpdateAddressEvent;
import de.viadee.roo.sep.rooswingcomponents.RooAddressTable;
import de.viadee.roo.sep.rooswingcomponents.RooTableModel;

import org.bushe.swing.event.EventBus;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.springframework.stereotype.Controller;

@Controller
public class AddressController {
	
    public AddressController() {
        AnnotationProcessor.process(this);
    }
    
    public void init(){
    	AnnotationProcessor.process(this);
    }

    @EventSubscriber(eventClass = CreateAddressEvent.class)
    public void create(CreateAddressEvent createAddressEvent) {
    	if(createAddressEvent.getAddress().getClass() == DecoratedAddress.class){
    		Address address = new Address();
    		Address decoratedAddress = createAddressEvent.getAddress();
    		address.setHouseNumber(decoratedAddress.getHouseNumber());
    		address.setPlace(decoratedAddress.getPlace());
    		address.setStreet(decoratedAddress.getStreet());
    		address.setZipCode(decoratedAddress.getZipCode());
    		address.persist();
    		EventBus.publish(new AddressDataChangedEvent());
    	}else createAddressEvent.getAddress().persist();
        
    }

    @EventSubscriber(eventClass = DeleteAddressEvent.class)
    public void delete(DeleteAddressEvent deleteAddressEvent) {
        deleteAddressEvent.getAddress().remove();
    }

    @EventSubscriber(eventClass = UpdateAddressEvent.class)
    public void update(UpdateAddressEvent updateAddressEvent) {
        updateAddressEvent.getAddress().merge();
    }
}
