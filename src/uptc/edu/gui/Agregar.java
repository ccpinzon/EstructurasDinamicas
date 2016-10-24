package uptc.edu.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class Agregar extends JDialog {
	private JLabel id,name,lastName,age;
	private JTextField spaceId,spaceName,spaceLastName,spaceAge;
	private ButtonGroup GroupSelect;
	private JButton aceptar,cancel;
	private JRadioButton first,last,agregar;
	private VentanaPrincipal ventanaPrincipal;
	private JComboBox boxList;
	private JPanel pnLinked;
	public Agregar(VentanaPrincipal ventanaPrincipal){
		this.ventanaPrincipal= ventanaPrincipal;
		setTitle("Agregar Persona");
		setSize(300, 350);
		setLocation(200,200);
		//setResizable(false);
		//setLayout(new FlowLayout());
		//getContentPane().setLayout(new GridLayout(2, 1));
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		beginComponents();	
		addComponents();
		pack();
	}
	private void beginComponents() {
		pnLinked = new JPanel();
		pnLinked.setLayout(new GridLayout(6, 2));
		
		boxList= new JComboBox();
		//String data [] ={"LinkedList","Hashmap"};
		boxList.addItem("LinkedList");
		boxList.addItem("Hasmap");
		boxList.addItem("TreeMap");
		boxList.addItem("HashSet");
		boxList.setActionCommand(HaldingEvents.VALIDATE_BOX);
		boxList.addActionListener(ventanaPrincipal.getHaldingEvents());
		id=new JLabel("Id");
	    name = new JLabel("Nombre");
		lastName=new JLabel("Apellido");
		age=new JLabel("Edad");
		spaceId= new JTextField(10);
		spaceName= new JTextField(10);
		spaceLastName= new JTextField(10);
		spaceAge= new JTextField(10);
		SNumeros(spaceAge);
		GroupSelect= new ButtonGroup();
		first= new JRadioButton("Al inicio");
		last= new JRadioButton("Al final");
		agregar= new JRadioButton("Agregar");
		aceptar= new JButton("Agregar");
		aceptar.setActionCommand(HaldingEvents.ADD);
		aceptar.addActionListener(ventanaPrincipal.getHaldingEvents());
		cancel= new JButton("Cancelar");
	}
	private void addComponents(){
		this.add(boxList,BorderLayout.NORTH);
		pnLinked.add(id);
		pnLinked.add(spaceId);
		pnLinked.add(name);
		pnLinked.add(spaceName);
		pnLinked.add(lastName);
		pnLinked.add(spaceLastName);
		pnLinked.add(age);
		pnLinked.add(spaceAge);
		GroupSelect.add(first);
		GroupSelect.add(last);
		GroupSelect.add(agregar);
		pnLinked.add(first);
		pnLinked.add(last);
		//pnLinked.add(agregar);
		pnLinked.add(aceptar);
		pnLinked.add(cancel);
		this.add(pnLinked,BorderLayout.CENTER);
				
	}
	
	public void SNumeros(JTextField a) {
		a.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}

			}
		});

	}
	public JTextField getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(JTextField spaceId) {
		this.spaceId = spaceId;
	}
	public JTextField getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(JTextField spaceName) {
		this.spaceName = spaceName;
	}
	public JTextField getSpaceLastName() {
		return spaceLastName;
	}
	public void setSpaceLastName(JTextField spaceLastName) {
		this.spaceLastName = spaceLastName;
	}
	public JTextField getSpaceAge() {
		return spaceAge;
	}
	public void setSpaceAge(JTextField spaceAge) {
		this.spaceAge = spaceAge;
	}
	public ButtonGroup getGroupSelect() {
		return GroupSelect;
	}
	public void setGroupSelect(ButtonGroup GroupSelect) {
		this.GroupSelect = GroupSelect;
	}
	public JRadioButton getFirst() {
		return first;
	}
	public void setFirst(JRadioButton first) {
		this.first = first;
	}
	public JRadioButton getLast() {
		return last;
	}
	public void setLast(JRadioButton last) {
		this.last = last;
	}
	public JComboBox getBoxList() {
		return boxList;
	}
	public void setBoxList(JComboBox boxList) {
		this.boxList = boxList;
	}
	
	
	
}
