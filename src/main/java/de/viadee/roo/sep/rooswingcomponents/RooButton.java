package de.viadee.roo.sep.rooswingcomponents;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class RooButton extends JButton {

    public RooButton(ActionListener listener) {
        this.addActionListener(listener);
    }
}
