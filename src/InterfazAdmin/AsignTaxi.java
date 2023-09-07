package InterfazAdmin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;

public class AsignTaxi extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField taxi,driver;
	private JButton asignar;
	private JTable table;
	private DefaultTableModel modelTab;
	
	public void cleanFields(){
		getTaxi().setText("");
		getDriver().setText("");
	}
	
	public AsignTaxi(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Asignar Taxi");
		setSize(new Dimension(320,260));
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		beginElements();
		addElements();
		this.pack();
		desktop.add(this);
	}
	

	private void addElements() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx=1.0;
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=2;
		add(new JLabel("ASIGNAR"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/asign.png");
		btn.setIcon(icono);
		add(btn,gbc);
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(new JLabel("Placa Taxi"),gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(new JLabel("Usuario Conductor"),gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		add(taxi,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(driver,gbc);
		
		gbc.gridy=5;
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(asignar,gbc);
		
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.gridwidth=6;
		gbc.gridheight=8;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);

		
	}


	private void beginElements() {
		taxi=new JTextField();
		driver=new JTextField();
		asignar=new JButton("Asignar");
		
		modelTab=new DefaultTableModel(new String[] {"Placa","Conductor","Telefono"}, 0);
		table=new JTable(modelTab);
		
		asignar=new JButton("Asignar");
		asignar.setActionCommand(ActionsControll.ASIGN);
		asignar.addActionListener(window.getControll());
		
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	public JTextField getTaxi() {
		return taxi;
	}


	public void setTaxi(JTextField taxi) {
		this.taxi = taxi;
	}


	public JTextField getDriver() {
		return driver;
	}


	public void setDriver(JTextField driver) {
		this.driver = driver;
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

