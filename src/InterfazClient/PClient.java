package InterfazClient;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;



public class PClient extends JPanel{
	private WindowsClient window;
	private JTextField placa;
	private JButton solicitar,terminar,cancel;
	private JTable table;
	private DefaultTableModel modelTab;
	
	public PClient(WindowsClient window){
		this.window=window;	
		setLayout(new GridBagLayout());
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		TitledBorder title = BorderFactory.createTitledBorder(loweredbevel,"Usuario");
		this.setBorder(title);
		beginElements();
		addElements();
	}

	private void addElements() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx=1.0;
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=2;
		add(new JLabel("CLIENTE"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/client.png");
		btn.setIcon(icono);
		add(btn,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(new JLabel("Placa: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(placa,gbc);
		
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(solicitar,gbc);
		
		gbc.gridy=3;
		gbc.gridx=0;
		gbc.gridwidth=2;
		add(terminar,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(cancel,gbc);
		
		
		gbc.gridy=4;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridwidth=6;
		gbc.gridheight=8;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);
		
	}

	private void beginElements() {
		placa=new JTextField();
		cancel=new JButton("Cancelar");
		
		
		modelTab=new DefaultTableModel(new String[] {"Placa Taxi","Valor","Equipaje","Conductor","Tiempo(s)","Estado"}, 0);
		table=new JTable(modelTab);
		
		solicitar=new JButton("Solicitar");
		solicitar.setActionCommand(ActionsControll.APPLY);
		solicitar.addActionListener(window.getControll());
		
		terminar=new JButton("Terminar Servicio");
		terminar.setActionCommand(ActionsControll.END_S);
		terminar.addActionListener(window.getControll());
		
		
		cancel.setActionCommand(ActionsControll.CANCEL);
		cancel.addActionListener(window.getControll());
	}

	public JTextField getPlaca() {
		return placa;
	}

	public void setPlaca(JTextField placa) {
		this.placa = placa;
	}

	public JButton getSolicitar() {
		return solicitar;
	}

	public void setSolicitar(JButton solicitar) {
		this.solicitar = solicitar;
	}

	public JButton getTerminar() {
		return terminar;
	}

	public void setTerminar(JButton terminar) {
		this.terminar = terminar;
	}

	public JButton getValor() {
		return cancel;
	}

	public void setValor(JButton valor) {
		this.cancel = valor;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModelTab() {
		return modelTab;
	}

	public void setModelTab(DefaultTableModel modelTab) {
		this.modelTab = modelTab;
	}

	
	
}
