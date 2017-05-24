package controlador;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.UserDAO;
import vista.Vista;
import modelo.Usuario;

//action listener para recibir los eventos
public class Controlador implements ActionListener {
	
	private Vista vista;
	private UserDAO userDAO;
	private List<Usuario> listaUsuarios;
	private static int contador1 = 0;
	
	
	
	
	public Controlador(Vista vista, UserDAO userDAO) {
		//necesita acceso a la vista y a los datos
		this.vista = vista;
		this.userDAO = userDAO;
		actionListener(this);
		listaUsuarios = userDAO.getListaUsuarios();
		mostraUsuario(0);
	}



	//respuesta a los eventos de la vista
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(">")){
			contador1++;
			if (contador1 == listaUsuarios.size())
				contador1 = 0;
			mostraUsuario(contador1);
		}
		if (e.getActionCommand().equals("<")){
			contador1--;
			if (contador1 < 0)
				contador1 = listaUsuarios.size()-1;
			mostraUsuario(contador1);
		}
		if (e.getActionCommand().equals("<<")){
			contador1-=25;
			if (contador1 < 0)
				contador1 = listaUsuarios.size()-1;
			mostraUsuario(contador1);
		}
		if (e.getActionCommand().equals(">>")){
			contador1+=25;
			if (contador1 == listaUsuarios.size())
				contador1 = 0;
			mostraUsuario(contador1);
		}
		if (e.getActionCommand().equals("Actualizar")){
			vista.getTextFieldLogin().setEditable(false);
			vista.getTextFieldPassword().setEditable(true);
			vista.getTextFieldCode().setEditable(true);
			vista.getTextFieldGender().setEditable(true);
		}
		if (e.getActionCommand().equals("Guardar")){
			vista.getTextFieldPassword().setEditable(false);
			vista.getTextFieldCode().setEditable(false);
			vista.getTextFieldGender().setEditable(false);
		}
			

	}
	
	//registro los eventos de la vista
	public void actionListener(ActionListener escuchador){
		vista.getButtonAvance1().addActionListener(escuchador);
		vista.getButtonRetroceso1().addActionListener(escuchador);
		vista.getButtonAvance25().addActionListener(escuchador);
		vista.getButtonRetroceso25().addActionListener(escuchador);
		vista.getBtnActualizar().addActionListener(escuchador);
		vista.getBtnGuardar().addActionListener(escuchador);
	}
	
	private void mostraUsuario(int indice){
		vista.getTextFieldLogin().setText(
				listaUsuarios.get(indice).getLogin());
		vista.getTextFieldPassword().setText(
				listaUsuarios.get(indice).getPassword());
		vista.getTextFieldCode().setText(
				listaUsuarios.get(indice).getCode());
		vista.getTextFieldGender().setText(
				listaUsuarios.get(indice).getGender());
	}

}
