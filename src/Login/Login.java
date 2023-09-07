package Login;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controll.ControlTaxi;
import InterfazAdmin.WindowsAdmin;
import InterfazClient.WindowsClient;
import InterfazDriver.WindowsDriver;


public class Login  extends JFrame implements ActionListener{
	private ControlTaxi control;
	private JLabel labIcono,labAdmin,labPassword;
	private JTextField txtUsuario; 
	private JButton btingresar,btnRegis;
	private JPasswordField txtpass;
	
	public Login() {
		setTitle("Ingreso");
		setSize(new Dimension(600,400));
		setLayout(null);
		setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        control=new ControlTaxi(null);
        beginElements();
        addElements();
        control.had.pullJsonD();
        control.had.pullJsonC();
        control.had.pullJsonT();
	}
	
	private void addElements() {
		ImageIcon imagen = new ImageIcon("Resources/icons/taxi.png");
		labIcono.setBounds(235,25, 135, 150);
		labIcono.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(labIcono.getWidth(), labIcono.getHeight(), Image.SCALE_SMOOTH)));
		labAdmin.setFont(new Font("arial",Font.BOLD,16));
		labAdmin.setBounds(130, 190, 100, 30);
		labPassword.setFont(new Font("arial",Font.BOLD,16));
		labPassword.setBounds(100, 250, 100, 30);
		txtUsuario.setFont(new Font("arial",Font.PLAIN,16));
		txtUsuario.setBounds(200, 185, 240, 40);
		txtpass.setFont(new Font("arial",Font.PLAIN,16));
		txtpass.setBounds(200, 245, 240, 40);
		btingresar.setFont(new Font("arial",Font.PLAIN,10));
		btingresar.addActionListener(this);
		btingresar.setBounds(200, 300, 100, 35);
	    btnRegis.setFont(new Font("arial",Font.PLAIN,10));
	    btnRegis.addActionListener(this);
		btnRegis.setBounds(332, 300, 110, 35);
		
		add(labIcono);
		add(labAdmin);
		add(txtUsuario);
		add(labPassword);
		add(txtpass);
		add(btingresar);
		add(btnRegis);
		
	}

	private void beginElements() {
		labIcono = new JLabel();
		labAdmin = new JLabel("Usuario: ");
		labPassword= new JLabel("Contraseña: ");
		txtUsuario=new JTextField();
		txtpass= new JPasswordField();
		btingresar= new JButton("INGRESAR");
		btnRegis= new JButton("REGISTRATE!!!");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user="admin";
		String pass="123";
		String password = new String(txtpass.getPassword());
		
		WindowsAdmin winA = new WindowsAdmin();
		ControlTaxi controllA = new ControlTaxi(winA);
		winA.setControll(controllA);
		winA.begin();
		
		WindowsClient winC = new WindowsClient();
		ControlTaxi controlC = new ControlTaxi(winC);
		winC.setControll(controlC);
		winC.begin();
		
		WindowsDriver winD = new WindowsDriver();
		ControlTaxi controllD = new ControlTaxi(winD);
		winD.setControll(controllD);
		winD.begin();
		
		RegistrerClient winR=new RegistrerClient();
		ControlTaxi controllR = new ControlTaxi(winR);
		winR.setControll(controllR);
		winR.begin();
		
		switch (e.getActionCommand()) {
		case "INGRESAR":
			if(user.equals(txtUsuario.getText()) && pass.equals(password)) {
				JOptionPane.showMessageDialog(this, "Bienvenido");
				winA.setVisible(true);
				dispose();
			}else if(control.had.confirmClient(txtUsuario.getText(), password)){
				JOptionPane.showMessageDialog(this, "Bienvenido");
				winC.setVisible(true);
				winC.Cliente(txtUsuario.getText());
				dispose();
			}else if(control.had.confirmDriver(txtUsuario.getText(), password)){
				JOptionPane.showMessageDialog(this, "Bienvenido");
				winD.setVisible(true);
				winD.taxi(txtUsuario.getText());
				dispose();
			}else{
				JOptionPane.showMessageDialog(this, "ERROR!!!.... Usuario o Clave Incorrectas");
				txtpass.setText("");
			}
			break;
		case  "REGISTRATE!!!":
				winR.setVisible(true);
				dispose();
			break;

		}
		
	}

}
