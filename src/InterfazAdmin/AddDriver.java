package InterfazAdmin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controll.ActionsControll;

public class AddDriver extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField firstName,lastName,cell,addres,user;
	private JPasswordField password;
	private JButton add;
	private JDateChooser dateMake;
	private JTable table;
	private DefaultTableModel modelTab;
	
	public void cleanFields(){
		getFirstName().setText("");
		getLastName().setText("");
		getCell().setText("");
		getAddres().setText("");
		getUser().setText("");
		getPassword().setText("");
	}
	
	public AddDriver(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Agregar Conductor");
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
		add(new JLabel("AÑADIR 	CONDUCTOR"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/addD.png");
		btn.setIcon(icono);
		add(btn,gbc);
		

		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(new JLabel("Nombre"),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(new JLabel("Apellido"),gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(new JLabel("Celular"),gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		firstName.addKeyListener(this);
		add(firstName,gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(lastName,gbc);
		lastName.addKeyListener(this);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		cell.addKeyListener(this);
		add(cell,gbc);

		gbc.gridy=5;
		gbc.gridx=0;
		gbc.gridwidth=2;
		add(new JLabel("Direccion"),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(new JLabel("Usuario"),gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(new JLabel("Contraseña"),gbc);
		
		gbc.gridy=6;
		gbc.gridx=0;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(addres,gbc);
		
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(user,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(password,gbc);
		
		
		gbc.gridy=8;
		gbc.gridx=0;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(new JLabel("Fecha Nacimiento: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(dateMake,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		add(add,gbc);
		
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridy=10;
		gbc.gridwidth=5;
		gbc.gridheight=8;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);
		
		
		
	}


	private void beginElements() {
		firstName=new JTextField();
		lastName=new JTextField();
		cell=new JTextField();
		addres=new JTextField();
		user=new JTextField();
		password=new JPasswordField();
		dateMake = new JDateChooser(Calendar.getInstance().getTime());
		
		modelTab=new DefaultTableModel(new String[] {"Nombre","Apellido","Movil","Direccion","Usuario"}, 0);
		table=new JTable(modelTab);
		
		add=new JButton("Agregar");
		add.setActionCommand(ActionsControll.ADD_DRIVER);
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
		if(e.getSource()==firstName){
			char key = e.getKeyChar();
			if(key<'A'|| key>'Z'&&key<'a'|| key>'z'){
				e.consume();

		}
		}else if(e.getSource()==lastName){
				char key = e.getKeyChar();
				if(key<'A'|| key>'Z'&&key<'a'|| key>'z'){
					e.consume();

			}
		}
		if(e.getSource()==cell){
			char key = e.getKeyChar();
			if(((key < '0') ||(key > '9'))){
				e.consume();

			}
		}	
		
	}


	

	public JTextField getFirstName() {
		return firstName;
	}


	public void setFirstName(JTextField firstName) {
		this.firstName = firstName;
	}


	public JTextField getLastName() {
		return lastName;
	}


	public void setLastName(JTextField lastName) {
		this.lastName = lastName;
	}


	public JTextField getCell() {
		return cell;
	}


	public void setCell(JTextField cell) {
		this.cell = cell;
	}


	public JTextField getAddres() {
		return addres;
	}


	public void setAddres(JTextField addres) {
		this.addres = addres;
	}


	public JTextField getUser() {
		return user;
	}


	public void setUser(JTextField user) {
		this.user = user;
	}


	public JPasswordField getPassword() {
		return password;
	}


	public void setPassword(JPasswordField password) {
		this.password = password;
	}


	public JDateChooser getDateMake() {
		return dateMake;
	}


	public void setDateMake(JDateChooser dateMake) {
		this.dateMake = dateMake;
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

