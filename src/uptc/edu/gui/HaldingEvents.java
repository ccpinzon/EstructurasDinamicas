package uptc.edu.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HaldingEvents implements ActionListener{
	private VentanaPrincipal VentanaPrincipal;
	
	
	public static final String VENTANA_AGREGAR= "Hace visible la ventana agregar";
	public static final String ADD="Agrega a las listas correspondientes";
	public static final String VALIDATE_BOX="valida la opcion seleccionada de agregar lista";
	public static final String ELIMINAR="Elimina de la lista";
	public HaldingEvents(VentanaPrincipal ventanaPrincipal) {
		this.VentanaPrincipal = ventanaPrincipal;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(VENTANA_AGREGAR)) {
			VentanaPrincipal.ventanaAgregar();
		}
		else if (e.getActionCommand().equals(ADD)) {
			VentanaPrincipal.AddList();
			
		}
		else if (e.getActionCommand().equals(VALIDATE_BOX)) {
			VentanaPrincipal.ValidateBox();
		}
		else if(e.getActionCommand().equals(ELIMINAR)){
			VentanaPrincipal.Eliminar();
		}
	}

}
