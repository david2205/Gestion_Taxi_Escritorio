package Login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Controll.ActionsControll;
import Controll.ControlTaxi;
import InterfazAdmin.WindowsAdmin;

public class PCentral extends JPanel implements KeyListener{
	private JTextField firstName,lastName,identification,user;
	private JPasswordField password;
	private JButton Registrar;
	private JDateChooser dateMake;
	private RegistrerClient window;
	
	public PCentral(RegistrerClient window){
		this.window=window;	
		setLayout(new GridBagLayout());
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		TitledBorder title = BorderFactory.createTitledBorder(loweredbevel,"Datos del Usuario");
		this.setBorder(title);
		beginElements();
		addElements();
	}

	public void cleanFields(){
		getFirstName().setText("");
		getLastName().setText("");
		getIdentification().setText("");
		getUser().setText("");
		getPassword().setText("");
	}
	
	private void addElements() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx=1.0;
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=2;
		add(new JLabel("REGISTRO"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/regis.png");
		btn.setIcon(icono);
		add(btn,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=3;
		add(new JLabel("Nombre: "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=3;
		firstName.addKeyListener(this);
		add(firstName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(new JLabel("Apellido: "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=3;
		add(lastName,gbc);
		lastName.addKeyListener(this);
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.gridwidth=3;
		add(new JLabel("Cedula: "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=3;
		identification.addKeyListener(this);
		add(identification,gbc);
		
		gbc.gridx=0;
		gbc.gridy=8;
		gbc.gridwidth=3;
		add(new JLabel("Fecha Nacimiento: "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=3;
		add(dateMake,gbc);
		
		gbc.gridx=0;
		gbc.gridy=10;
		gbc.gridwidth=3;
		add(new JLabel("Usuario: "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=3;
		add(user,gbc);
		
		gbc.gridx=0;
		gbc.gridy=12;
		gbc.gridwidth=3;
		add(new JLabel("Contraseña: "),gbc);
		
		gbc.gridx=3;
		gbc.gridwidth=3;
		add(password,gbc);
		
		gbc.gridx=0;
		gbc.gridy=14;
		gbc.gridwidth=3;
		add(Registrar,gbc);
		
	}

	private void beginElements() {
		dateMake = new JDateChooser(Calendar.getInstance().getTime());
		lastName=new JTextField();
		firstName=new JTextField();
		identification=new JTextField();
		user=new JTextField();
		password=new JPasswordField();
		
		Registrar=new JButton("Registrar");
		Registrar.setActionCommand(ActionsControll.REGISTRER);
		Registrar.addActionListener(window.getControll());
		
		
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

	public JTextField getIdentification() {
		return identification;
	}

	public void setIdentification(JTextField identification) {
		this.identification = identification;
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

	public JButton getRegistrar() {
		return Registrar;
	}

	public void setRegistrar(JButton registrar) {
		Registrar = registrar;
	}

	public JDateChooser getDateMake() {
		return dateMake;
	}

	public void setDateMake(JDateChooser dateMake) {
		this.dateMake = dateMake;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
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
		if(e.getSource()==identification){
			char key = e.getKeyChar();
			if(((key < '0') ||(key > '9'))){
				e.consume();

			}
		}	
		
	}

	
	
}
