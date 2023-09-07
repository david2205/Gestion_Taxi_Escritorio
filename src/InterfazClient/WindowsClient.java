package InterfazClient;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Stack;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;
import Controll.ControlTaxi;
import Logic.Driver;
import Login.Login;
import Login.PCentral;

public class WindowsClient extends JFrame implements ActionsControll,WindowListener{
	 ControlTaxi controll;
	public PClient pc;
	String nombre;
	String apellido;
	
	public WindowsClient(){
		setTitle("Servicio De Taxis");
		setSize(new Dimension(600,500));
        setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		addWindowListener(this);
	}

	public void Cliente(String user){
		int pos=getControll().had.findClient(user);
		nombre=getControll().had.getClients().get(pos).getName();
		apellido=getControll().had.getClients().get(pos).getLastName();
	}
	
	@Override
	public void begin() {
		beginElements();
		addElements();
		getControll().had.pullJsonD();
		getControll().had.pullJsonC();
		getControll().had.pullJsonT();
		getControll().had.pullJsonS();
		llenarTabla(getControll().had.getDrivers());
	}

	private void addElements() {
		add(pc, BorderLayout.CENTER);
		
	}

	private void beginElements() {
		pc=new PClient(this);
		
	}

	@Override
	public void change() {
		new Login().setVisible(true); 
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControll(ControlTaxi control) {
		this.controll=control;
	}

	@Override
	public String[] readInput(String Option) {
		switch (Option) {
		case ActionsControll.CANCEL:
			 cancel();
			 break;
		case ActionsControll.APPLY:
			return loadServicio();
		case ActionsControll.END_S:
			return finServicio();
	}
		return null;
	}

	private int calcSegundos(String inicio,String fin){
		int SegundosT = 0;
				String [] horaI=inicio.split(":");
				int minutoI = Integer.parseInt(horaI[1]);
				int segundoi = Integer.parseInt(horaI[2]);
				String [] horaF=fin.split(":");
				int minutof = Integer.parseInt(horaF[1]);
				int segundof = Integer.parseInt(horaF[2]);
				int segundI=60-segundoi;
				int segundF=segundof;
				if(minutof-minutoI>0){
				SegundosT=(segundI+segundF)+(((minutof-minutoI)-1)*60);
				return SegundosT;
				}
				SegundosT=segundF-segundoi;
				return SegundosT;
	}
	
	private void cancel() {
		int hora,minutos,segundos;
		int pos=getControll().had.findServicio(pc.getPlaca().getText());
		if(pos!=-1){
		String horaI=getControll().had.getServicios().get(pos).getHoraInicio();
		Calendar calendario=Calendar.getInstance();
		hora=calendario.get(Calendar.HOUR_OF_DAY);
		minutos=calendario.get(Calendar.MINUTE);
		segundos=calendario.get(Calendar.SECOND);
		String horaF=(hora+":"+minutos+":"+segundos);
		int second=calcSegundos(horaI, horaF);
		int driver=findDis(pc.getPlaca().getText());
		int recorrido=getControll().had.getDrivers().get(driver).getSecods();
		if((recorrido-second)>10){
			getControll().had.cancelServicio(pc.getPlaca().getText());
			int posT=getControll().had.findTaxi(pc.getPlaca().getText());
			getControll().had.getTaxis().get(posT).setState(true);
			JOptionPane.showMessageDialog(null, "Su servicio se ha cancelado con exito");
			pc.getPlaca().setText("");
		}else{
			JOptionPane.showMessageDialog(null, "Lo sentimos su servicio esta a menos de 10 segundos de distancia", "Error", JOptionPane.ERROR_MESSAGE);		

		}
		}else{
			noExiste();
		}
		
	}

	private int findDis(String placa){
		for (int i = 0; i < getControll().had.getDrivers().size(); i++) {
			if(getControll().had.getDrivers().get(i).getTaxi().equals(placa)){
				return i;
			}
		}
		return -1;
	}
	
	private String[] finServicio() {
		String taxi=pc.getPlaca().getText();
		if(getControll().had.findTaxi(taxi)!=-1){
		return new String[] {taxi};
		}else{
			noExiste();
		}
		return null;
	}

	private String[] loadServicio() {
		int hora,minutos,segundos;
		Calendar calendario=Calendar.getInstance();
		hora=calendario.get(Calendar.HOUR_OF_DAY);
		minutos=calendario.get(Calendar.MINUTE);
		segundos=calendario.get(Calendar.SECOND);
		String horaInicio=(hora+":"+minutos+":"+segundos);
		String cliente=(nombre+" "+apellido);
		String taxi=pc.getPlaca().getText();
		if(getControll().had.findTaxi(taxi)!=-1){
		if(getControll().had.getTaxis().get(getControll().had.findTaxi(taxi)).isState()==true){
			return new String[] {horaInicio,cliente,taxi};
		}else{
			Ocupado();
		}
		}else{
			noExiste();
		}
		return null;
	}

	private void Ocupado() {
		JOptionPane.showMessageDialog(null, "Lo sentimos el taxi ya esta ocupado", "Error", JOptionPane.ERROR_MESSAGE);		
	}

	private void noExiste(){
		JOptionPane.showMessageDialog(null, "Lo sentimos el taxi no existe", "Error", JOptionPane.ERROR_MESSAGE);		

	}
	
	@Override
	public void writeOutput(String Option, String[] Output, boolean state) {
		switch (Option) {
		case ActionsControll.APPLY:
			if(state) {
				JOptionPane.showMessageDialog(null, "Su servicio se ha confirmado");
			}else{
				
				JOptionPane.showMessageDialog(null, "Su servicio no se ha podido completar", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
			case ActionsControll.END_S:
				if(state) {
					JOptionPane.showMessageDialog(null, "Su servicio se ha terminado, esperando confirmacion del conductor");
				}else{
					
					JOptionPane.showMessageDialog(null, "Su servicio no se ha podido finalizar", "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
		}
		
	}

	public ControlTaxi getControll() {
		return controll;
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
		getControll().had.pushJsonS();
		getControll().had.pushJsonT();
		getControll().had.pushJsonD();
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

	
	
	
	public void llenarTabla(ArrayList<Driver> arrayList){
		DefaultTableModel dtm = pc.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < controll.had.getDrivers().size(); i++) {
			getControll().had.getDrivers().get(i).setSecods((int) Math.floor(Math.random()*30+10));
			if(controll.had.getDrivers().get(i).getTaxi().equals("NO ASIGNADO")){
				
			}else{
				String Placa=controll.had.getDrivers().get(i).getTaxi();
				int pos=getControll().had.findTaxi(Placa);
				String Conductor=controll.had.getDrivers().get(i).getName();
				String tiempo=String.valueOf(controll.had.getDrivers().get(i).getSecods());
				String numP=String.valueOf(getControll().had.getTaxis().get(pos).getValor());
				String Equp="SI";
				if(getControll().had.getTaxis().get(pos).isLuggage()==false){
					Equp="NO";
				}else{
					Equp="SI";
				}
				String state=null;
				if(getControll().had.getTaxis().get(pos).isState()==false){
					state="No Disponible";
				}else{
					state="Disponible";
				}
				Object[] row= new Object[]{Placa,numP,Equp,Conductor,tiempo,state};
				dtm.addRow(row);
			}
		}
	}

}
