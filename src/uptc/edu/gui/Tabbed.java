package uptc.edu.gui;

import javax.swing.JTabbedPane;

public class Tabbed extends JTabbedPane {
	
	private PanelLinkedList panelLinkedList;
	private PanelHashMap panelHashMap;
	private PanelTreeMap panelTreeMap;
	private PanelHashSet panelHastSet;

	public Tabbed() {
		beginComponents();
		addComponents();
	}

	private void beginComponents() {
		panelLinkedList = new PanelLinkedList();
		panelHashMap= new PanelHashMap();
		panelTreeMap= new PanelTreeMap();
		panelHastSet= new PanelHashSet();
	}

	private void addComponents() {
		this.addTab("LinkedList", panelLinkedList);
		this.addTab("HashMap", panelHashMap);
		this.addTab("TreeMap", panelTreeMap);
		this.addTab("HashSet", panelHastSet);
	}

	public PanelLinkedList getPanelLinkedList() {
		return panelLinkedList;
	}

	public void setPanelLinkedList(PanelLinkedList panelLinkedList) {
		this.panelLinkedList = panelLinkedList;
	}

	public PanelHashMap getPanelHashMap() {
		return panelHashMap;
	}

	public void setPanelHashMap(PanelHashMap panelHashMap) {
		this.panelHashMap = panelHashMap;
	}

	public PanelTreeMap getPanelTreeMap() {
		return panelTreeMap;
	}

	public void setPanelTreeMap(PanelTreeMap panelTreeMap) {
		this.panelTreeMap = panelTreeMap;
	}

	public PanelHashSet getPanelHastSet() {
		return panelHastSet;
	}

	public void setPanelHastSet(PanelHashSet panelHastSet) {
		this.panelHastSet = panelHastSet;
	}
	

}
