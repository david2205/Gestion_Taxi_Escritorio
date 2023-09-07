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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Controll.ActionsControll;

public class UpdateClient extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField firstName,lastName,cedula,user;
	private JPasswordField password;
	private JButton find,update;
	
	public void cleanFields(){
		getFirstName().setText("");
		getLastName().setText("");
		getCedula().setText("");
		getUser().setText("");
		getPassword().setText("");
	}
	
	public UpdateClient(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Actualizar Cliente");
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
		add(new JLabel("ACTUALIZAR CLIENTE"),gbc);
		
		gbc.gridx=4;
		gbc.gridy=1;
		gbc.gridwidth=4;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/upC.png");
		btn.setIcon(icono);
		add(btn,gbc);
		gbc.fill=GridBagConstraints.HORIZONTAL;

		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=3;
		add(new JLabel("Usuario: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.gridwidth=3;
		cedula.addKeyListener(this);
		add(cedula,gbc);
		
		gbc.gridy=2;
		gbc.gridx=10;
		gbc.gridwidth=1;
		add(find,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=3;
		add(new JLabel("Nombre: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=3;
		gbc.gridwidth=3;
		firstName.addKeyListener(this);
		add(firstName,gbc);
		
		gbc.gridx=7;
		gbc.gridy=3;
		gbc.gridwidth=3;
		add(new JLabel("Apellido: "),gbc);
		
		gbc.gridx=10;
		gbc.gridy=3;
		gbc.gridwidth=3;
		lastName.addKeyListener(this);
		add(lastName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(new JLabel("Usuario: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(user,gbc);
		
		gbc.gridx=7;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(new JLabel("Contraseña: "),gbc);
		
		gbc.gridx=10;
		gbc.gridy=4;
		gbc.gridwidth=3;
		add(password,gbc);
		
		
		gbc.gridy=5;
		gbc.gridx=0;
		gbc.gridwidth=1;
		add(update,gbc);
		
	}


	private void beginElements() {
		firstName=new JTextField();
		firstName.setEnabled(false);
		lastName=new JTextField();
		lastName.setEnabled(false);
		cedula=new JTextField();
		user=new JTextField();
		user.setEnabled(false);
		password=new JPasswordField();
		password.setEnabled(false);

		update=new JButton("Actualizar");
		update.setActionCommand(ActionsControll.UPDATE_CLIENT);
		update.addActionListener(window.getControll());
		
		find=new JButton("Buscar");
		find.setActionCommand(ActionsControll.FIND_CLIENT);
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


	public JTextField getCedula() {
		return cedula;
	}


	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
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

}

