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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;

public class UpdateTaxi extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField plate,brand;
	private JSpinner nPuestos,model;
	private JComboBox pEquipaje;
	private JButton update,find;
	
	public void cleanFields(){
		getPlate().setText("");
		getBrand().setText("");
	}
	
	public UpdateTaxi(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Actualizar Taxi");
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

		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridx=4;
		gbc.gridy=0;
		gbc.gridwidth=4;
		add(new JLabel("ACTUALIZAR TAXI"),gbc);
		
		gbc.gridx=4;
		gbc.gridy=1;
		gbc.gridwidth=4;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/upT.png");
		btn.setIcon(icono);
		add(btn,gbc);
		gbc.fill=GridBagConstraints.HORIZONTAL;

		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=3;
		add(new JLabel("Placa: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.gridwidth=3;
		plate.addKeyListener(this);
		add(plate,gbc);
		
		gbc.gridy=2;
		gbc.gridx=10;
		gbc.gridwidth=1;
		add(find,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=3;
		add(new JLabel("Marca: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=3;
		gbc.gridwidth=3;
		brand.addKeyListener(this);
		add(brand,gbc);
		
		gbc.gridx=7;
		gbc.gridy=3;
		gbc.gridwidth=3;
		add(new JLabel("Valor: "),gbc);
		
		gbc.gridx=10;
		gbc.gridy=3;
		gbc.gridwidth=3;
		add(nPuestos,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(new JLabel("Modelo: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(model,gbc);
		
		gbc.gridx=7;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(new JLabel("Portaequipaje: "),gbc);
		
		gbc.gridx=10;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(pEquipaje,gbc);
		
		
		gbc.gridy=5;
		gbc.gridx=0;
		gbc.gridwidth=1;
		add(update,gbc);
		
	}


	private void beginElements() {
		SpinnerNumberModel mod = new SpinnerNumberModel(1980, 1, 2021, 1);
		SpinnerNumberModel model1 = new SpinnerNumberModel(600, 1, 6000, 1);
		plate=new JTextField();
		brand=new JTextField();
		brand.setEnabled(false);
		nPuestos=new JSpinner(model1);
		nPuestos.setEnabled(false);
		model=new JSpinner(mod);
		model.setEnabled(false);
		pEquipaje=new JComboBox<>();
		pEquipaje.setEnabled(false);
		pEquipaje.addItem("SI");
		pEquipaje.addItem("NO");
		
		
		update=new JButton("Actualizar");
		update.setActionCommand(ActionsControll.UPDATE_TAXI);
		update.addActionListener(window.getControll());
		
		find=new JButton("Buscar");
		find.setActionCommand(ActionsControll.FIND_TAXI);
		find.addActionListener(window.getControll());
		
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

}
