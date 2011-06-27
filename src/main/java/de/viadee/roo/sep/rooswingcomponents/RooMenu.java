package de.viadee.roo.sep.rooswingcomponents;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.JMenu;

public class RooMenu extends JMenu{
	
private List<Component> myComponents;
	
	public void setMyComponents(List<Component> myComponents) {
        this.myComponents = myComponents;
    }

    public void init() {

        for (Iterator<Component> iter = myComponents.iterator();
             iter.hasNext();) {
        	Component component = iter.next();
            add(component);
        }
    }

	public List<Component> getMyComponents() {
		return myComponents;
	}

}
