package de.viadee.roo.sep.main;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.MenuEvent;

import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;

import de.viadee.roo.sep.events.AddressDataChangedEvent;
import de.viadee.roo.sep.events.CreateAddressEvent;
import de.viadee.roo.sep.events.ShowAddressDetailsViewEvent;
import de.viadee.roo.sep.rooswingcomponents.RooAddressTable;
import de.viadee.roo.sep.rooswingcomponents.RooFrame;
import de.viadee.roo.sep.rooswingcomponents.RooPanel;
import de.viadee.roo.sep.rooswingcomponents.RooTextField;

public class WindowManager {
	
	public WindowManager() {
		AnnotationProcessor.process(this);
	}

	private RooFrame mainFrame;
	private RooFrame detailsFrame;
	private RooPanel addressPanel;
	private RooPanel addressDetailPanel;
	
	public RooPanel getAddressDetailPanel() {
		return addressDetailPanel;
	}

	public void setAddressDetailPanel(RooPanel addressDetailPanel) {
		this.addressDetailPanel = addressDetailPanel;
	}

	public RooFrame getDetailsFrame() {
		return detailsFrame;
	}

	public void setDetailsFrame(RooFrame detailsFrame) {
		this.detailsFrame = detailsFrame;
	}

	public RooPanel getAddressPanel() {
		return addressPanel;
	}

	public void setAddressPanel(RooPanel addressPanel) {
		this.addressPanel = addressPanel;
	}

	public void setMainFrame(RooFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public RooFrame getMainFrame() {
		return mainFrame;
	}
	
	@EventSubscriber(eventClass = ShowAddressDetailsViewEvent.class)
	public void onShowAddressDetailsEvent(ShowAddressDetailsViewEvent event){
		showDetailsFrame(addressDetailPanel);
	}
	
	private void showDetailsFrame(RooPanel panel){
		detailsFrame.setContentPane(panel);
		detailsFrame.setVisible(true);
		detailsFrame.setBounds(400, 400, 400, 400);
		detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@EventSubscriber(eventClass = AddressDataChangedEvent.class)
	public void clearPanel(AddressDataChangedEvent addressDataChangedEvent){
		RooTextField streetField = (RooTextField) addressDetailPanel.getComponent(1);
		RooTextField houseNumberField = (RooTextField) addressDetailPanel.getComponent(3);
		RooTextField zipCodeField = (RooTextField) addressDetailPanel.getComponent(5);
		RooTextField placeField = (RooTextField) addressDetailPanel.getComponent(7);
		
		streetField.setText(null);
		houseNumberField.setText(null);
		zipCodeField.setText(null);
		placeField.setText(null);
	}
	
	@EventSubscriber(eventClass = MenuEvent.class)
    public void onMenuEvent(MenuEvent event) {
		String source = event.getSource().toString();
		System.out.println(source);
		if (source.equalsIgnoreCase("Exit")) {
			System.exit(0);
		} else if (source.equalsIgnoreCase("Addresses")) {
			mainFrame.setContentPane(addressPanel);
			mainFrame.pack();
			mainFrame.repaint();
		}
	}

}
