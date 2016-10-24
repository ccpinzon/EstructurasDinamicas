package uptc.edu.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelLinkedList extends JPanel {
	
	private JLabel lb;
	private JTable tableLinkedList;
	private DefaultTableModel modelLinked;
	public PanelLinkedList() {
		beginComponents();
		addComponents();
		//setLayout(new BorderLayout());

		
	}

	private void beginComponents() {
		lb = new JLabel("linkedlist");
		String []persons= new String[]{"Id","Nombre","Edad","Apellido" };
		modelLinked= new DefaultTableModel(persons, 2);
		
		tableLinkedList= new JTable(modelLinked){
			public boolean isCellEditable(int rowIndex,int vColIndex){
				return false;
			}
		};
		tableLinkedList.setPreferredScrollableViewportSize(new Dimension(400,
				320));
		tableLinkedList.setFocusable(false);
		tableLinkedList.setRowSelectionAllowed(true);
		
	}
	private void addComponents() {
		
		//this.add(lb);
		this.add(new JScrollPane(tableLinkedList));
	}

	public DefaultTableModel getModelLinked() {
		return modelLinked;
	}

	public void setModelLinked(DefaultTableModel modelLinked) {
		this.modelLinked = modelLinked;
	}

	public JTable getTableLinkedList() {
		return tableLinkedList;
	}

	public void setTableLinkedList(JTable tableLinkedList) {
		this.tableLinkedList = tableLinkedList;
	}
	
}
