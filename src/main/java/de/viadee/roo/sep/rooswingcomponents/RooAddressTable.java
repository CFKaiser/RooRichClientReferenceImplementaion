package de.viadee.roo.sep.rooswingcomponents;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.apache.commons.beanutils.BeanUtils;
import org.bushe.swing.event.EventBus;
import org.bushe.swing.event.annotation.AnnotationProcessor;
import org.bushe.swing.event.annotation.EventSubscriber;
import org.jdesktop.swingx.JXTable;

import de.viadee.roo.sep.domain.Address;
import de.viadee.roo.sep.events.AddressDataChangedEvent;

public class RooAddressTable extends JXTable{
	
	Logger log = Logger.getLogger(getClass().getName());
	
	RooTableModel tableModel;
	java.lang.Object[][] tableData;
	java.lang.String[] columnNames;

    public RooAddressTable() {
    	AnnotationProcessor.process(this);
    	createTable();
    }


	private void createTable() {
		List<Address> entityList = getAllEntriesAsList();
        tableData = convertToObjectArray(entityList);
        columnNames = getColumnNames();
        
        tableModel = new RooTableModel(columnNames, tableData);
        this.setModel(tableModel);
	}


	private String[] getColumnNames() {
    	Class<Address> c = (Class<Address>) Address.class;
		Field[] allFields = c.getDeclaredFields();
		
		int countFields = 0;
		for (int i = 0; i < allFields.length; i++) {
			String fieldName = allFields[i].getName();
			if (!fieldName.startsWith("ajc$tjp") &&  !fieldName.equalsIgnoreCase("changeSupport") &&
					!fieldName.equalsIgnoreCase("version") && !fieldName.equalsIgnoreCase("id") && !fieldName.equalsIgnoreCase("entityManager")) {
				countFields++;
			}
		}
		Field[] fields = new Field[countFields];
		
		for (int i = 0; i < allFields.length; i++) {
			String fieldName = allFields[i].getName();
			if (!fieldName.startsWith("ajc$tjp") && !fieldName.equalsIgnoreCase("changeSupport") &&
					!fieldName.equalsIgnoreCase("version") && !fieldName.equalsIgnoreCase("id") && !fieldName.equalsIgnoreCase("entityManager")) {
				fields[i] = allFields[i];
			}
		}
		String[] fieldNames = new String[fields.length];
		
		for(int i = 0; i < fields.length; i++){
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	private Object[][] convertToObjectArray(List<Address> entityList) {
		Class<Address> c = (Class<Address>) Address.class;
		Field[] allFields = c.getDeclaredFields();
		
		int countFields = 0;
		for (int i = 0; i < allFields.length; i++) {
			String fieldName = allFields[i].getName();
			if (!fieldName.startsWith("ajc$tjp") &&  !fieldName.equalsIgnoreCase("changeSupport") &&
					!fieldName.equalsIgnoreCase("version") && !fieldName.equalsIgnoreCase("id") && !fieldName.equalsIgnoreCase("entityManager")) {
				countFields++;
			}
		}
		Field[] fields = new Field[countFields];
		
		for (int i = 0; i < allFields.length; i++) {
			String fieldName = allFields[i].getName();
			if (!fieldName.startsWith("ajc$tjp") &&  !fieldName.equalsIgnoreCase("changeSupport") &&
					!fieldName.equalsIgnoreCase("version") && !fieldName.equalsIgnoreCase("id") && !fieldName.equalsIgnoreCase("entityManager")) {
				fields[i] = allFields[i];
			}
		}
		Object[][] tableData = new Object[entityList.size()][fields.length];
		
		for(int i = 0; i < entityList.size(); i++){
			for (int j = 0; j < fields.length; j++) {
				try {
					tableData[i][j] = BeanUtils.getProperty(entityList.get(i), fields[j].getName());
				} catch (IllegalAccessException e) {
					log.log(Level.WARNING, e.getMessage());
				} catch (InvocationTargetException e) {
					log.log(Level.WARNING, e.getMessage());
				} catch (NoSuchMethodException e) {
					log.log(Level.WARNING, e.getMessage());
				}
			}
		}
		return tableData;
	}

	public List<Address> getAllEntriesAsList() {
		return Address.findAllAddresses();
    }
	
	@EventSubscriber(eventClass = AddressDataChangedEvent.class)
	public void tableModelChanged(AddressDataChangedEvent addressDataChangedEvent){
		this.tableData = convertToObjectArray(getAllEntriesAsList());
		
		this.columnNames = getColumnNames();
        
        this.tableModel = new RooTableModel(columnNames, tableData);
        this.setModel(tableModel);
		
		this.repaint();
	}
	

}
