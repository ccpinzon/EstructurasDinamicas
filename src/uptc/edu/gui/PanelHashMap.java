package uptc.edu.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelHashMap extends JPanel{
	private JTable tableHashMap;
	private DefaultTableModel modelHashMap;
	private JLabel jLabel;
	public PanelHashMap() {
		beginComponents();
		addComponents();
	}

	private void beginComponents() {
		jLabel= new JLabel("HashMap");
		String []persons= new String[]{"Id","Nombre","Edad","Apellido" };
		modelHashMap= new DefaultTableModel(persons, 2);
		tableHashMap= new JTable(modelHashMap){
			public boolean isCellEditable(int rowIndex,int vColIndex){
				return false;
			}
		};
		tableHashMap.setPreferredScrollableViewportSize(new Dimension(400,
				320));
	}
	private void addComponents() {
		this.add(new JScrollPane(tableHashMap));

		
	}

	public DefaultTableModel getModelHashMap() {
		return modelHashMap;
	}

	public void setModelHashMap(DefaultTableModel modelHashMap) {
		this.modelHashMap = modelHashMap;
	}

	public JTable getTableHashMap() {
		return tableHashMap;
	}

	public void setTableHashMap(JTable tableHashMap) {
		this.tableHashMap = tableHashMap;
	}
	
	
}
