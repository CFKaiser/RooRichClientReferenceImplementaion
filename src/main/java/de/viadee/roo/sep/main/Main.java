package de.viadee.roo.sep.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.bushe.swing.event.EventBus;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.bushe.swing.event.annotation.EventTopicSubscriber;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.domain.DecoratedAddress;
import de.viadee.roo.sep.events.AddressDataChangedEvent;
import de.viadee.roo.sep.listeners.CreateAddressListener;
import de.viadee.roo.sep.rooswingcomponents.RooButton;
import de.viadee.roo.sep.rooswingcomponents.RooAddressTable;
import de.viadee.roo.sep.rooswingcomponents.RooTextField;


public class Main {

    public static void main(String[] args) {
    	String[] contextPaths = new String[] { "META-INF/spring/applicationContext.xml" };
        new ClassPathXmlApplicationContext(contextPaths);
        
    	Address viadee = new Address();
        viadee.setStreet("Anton-Bruchhausen Straße");
        viadee.setHouseNumber("8");
        viadee.setZipCode("48147");
        viadee.setPlace("Münster");
        viadee.persist();
        
        EventBus.publish(new AddressDataChangedEvent());
    }
}
