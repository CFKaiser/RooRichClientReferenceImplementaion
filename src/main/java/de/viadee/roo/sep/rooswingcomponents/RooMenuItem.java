package de.viadee.roo.sep.rooswingcomponents;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class RooMenuItem extends JMenuItem{
	
	public RooMenuItem(){
		
	}
	
	public RooMenuItem(ActionListener listener){
		addActionListener(listener);
	}
}