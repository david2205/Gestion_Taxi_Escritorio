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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;


public class AddTaxi extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField plate,brand;
	private JSpinner nPuestos,model;
	private JComboBox pEquipaje;
	private JButton add;
	private JTable table;
	private DefaultTableModel modelTab;
	
	public void cleanFields(){
		getPlate().setText("");
		getBrand().setText("");
	}
	
	public AddTaxi(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Agregar Taxi");
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
		add(new JLabel("AÑADIR 	TAXI"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/addT.png");
		btn.setIcon(icono);
		add(btn,gbc);
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(new JLabel("Placa"),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(new JLabel("Modelo"),gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(new JLabel("Valor"),gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		add(plate,gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(model,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(nPuestos,gbc);

		gbc.gridy=5;
		gbc.gridx=0;
		gbc.gridwidth=2;
		add(new JLabel("Marca"),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(new JLabel("Portaqeuipaje"),gbc);
		
		
		gbc.gridy=6;
		gbc.gridx=0;
		gbc.gridwidth=2;
		add(brand,gbc);
		
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(pEquipaje,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(add,gbc);
		
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridy=10;
		gbc.gridwidth=6;
		gbc.gridheight=8;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);
		
	}


	private void beginElements() {
		SpinnerNumberModel mod = new SpinnerNumberModel(1980, 1, 2021, 1);
		SpinnerNumberModel model1 = new SpinnerNumberModel(10, 1, 4000, 1);
		plate=new JTextField();
		brand=new JTextField();
		nPuestos=new JSpinner(model1);
		model=new JSpinner(mod);
		pEquipaje=new JComboBox<>();
		pEquipaje.addItem("SI");
		pEquipaje.addItem("NO");
		
		modelTab=new DefaultTableModel(new String[] {"Marca","Modelo","Placa","Valor","Portaequipaje"}, 0);
		table=new JTable(modelTab);
		
		add=new JButton("Agregar");
		add.setActionCommand(ActionsControll.ADD_TAXI);
		add.addActionListener(window.getControll());
		
		
		
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


	public JTextField getPlate() {
		return plate;
	}


	public void setPlate(JTextField plate) {
		this.plate = plate;
	}


	public JTextField getBrand() {
		return brand;
	}


	public void setBrand(JTextField brand) {
		this.brand = brand;
	}


	public JSpinner getnPuestos() {
		return nPuestos;
	}


	public void setnPuestos(JSpinner nPuestos) {
		this.nPuestos = nPuestos;
	}


	public JSpinner getModel() {
		return model;
	}


	public void setModel(JSpinner model) {
		this.model = model;
	}


	public JComboBox getpEquipaje() {
		return pEquipaje;
	}


	public void setpEquipaje(JComboBox pEquipaje) {
		this.pEquipaje = pEquipaje;
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
