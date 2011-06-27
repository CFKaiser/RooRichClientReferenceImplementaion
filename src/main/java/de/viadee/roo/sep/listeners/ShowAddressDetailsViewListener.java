package de.viadee.roo.sep.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.bushe.swing.event.EventBus;

import de.viadee.roo.sep.events.ShowAddressDetailsViewEvent;

public class ShowAddressDetailsViewListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		EventBus.publish(new ShowAddressDetailsViewEvent());
		
	}

}
