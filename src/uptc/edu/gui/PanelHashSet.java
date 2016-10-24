package uptc.edu.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelHashSet extends JPanel {
	private JTable tableHashSet ;
	private DefaultTableModel modelHashSet;
	public PanelHashSet() {
		beginComponents();
		addComponents();
	}
	private void beginComponents() {

		String []persons= new String[]{"Id","Nombre","Edad","Apellido" };
		modelHashSet= new DefaultTableModel(persons, 2);
		tableHashSet= new JTable(modelHashSet){
			public boolean isCellEditable(int rowIndex,int vColIndex){
				return false;
			}
		};
		tableHashSet.setPreferredScrollableViewportSize(new Dimension(400,
				320));
		
	}
	private void addComponents() {
		this.add(new JScrollPane(tableHashSet));

		
	}
	public DefaultTableModel getModelHashSet() {
		return modelHashSet;
	}
	public void setModelHashSet(DefaultTableModel modelHashSet) {
		this.modelHashSet = modelHashSet;
	}
	public JTable getTableHashSet() {
		return tableHashSet;
	}
	public void setTableHashSet(JTable tableHashSet) {
		this.tableHashSet = tableHashSet;
	}

}
