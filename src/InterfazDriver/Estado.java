package InterfazDriver;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Controll.ActionsControll;
import InterfazClient.WindowsClient;

public class Estado extends JPanel{
	WindowsDriver window;
	private JButton placa,confirm,cancel;
	private JRadioButton cliente,libre;
	private JComboBox estado;
	
	
	public Estado(	WindowsDriver window){
		this.window=window;	
		setLayout(new GridBagLayout());
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		TitledBorder title = BorderFactory.createTitledBorder(loweredbevel,"Estado");
		this.setBorder(title);
		beginElements();
		addElements();
	}

	private void addElements() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		add(new JLabel("Taxi Asignado: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(placa,gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=2;
		add(libre,gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(cliente,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(new JLabel("Estado: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(estado,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		add(confirm,gbc);
		
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.gridwidth=2;
		add(cancel,gbc);
		
		
	}

	private void beginElements() {
		placa=new JButton("Placa Carro");
		placa.setOpaque(true);
		placa.setFocusPainted(false);
		placa.setBorderPainted(false);
		placa.setContentAreaFilled(false);
		
		confirm=new JButton("Confirmar");
		confirm.setActionCommand(ActionsControll.END);
		confirm.addActionListener(window.getControl());
		
		cancel=new JButton("Cancelar");
		cancel.setActionCommand(ActionsControll.CANCEL_D);
		cancel.addActionListener(window.getControl());
		
		cliente=new JRadioButton("Cliente");
		cliente.setEnabled(false);
		libre=new JRadioButton("Libre");
		libre.setEnabled(false);
		
		estado=new JComboBox<>();
		estado.addItem("Disponible");
		estado.addItem("No Disponible");
		
	}

	public JButton getPlaca() {
		return placa;
	}

	public void setPlaca(JButton placa) {
		this.placa = placa;
	}

	public JRadioButton getCliente() {
		return cliente;
	}

	public void setCliente(JRadioButton cliente) {
		this.cliente = cliente;
	}

	public JRadioButton getLibre() {
		return libre;
	}

	public void setLibre(JRadioButton libre) {
		this.libre = libre;
	}

	public JComboBox getEstado() {
		return estado;
	}

	public void setEstado(JComboBox estado) {
		this.estado = estado;
	}
	
}
