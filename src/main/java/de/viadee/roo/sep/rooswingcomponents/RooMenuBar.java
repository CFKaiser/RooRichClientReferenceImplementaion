package de.viadee.roo.sep.rooswingcomponents;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.JMenuBar;

public class RooMenuBar extends JMenuBar{
	
	private List<Component> myComponents;
	
	public void setMyComponents(List<Component> myComponents) {
        this.myComponents = myComponents;
    }

    public List<Component> getMyComponents() {
		return myComponents;
	}

	public void init() {

        for (Iterator<Component> iter = myComponents.iterator(); iter.hasNext(); ) {
        	Component component = iter.next();
            add(component);
        }
    }
}
