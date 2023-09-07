package Login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controll.ActionsControll;
import Controll.ControlTaxi;
import InterfazAdmin.WindowsAdmin;

public class RegistrerClient extends JFrame implements ActionsControll,WindowListener{
	private ControlTaxi controll;
	private PCentral pc;
	
	public RegistrerClient(){
		setTitle("Registrar");
		setSize(new Dimension(400,300));
        setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		addWindowListener(this);
	}
	@Override
	public void begin() {
		controll.had.pullJsonC();
		beginElements();
		addElements();
		
	}

	private void addElements() {
		add(pc, BorderLayout.CENTER);
		
	}
	private void beginElements() {
		pc=new PCentral(this);
		
	}
	@Override
	public void change() {
		new Login().setVisible(true); 
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public ControlTaxi getControll() {
		return controll;
	}
	@Override
	public void setControll(ControlTaxi control) {
		this.controll=control;
		
	}

	@Override
	public String[] readInput(String Option) {
		switch (Option) {
		case ActionsControll.REGISTRER:
			return loadClient();
		}
		return null;
	}

	private String[] loadClient() {
		String name=pc.getFirstName().getText();
		String lastName= pc.getLastName().getText();
		java.util.Date fecha=pc.getDateMake().getDate();
		DateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		String dateMake=f.format(fecha);
		String [] fecha1 = dateMake.split("/");
		int year = Integer.parseInt(fecha1[2]);
		if(year>2005){
			menor();
		}else{
		String identification=pc.getIdentification().getText(); 
		String user=pc.getUser().getText();
		String pasword=pc.getPassword().getText();
		return new String[] {name,lastName,dateMake,identification,user,pasword};
		}
		return null;
	}
	private void menor() {
		JOptionPane.showMessageDialog(null, "Lo sentimos necesitas ser mayor de 15 años!", "Error", JOptionPane.ERROR_MESSAGE);
		
	}
	@Override
	public void writeOutput(String Option, String[] Output, boolean state) {
		switch (Option) {
		case ActionsControll.REGISTRER:
			if(state) {
				pc.cleanFields();
				JOptionPane.showMessageDialog(null, "Se ha Registrado Con exito!!!");
			}else{
				pc.getUser().setText("");
				JOptionPane.showMessageDialog(null, "Su registro no se ha podido completar", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
	
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		controll.had.pushJsonC();
		change();
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
