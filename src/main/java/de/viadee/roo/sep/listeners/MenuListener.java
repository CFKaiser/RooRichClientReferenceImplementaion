package de.viadee.roo.sep.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.MenuEvent;
import org.bushe.swing.event.EventBus;

public class MenuListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        EventBus.publish(new MenuEvent(e.getActionCommand()));
    }
}
