package InterfazAdmin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;

public class DelClient extends JInternalFrame  implements KeyListener{
	private WindowsAdmin window;
	private JDesktopPane desktop;
	private JTextField user;
	private JButton del;
	private JTable table;
	private DefaultTableModel modelTab;
	
	public void CleanFields(){
		getUser().setText("");
	}
	
	public DelClient(WindowsAdmin window,JDesktopPane desktop){
		this.window=window;
		this.desktop=desktop;
		setTitle("ELIMINAR CLIENTE");
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
		gbc.fill=GridBagConstraints.BOTH;
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=3;
		add(new JLabel("Eliminar Cliente"),gbc);
		
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.gridwidth=3;
		JLabel btn=new JLabel();
		ImageIcon icono=new ImageIcon("resources/icons/delC.png");
		btn.setIcon(icono);
		add(btn,gbc);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.gridwidth=3;
		add(new JLabel("Cedula: "),gbc);
		
		gbc.gridx=3;
		gbc.gridy=2;
		gbc.gridwidth=3;
		user.addKeyListener(this);
		add(user,gbc);
		
		gbc.gridy=4;
		gbc.gridx=3;
		gbc.gridwidth=1;
		add(del,gbc);
		
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridy=6;
		gbc.gridwidth=5;
		gbc.gridheight=8;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);
	}


	private void beginElements() {
		user=new JTextField();
		
		del=new JButton("Eliminar");
		del.setActionCommand(ActionsControll.DEL_CLIENT);
		del.addActionListener(window.getControll());
		
		modelTab=new DefaultTableModel(new String[] {"Nombre","Cedula","Usuario"}, 0);
		table=new JTable(modelTab);
		
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


	public JTextField getUser() {
		return user;
	}


	public void setUser(JTextField user) {
		this.user = user;
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

