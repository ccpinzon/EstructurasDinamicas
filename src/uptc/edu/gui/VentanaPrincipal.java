package uptc.edu.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import uptc.edu.logic.Person;
import uptc.edu.logic.PersonHashMap;
import uptc.edu.logic.PersonHashSet;
import uptc.edu.logic.PersonLinkedList;
import uptc.edu.logic.PersonTreeMap;

public class VentanaPrincipal extends JFrame {
	private HaldingEvents haldingEvents;
	private JMenuBar menuBar;
	private JMenu add,delete;
	private JMenuItem agregar;
	private JButton btAdd;
	private JButton btDelete;
	private JPanel panelBotones;
	private Agregar vAgregar;
	private PersonLinkedList personLinkedList;
	private PersonHashMap personHashMap;
	private PersonTreeMap personTreeMap;
	private PersonHashSet personHashSet;

	private Tabbed tabbed;
	
	 public  VentanaPrincipal() {
		 haldingEvents = new HaldingEvents(this);
		 	setTitle("Estructuras Dinamicas");
	        setSize(500,500);
	        setLocation(200,150);
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());
		 beginComponets();
		 addComponents();
	    	 
	       
	        
	    }


		public HaldingEvents getHaldingEvents() {
		return haldingEvents;
	}


		private void beginComponets() {
	
			menuBar = new JMenuBar();
			vAgregar= new Agregar(this);
			tabbed= new Tabbed();
	        setJMenuBar(menuBar);
	        add = new JMenu("Agregar");
			agregar= new JMenuItem("Agregar Persona");
	        //add.setActionCommand(haldingEvents.VENTANA_AGREGAR);
	        //add.addActionListener(this.getHaldingEvents());
	        agregar.setActionCommand(haldingEvents.VENTANA_AGREGAR);
	        agregar.addActionListener(this.getHaldingEvents());
			delete= new JMenu("Eliminar");
			panelBotones= new JPanel();
			panelBotones.setLayout(new GridLayout(1, 2));
			btAdd= new JButton("Agregar");
			btAdd.setActionCommand(HaldingEvents.VENTANA_AGREGAR);
			btAdd.addActionListener(this.getHaldingEvents());
			btDelete= new JButton("Eliminar");
			btDelete.setActionCommand(HaldingEvents.ELIMINAR);
			btDelete.addActionListener(this.getHaldingEvents());
			
			
			personLinkedList= new PersonLinkedList();
			personHashMap= new PersonHashMap();
			personTreeMap= new PersonTreeMap();
			personHashSet= new PersonHashSet();
			
		}
		    
	private void addComponents() {
		 menuBar.add(add);
	        //menuBar.add(delete);
	        add.add(agregar);
	        this.add(tabbed,BorderLayout.CENTER);
	        
	        panelBotones.add(btAdd);
	        panelBotones.add(btDelete);
	        this.add(panelBotones, BorderLayout.SOUTH);
	        
	}


	public void ventanaAgregar() {
		vAgregar.setVisible(true);	
		vAgregar.getSpaceId().setText("");
		vAgregar.getSpaceName().setText("");
		vAgregar.getSpaceAge().setText("");
		vAgregar.getSpaceLastName().setText("");
		vAgregar.getGroupSelect().getSelection().setSelected(false);
	}

	//Metodos llenar tablas
	
	public void fullTableLinkedList(){
		for (int i = 0; i < personLinkedList.size(); i++) {
			String id = personLinkedList.get(i).getId();
			String name= personLinkedList.get(i).getName();
			int age= personLinkedList.get(i).getAge();
			String lastName=personLinkedList.get(i).getLastName();
			
			Object data[]={id,name,age,lastName};
			tabbed.getPanelLinkedList().getModelLinked().insertRow(i, data);
		}
	}
	public void fullTableHashMap(){
		int index = 0;
		for (String key: personHashMap.keySet()) {
			
			String id = personHashMap.get(key).getId();
			String name= personHashMap.get(key).getName();
			int age= personHashMap.get(key).getAge();
			String lastName= personHashMap.get(key).getLastName();
			
			Object data[] = {id,name,age,lastName};
			tabbed.getPanelHashMap().getModelHashMap().insertRow(index,data);
			
		index++;
		}
	}
	public void fullTreeMap(){
		int index = 0;
		for (String key: personTreeMap.keySet()) {
			
			String id = personTreeMap.get(key).getId();
			String name= personTreeMap.get(key).getName();
			int age= personTreeMap.get(key).getAge();
			String lastName= personTreeMap.get(key).getLastName();
			
			Object data[] = {id,name,age,lastName};
			tabbed.getPanelTreeMap().getModelTreeMap().insertRow(index,data);
			
		index++;
		}
		
	}
	public void fullHashSet(){
		
		//int index=0;
		for (Person per : personHashSet) {
			String id= per.getId();
			String name= per.getName();
			String lastName= per.getLastName();
			int age=per.getAge();
			Object data[]={id,name,age,lastName};
			
			tabbed.getPanelHastSet().getModelHashSet().addRow(data);
			//index++;
		}
	}
	
	//Refresh tables
	
//	public void refreshTableLinkList(){
//		while (tabbed.getPanelLinkedList().getModelLinked().getRowCount()!=0) {
//			tabbed.getPanelLinkedList().getModelLinked().removeRow(0);
//			
//		}
//	}
//	
//	public void refreshTableHashMap(){
//		while (tabbed.getPanelHashMap().getModelHashMap().getRowCount()!=0) {
//			tabbed.getPanelHashMap().getModelHashMap().removeRow(0);
//			
//		}	
//	}
//	public void refreshTableTreeMap(){
//		while (tabbed.getPanelTreeMap().getModelTreeMap().getRowCount()!=0) {
//			tabbed.getPanelTreeMap().getModelTreeMap().removeRow(0);
//			
//		}		
//	}
	
	public void refreshTables(DefaultTableModel model){
		while(model.getRowCount() !=0 ){
			model.removeRow(0);
		}
	}

	public void AddList() {
		//refreshTableLinkList();
		refreshTables(tabbed.getPanelLinkedList().getModelLinked());
		refreshTables(tabbed.getPanelHashMap().getModelHashMap());
		refreshTables(tabbed.getPanelTreeMap().getModelTreeMap());
		refreshTables(tabbed.getPanelHastSet().getModelHashSet());
		
		String id=vAgregar.getSpaceId().getText();
		String name= vAgregar.getSpaceName().getText();
		String lastName= vAgregar.getSpaceLastName().getText();
		int age= Integer.parseInt(vAgregar.getSpaceAge().getText());
		if(!(vAgregar.getSpaceAge().getText().equals("")|| vAgregar.getSpaceName().equals("")
				||vAgregar.getSpaceId().getText().equals("")||vAgregar.getSpaceLastName().getText().equals("")))
		{
			if(vAgregar.getBoxList().getSelectedIndex()==0){
				if(vAgregar.getFirst().isSelected()){
					personLinkedList.addFirst(new Person(id, name, age, lastName));
				}
				else if(vAgregar.getLast().isSelected()){
					personLinkedList.addLast(new Person(id, name, age, lastName));
				}
				else{
					personLinkedList.add(new Person(id, name, age, lastName));
				}
				fullTableLinkedList();
			}
			else if (vAgregar.getBoxList().getSelectedIndex()==1) {
				personHashMap.put(id, new Person(id, name, age, lastName));
				fullTableHashMap();
				
			}
			else if (vAgregar.getBoxList().getSelectedIndex()==2) {
				
				personTreeMap.put(id,new Person(id, name, age, lastName));
				fullTreeMap();
			}
			else if(vAgregar.getBoxList().getSelectedIndex()==3){
				personHashSet.add(new Person(id, name, age, lastName));
				fullHashSet();
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Error!! Verifique que todos los campos esten llenos");
		}
		
		
		
		
		
		
		
		
	}


	public void ValidateBox() {
		
		if (vAgregar.getBoxList().getSelectedIndex() == 0) {
			vAgregar.getFirst().setVisible(true);
			vAgregar.getLast().setVisible(true);
		
		
		}else{
			vAgregar.getFirst().setVisible(false);
			vAgregar.getLast().setVisible(false);
		}
		
	}


	public void Eliminar() {
		if(tabbed.getSelectedIndex()==0){	
			
			int pos=tabbed.getPanelLinkedList().getTableLinkedList().getSelectedRow();
			
			if (pos!=-1) {
				if (JOptionPane.showConfirmDialog(null,"Seguro desea eliminar el elemento? ") == 0) {
					personLinkedList.remove(pos);
					refreshTables(tabbed.getPanelLinkedList().getModelLinked());
					fullTableLinkedList();
				}else{
					System.out.println("No elimino");
					
				}
			}
			
			
		}
		else if (tabbed.getSelectedIndex()==1) {
			int pos= tabbed.getPanelHashMap().getTableHashMap().getSelectedRow();
			if(pos!=-1){
				if(JOptionPane.showConfirmDialog(null,"Seguro desea eliminar el elemento? ") == 0){
					String id = (String) tabbed.getPanelHashMap().getModelHashMap().getValueAt(pos, 0);
					personHashMap.remove(id);
					refreshTables(tabbed.getPanelHashMap().getModelHashMap());
					fullTableHashMap();
				}
			}
		}
		else if (tabbed.getSelectedIndex()==2){
			int pos=tabbed.getPanelTreeMap().getTableTreeMap().getSelectedRow();
			if(pos!=-1){
				if(JOptionPane.showConfirmDialog(null,"Seguro desea eliminar el elemento? ") == 0){
				String id = (String) tabbed.getPanelTreeMap().getModelTreeMap().getValueAt(pos, 0);
				personTreeMap.remove(id);
				refreshTables(tabbed.getPanelTreeMap().getModelTreeMap());
				fullTreeMap();
				}
			}
		}
		else if(tabbed.getSelectedIndex()==3){
			int pos= tabbed.getPanelHastSet().getTableHashSet().getSelectedRow();
			if(pos!=-1){
				if(JOptionPane.showConfirmDialog(null,"Seguro desea eliminar el elemento? ") == 0){
					String id = (String) tabbed.getPanelHastSet().getModelHashSet().getValueAt(pos, 0);
					String name = (String) tabbed.getPanelHastSet().getModelHashSet().getValueAt(pos, 1);
					int age =  (int) tabbed.getPanelHastSet().getModelHashSet().getValueAt(pos, 2);
					String lastname = (String) tabbed.getPanelHastSet().getModelHashSet().getValueAt(pos, 3);
					Person p = findHasSet(id, name, lastname, age);
					personHashSet.remove(p);
					refreshTables(tabbed.getPanelHastSet().getModelHashSet());
					fullHashSet();
				}
			}
			
		}
		
		
	}
	public Person findHasSet(String id,String name,String lastname,int age){
		
		for (Person person : personHashSet) {
			if (id.equals(person.getId())&&name.equals(person.getName())&&lastname.equals(person.getLastName())&&age ==person.getAge()) {
				return person;
			}
		}
		
		return null;
	}




}
