package de.viadee.roo.sep.rooswingcomponents;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class RooPanel extends JPanel{

    private List<Component> panelComponents;
    
    public void setPanelComponents(List<Component> panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void init() {
    	
        for (Iterator<Component> iter = panelComponents.iterator();
             iter.hasNext();) {
            Component component = iter.next();
            add(component);
        }
    }

	public List<Component> getPanelComponents() {
		return panelComponents;
	}
}
