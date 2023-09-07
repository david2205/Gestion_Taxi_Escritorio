package InterfazDriver;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;
import Controll.ControlTaxi;
import Logic.Driver;
import Logic.Serivicio;
import Login.Login;

public class WindowsDriver extends JFrame implements ActionsControll,WindowListener{
	ControlTaxi control;
	private Rutas rutas;
	private Estado estado;
	String taxi;
	
	
	public WindowsDriver(){
		setTitle("Servicio De Taxis");
		setSize(new Dimension(700,300));
        setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		addWindowListener(this);
	}
	
	

	public void taxi(String usuario){
		int pos=getControl().had.findDriver(usuario);
		taxi=getControl().had.getDrivers().get(pos).getTaxi();
		estado.getPlaca().setText(taxi);
		llenarTabla(getControl().had.getServicios(),taxi);
		
	}
	
	@Override
	public void begin() {
		beginElements();
		addElements();
		getControl().had.pullJsonD();
		getControl().had.pullJsonC();
		getControl().had.pullJsonT();
		getControl().had.pullJsonS();
		
	}

	private void addElements() {
		add(estado, BorderLayout.WEST);
		add(rutas, BorderLayout.EAST);
		
	}

	private void beginElements() {
		estado=new Estado(this);
		rutas=new Rutas(this);
		
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
		this.control = control;
		
	}

	@Override
	public String[] readInput(String Option) {
		switch (Option) {
		case ActionsControll.CANCEL_D:
			 cancel();
			 break;
		case ActionsControll.END:
			return loadfin();
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
		int pos=getControl().had.findServicio(taxi);
		if(pos!=-1){
		String horaI=getControl().had.getServicios().get(pos).getHoraInicio();
		Calendar calendario=Calendar.getInstance();
		hora=calendario.get(Calendar.HOUR_OF_DAY);
		minutos=calendario.get(Calendar.MINUTE);
		segundos=calendario.get(Calendar.SECOND);
		String horaF=(hora+":"+minutos+":"+segundos);
		int second=calcSegundos(horaI, horaF);
		int driver=findDis(taxi);
		int recorrido=getControl().had.getDrivers().get(driver).getSecods();
		System.out.println(recorrido+"------>"+second);
		if((recorrido-second)>10){
			getControl().had.cancelServicio(taxi);
			int posT=getControl().had.findTaxi(taxi);
			getControl().had.getTaxis().get(posT).setState(true);
			JOptionPane.showMessageDialog(null, "Su servicio se ha cancelado con exito");
		}else{
			JOptionPane.showMessageDialog(null, "Lo sentimos su servicio esta a menos de 10 segundos de distancia", "Error", JOptionPane.ERROR_MESSAGE);		

		}
		}else{
			noExiste();
		}
		
	}

	
	private int findDis(String placa){
		for (int i = 0; i < getControl().had.getDrivers().size(); i++) {
			if(getControl().had.getDrivers().get(i).getTaxi().equals(placa)){
				return i;
			}
		}
		return -1;
	}
	
	private void noExiste(){
		JOptionPane.showMessageDialog(null, "Lo sentimos no hay un servicio", "Error", JOptionPane.ERROR_MESSAGE);		

	}


	private String[] loadfin() {
		String horaFin = null,placa = null;
		if(estado.getEstado().getSelectedItem().toString().equals("Disponible")){
			int hora,minutos,segundos;
			Calendar calendario=Calendar.getInstance();
			hora=calendario.get(Calendar.HOUR_OF_DAY);
			minutos=calendario.get(Calendar.MINUTE);
			segundos=calendario.get(Calendar.SECOND);
			horaFin=(hora+":"+minutos+":"+segundos);
			placa=taxi;
			if(getControl().had.findServicio(placa)!=-1){
			return new String[] {horaFin,placa};
			}else{
				finalizo();
			}
		}else{
			
		}
		
		return null;
	}
	
	public void finalizo(){
		JOptionPane.showMessageDialog(null, "Este servicio ya finalizo", "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void writeOutput(String Option, String[] Output, boolean state) {
		switch (Option) {
		case ActionsControll.END:
			if(state) {
				JOptionPane.showMessageDialog(null, "Su servicio se ha Terminado");
				llenarTabla(getControl().had.getServicios(), taxi);

			}else{
				finalizo();
				
			}
			break;
		}
		
	}

	public ControlTaxi getControl() {
		return control;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		getControl().had.pushJsonD();
		getControl().had.pushJsonT();
		getControl().had.pushJsonS();
		change();	
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		
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
	public void llenarTabla(ArrayList<Serivicio> arrayList,String plac){
		DefaultTableModel dtm = rutas.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < getControl().had.getServicios().size(); i++) {
			if(getControl().had.getServicios().get(i).getTaxi().equals(taxi)){
				int pos=getControl().had.findTaxi(taxi);
				if(getControl().had.getTaxis().get(pos).isState()==true){
					estado.getEstado().setSelectedItem("Disponible");	
					estado.getCliente().setSelected(false);
					estado.getLibre().setSelected(true);
				}else{
					estado.getEstado().setSelectedItem("No Disponible");
					estado.getCliente().setSelected(true);
					estado.getLibre().setSelected(false);
				}
				String Cliente=getControl().had.getServicios().get(i).getCliente();
				String Inicio=getControl().had.getServicios().get(i).getHoraInicio();
				String Fin=getControl().had.getServicios().get(i).getHoraFin();
				String Tiempo=String.valueOf(getControl().had.getServicios().get(i).getTiempoRec());
				String Total=String.valueOf(getControl().had.getServicios().get(i).getCostoTotal());
				Object[] row= new Object[]{Cliente,Inicio,Fin,Tiempo,Total};
				dtm.addRow(row);
			}else{

				
			}
		}
	}
	

}
