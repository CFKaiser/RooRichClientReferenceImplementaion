package de.viadee.roo.sep.rooswingcomponents;

import javax.swing.JTextField;

import com.jgoodies.binding.beans.BeanAdapter;

public class RooTextField extends JTextField {

    public RooTextField(Object entity, String propertyName) {
        com.jgoodies.binding.beans.BeanAdapter<Object> myBeanAdapter = new BeanAdapter<Object>((Object) entity, true);
        com.jgoodies.binding.value.ValueModel valueModel = myBeanAdapter.getValueModel(propertyName);
        com.jgoodies.binding.adapter.Bindings.bind(this, valueModel);
    }
}
