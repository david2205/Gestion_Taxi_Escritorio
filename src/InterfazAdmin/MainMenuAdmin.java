package InterfazAdmin;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


import Controll.ActionsControll;

public class MainMenuAdmin extends JMenuBar{
	private WindowsAdmin window;
	private JMenu Taxi;
	private JMenu Conductor;
	private JMenu Cliente;
	private JMenu Asignar;
	private JMenu help;
	private JMenuItem addD;
	private JMenuItem addT;
	private JMenuItem asignT;
	private JMenuItem delC;
	private JMenuItem delD;
	private JMenuItem delT;
	private JMenuItem upC;
	private JMenuItem upD;
	private JMenuItem UpT;
	private JMenuItem changeUser;
	private JMenuItem Exit;
	
	public MainMenuAdmin(WindowsAdmin window){
		this.window=window;
		beginElements();
		addElements();
	}


	private void beginElements() {
		Taxi=new JMenu("Taxi");
		Taxi.setMnemonic('T');
		Conductor=new JMenu("Conductor");
		Conductor.setMnemonic('C');
		Cliente=new JMenu("Cliente");
		Cliente.setMnemonic('L');
		Asignar = new JMenu("Asignar");
		Asignar.setMnemonic('A');
		help=new JMenu("Ayuda");
		help.setMnemonic('P');
		
		
		addT=new JMenuItem("Añadir Taxi");
		addT.setMnemonic('O');
		addT.setIcon(new ImageIcon("Resources/icons/addT.png"));
		addT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_MASK));
		addT.setActionCommand(ActionsControll.VIEW_ADD_TAXI);
		addT.addActionListener(window.getControll());
		
		addD=new JMenuItem("Añadir Conductor");
		addD.setMnemonic('L');
		addD.setIcon(new ImageIcon("Resources/icons/addD.png"));
		addD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_MASK));
		addD.setActionCommand(ActionsControll.VIEW_ADD_DRIVER);
		addD.addActionListener(window.getControll());
		
		
		asignT=new JMenuItem("Asignar Taxi");
		asignT.setMnemonic('D');
		asignT.setIcon(new ImageIcon("Resources/icons/asign.png"));
		asignT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK));
		asignT.setActionCommand(ActionsControll.VIEW_ASIGN);
		asignT.addActionListener(window.getControll());
		
		delC=new JMenuItem("Eliminar Cliente");
		delC.setMnemonic('E');
		delC.setIcon(new ImageIcon("Resources/icons/delC.png"));
		delC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
		delC.setActionCommand(ActionsControll.VIEW_DEL_CLIENT);
		delC.addActionListener(window.getControll());
		
		delD=new JMenuItem("Eliminar Conductor");
		delD.setMnemonic('A');
		delD.setIcon(new ImageIcon("Resources/icons/delD.png"));
		delD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK));
		delD.setActionCommand(ActionsControll.VIEW_DEL_DRIVER);
		delD.addActionListener(window.getControll());
		
		delT=new JMenuItem("Eliminar Taxi");
		delT.setMnemonic('R');
		delT.setIcon(new ImageIcon("Resources/icons/delT.png"));
		delT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
		delT.setActionCommand(ActionsControll.VIEW_DEL_TAXI);
		delT.addActionListener(window.getControll());
		
		upC=new JMenuItem("Actualizar Cliente");
		upC.setMnemonic('B');
		upC.setIcon(new ImageIcon("Resources/icons/upC.png"));
		upC.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,KeyEvent.CTRL_MASK));
		upC.setActionCommand(ActionsControll.VIEW_UPDATE_CLIENT);
		upC.addActionListener(window.getControll());
		
		upD=new JMenuItem("Actualizar Conductor");
		upD.setMnemonic('F');
		upD.setIcon(new ImageIcon("Resources/icons/upD.png"));
		upD.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_MASK));
		upD.setActionCommand(ActionsControll.VIEW_UPDATE_DRIVER);
		upD.addActionListener(window.getControll());
		
		UpT=new JMenuItem("Actualizar Taxi");
		UpT.setMnemonic('W');
		UpT.setIcon(new ImageIcon("Resources/icons/upT.png"));
		UpT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_MASK));
		UpT.setActionCommand(ActionsControll.VIEW_UPDATE_TAXI);
		UpT.addActionListener(window.getControll());
		
		changeUser=new JMenuItem("Cambiar Usuario");
		changeUser.setIcon(new ImageIcon("Resources/icons/cambio.png"));
		changeUser.setActionCommand(ActionsControll.CHANGE_USER);
		changeUser.addActionListener(window.getControll());
		
		Exit=new JMenuItem("Salir");
		Exit.setMnemonic('E');
		Exit.setIcon(new ImageIcon("Resources/icons/Salir.png"));
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
		Exit.setActionCommand(ActionsControll.EXIT);
		Exit.addActionListener(window.getControll());
		
		
		
	}
	
	private void addElements() {
		add(Taxi);
		Taxi.add(addT);
		Taxi.addSeparator();	
		Taxi.add(delT);
		Taxi.addSeparator();	
		Taxi.add(UpT);
		
		add(Conductor);
		Conductor.add(addD);
		Conductor.addSeparator();
		Conductor.add(delD);
		Conductor.addSeparator();
		Conductor.add(upD);
		
		add(Cliente);
		Cliente.add(delC);
		Cliente.addSeparator();
		Cliente.add(upC);

		
		add(Asignar);
		Asignar.add(asignT);
		
		

		
		add(help);
		help.add(changeUser);
		help.addSeparator();
		help.add(Exit);
		
		

		
		
	}


}
