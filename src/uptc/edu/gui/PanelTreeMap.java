package uptc.edu.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTreeMap extends JPanel {
	private JLabel jLabel;
	private JTable tableTreeMap;
	private DefaultTableModel modelTreeMap;
	public PanelTreeMap() {
		beginComponents();
		addComponents();
	}
	private void beginComponents() {
		jLabel= new JLabel("TreeMap");
		String []persons= new String[]{"Id","Nombre","Edad","Apellido" };
		modelTreeMap= new DefaultTableModel(persons, 2);
		tableTreeMap= new JTable(modelTreeMap){
			public boolean isCellEditable(int rowIndex,int vColIndex){
				return false;
			}
		};
		tableTreeMap.setPreferredScrollableViewportSize(new Dimension(400,
				320));
	}
	private void addComponents() {
		this.add(new JScrollPane(tableTreeMap));
	}
	public DefaultTableModel getModelTreeMap() {
		return modelTreeMap;
	}
	public void setModelTreeMap(DefaultTableModel modelTreeMap) {
		this.modelTreeMap = modelTreeMap;
	}
	public JTable getTableTreeMap() {
		return tableTreeMap;
	}
	public void setTableTreeMap(JTable tableTreeMap) {
		this.tableTreeMap = tableTreeMap;
	}
	

}
