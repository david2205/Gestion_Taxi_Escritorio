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

public class UpdateDriver extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField firstName,lastName,cell,addres,user;
	private JPasswordField password;
	private JButton update,find;

	public void cleanFields(){
		getFirstName().setText("");
		getLastName().setText("");
		getCell().setText("");
		getAddres().setText("");
		getUser().setText("");
		getPassword().setText("");
	}
	
	public UpdateDriver(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("Actualizar Conductor");
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
		
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=2;
		add(new JLabel("ACTUALIZAR 	CONDUCTOR"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=2;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/upD.png");
		btn.setIcon(icono);
		add(btn,gbc);
		
		
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=2;
		add(new JLabel("Usuario: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(user,gbc);
		
		gbc.gridx=4;
		gbc.gridwidth=2;
		add(find,gbc);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.gridwidth=2;
		add(new JLabel("Contraseña: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(password,gbc);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.gridwidth=2;
		add(new JLabel("Celular: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		cell.addKeyListener(this);
		add(cell,gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=2;
		add(new JLabel("Direccion: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		add(addres,gbc);
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.gridwidth=2;
		add(new JLabel("Nombre: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		firstName.addKeyListener(this);
		add(firstName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.gridwidth=2;
		add(new JLabel("Apellido: "),gbc);
		
		gbc.gridx=2;
		gbc.gridwidth=2;
		lastName.addKeyListener(this);
		add(lastName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=8;
		gbc.gridwidth=2;
		add(update,gbc);
		
	}


	private void beginElements() {
		firstName=new JTextField();
		firstName.setEnabled(false);
		lastName=new JTextField();
		lastName.setEnabled(false);
		cell=new JTextField();
		cell.setEnabled(false);
		addres=new JTextField();
		addres.setEnabled(false);
		user=new JTextField();
		password=new JPasswordField();
		password.setEnabled(false);

		
		update=new JButton("Actualizar");
		update.setActionCommand(ActionsControll.UPDATE_DRIVER);
		update.addActionListener(window.getControll());
		
		find=new JButton("Buscar");
		find.setActionCommand(ActionsControll.FIND_DRIVER);
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

}
