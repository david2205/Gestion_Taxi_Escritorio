package Controll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.table.DefaultTableModel;

import InterfazAdmin.WindowsAdmin;
import Logic.Hadling;

public class ControlTaxi implements ActionListener{
	private ActionsControll view;
	public Hadling had;
	
	public ControlTaxi(ActionsControll view){
		this.view=view;
		had=new Hadling();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case ActionsControll.VIEW_ADD_DRIVER:
			view.readInput(ActionsControll.VIEW_ADD_DRIVER);
			break;
		case ActionsControll.VIEW_ADD_TAXI:
			view.readInput(ActionsControll.VIEW_ADD_TAXI);
			break;
		case ActionsControll.VIEW_ASIGN:
			view.readInput(ActionsControll.VIEW_ASIGN);
			break;
		case ActionsControll.VIEW_DEL_CLIENT:
			view.readInput(ActionsControll.VIEW_DEL_CLIENT);
			break;		
		case ActionsControll.VIEW_DEL_DRIVER:
			view.readInput(ActionsControll.VIEW_DEL_DRIVER);
			break;
		case ActionsControll.VIEW_DEL_TAXI:
			view.readInput(ActionsControll.VIEW_DEL_TAXI);
			break;
		case ActionsControll.VIEW_UPDATE_CLIENT:
			view.readInput(ActionsControll.VIEW_UPDATE_CLIENT);
			break;
		case ActionsControll.VIEW_UPDATE_DRIVER:
			view.readInput(ActionsControll.VIEW_UPDATE_DRIVER);
			break;
		case ActionsControll.VIEW_UPDATE_TAXI:
			view.readInput(ActionsControll.VIEW_UPDATE_TAXI);
			break;
		case ActionsControll.CANCEL:
			view.readInput(ActionsControll.CANCEL);
			break;
		case ActionsControll.CANCEL_D:
			view.readInput(ActionsControll.CANCEL_D);
			break;
		case ActionsControll.CHANGE_USER:
			view.change();
			break;
		case ActionsControll.EXIT:
			view.exit();
			break;
		case ActionsControll.ADD_TAXI:
			addTaxi();
			break;
		case ActionsControll.DEL_TAXI:
			delTaxi();
			break;
		case ActionsControll.UPDATE_TAXI:
			upTaxi();
			break;
		case ActionsControll.FIND_TAXI:
			findTaxi();
			break;
		case ActionsControll.ADD_DRIVER:
			addDriver();
			break;
		case ActionsControll.DEL_DRIVER:
			delDriver();
			break;
		case ActionsControll.UPDATE_DRIVER:
			upDriver();
			break;
		case ActionsControll.FIND_DRIVER:
			findDriver();
			break;
		case ActionsControll.DEL_CLIENT:
			delClient();
			break;
		case ActionsControll.UPDATE_CLIENT:
			upClient();
			break;
		case ActionsControll.FIND_CLIENT:
			findClient();
			break;
		case ActionsControll.ASIGN:
			asignTaxi();
			break;
		case ActionsControll.REGISTRER:
			Registrer();
			break;
		case ActionsControll.APPLY:
			solicitar();
			break;
		case ActionsControll.END:
			finalizar();
			break;
		case ActionsControll.END_S:
			finalizarS();
			break;
		}
		
	}


	private void finalizarS() {
		String [] fin = view.readInput(ActionsControll.END_S);
		if(fin!=null){
			String taxi=fin[0];	
			int pos=had.findTaxi(taxi);
			if(had.getTaxis().get(pos).isState()==false){
				view.writeOutput(ActionsControll.END_S, new String[]{""}, true);
			}else{
				view.writeOutput(ActionsControll.END_S, new String[]{""}, false);
			}
		}
	}


	private void finalizar() {
		String [] fin = view.readInput(ActionsControll.END);
		if(fin!=null){
			String horaF=fin[0];
			String taxi=fin[1];	
			int segTot=had.calcSegundos(taxi, horaF);
			double valorT=(had.getTaxis().get(had.findTaxi(taxi)).getValor()*segTot);
			if(had.FinalizarServicio(horaF, segTot, valorT, taxi)==true ){
				view.writeOutput(ActionsControll.END, new String[]{taxi}, true);
				had.cambiarEstado(taxi, true);
			}else{
				view .writeOutput(ActionsControll.END, new String[]{taxi}, false);
			}
		}
		}
		
	private void solicitar() {
		String [] sol = view.readInput(ActionsControll.APPLY);
		if(sol!=null){
			String horaI=sol[0];
			String cliente=sol[1];	
			String taxi=sol[2];
			if(had.InicioSerivio(horaI, cliente, taxi)==true && had.findTaxi(taxi)!=-1){
				view.writeOutput(ActionsControll.APPLY, new String[]{taxi}, true);
				had.cambiarEstado(taxi, false);
			}else{
				view .writeOutput(ActionsControll.APPLY, new String[]{taxi}, false);
			}
		}
	}


	private void Registrer() {
		String [] registro = view.readInput(ActionsControll.REGISTRER);
		if(registro!=null){
			String name=registro[0];
			String lastName= registro[1];			
			String [] fecha1 = registro[2].split("/");
			int day = Integer.parseInt(fecha1[0]);
			int month = Integer.parseInt(fecha1[1]);
			int year = Integer.parseInt(fecha1[2]);
			GregorianCalendar dateBirth = new GregorianCalendar(year,month,day);
			long identification= Long.parseLong( registro[3]);
			String user=registro[4];
			String pasword=registro[5];
			if(had.addClient(name, lastName, dateBirth, identification, user, pasword)==true){
				view.writeOutput(ActionsControll.REGISTRER, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.REGISTRER, new String[]{user}, false);
			}
	}
	}


	private void asignTaxi() {
		String [] taxi = view.readInput(ActionsControll.ASIGN);
		if(taxi!=null){
			String plate=taxi[0];
			String driver=taxi[1];
			if(had.AsigTaxi(driver, plate)==true){
				view.writeOutput(ActionsControll.ASIGN, new String[]{plate}, true);
					
			}else{
				view .writeOutput(ActionsControll.ASIGN, new String[]{plate}, false);
			}
		}
		
	}


	private void findClient() {
		String [] client = view.readInput(ActionsControll.FIND_CLIENT);
		if(client!=null){
			String user=client[0];
			if(had.findClient(user)!=-1){
				view.writeOutput(ActionsControll.FIND_CLIENT, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.FIND_CLIENT, new String[]{user}, false);
			}
		}
		
	}


	private void upClient() {
		String [] client = view.readInput(ActionsControll.UPDATE_CLIENT);
		if(client!=null){
			String name=client[0];
			String lastName=client[1];
			long identification=Long.parseLong(client[2]);
			String user=client[3];
			String password=client[4];
			if(had.updateClient(name, lastName,  identification, user, password)==true){
				view.writeOutput(ActionsControll.UPDATE_CLIENT, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.UPDATE_CLIENT, new String[]{user}, false);
			
		}
		}
		
	}


	private void delClient() {
		String [] client = view.readInput(ActionsControll.DEL_CLIENT);
		if(client!=null){
			String user=client[0];
			if(had.delClient(user)==true){
				view.writeOutput(ActionsControll.DEL_CLIENT, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.DEL_CLIENT, new String[]{user}, false);
			}
		}
		
	}


	private void findDriver() {
		String [] driver = view.readInput(ActionsControll.FIND_DRIVER);
		if(driver!=null){
			String user=driver[0];
			if(had.findDriver(user)!=-1){
				view.writeOutput(ActionsControll.FIND_DRIVER, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.FIND_DRIVER, new String[]{user}, false);
			}
		}
		
	}


	private void upDriver() {
		String [] driver = view.readInput(ActionsControll.UPDATE_DRIVER);
		if(driver!=null){
			String name=driver[0];
			String lastName=driver[1];
			long cellMobile=Long.parseLong(driver[2]);
			String addres=driver[3];
			String user=driver[4];
			String password=driver[5];
			if(had.updateDriver(name, lastName, cellMobile, addres, user, password, "")==true){
				view.writeOutput(ActionsControll.UPDATE_DRIVER, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.UPDATE_DRIVER, new String[]{user}, false);
			}
			
		}
		
	}


	private void delDriver() {
		String [] driver = view.readInput(ActionsControll.DEL_DRIVER);
		if(driver!=null){
			String user=driver[0];
			if(had.delDriver(user)==true){
				view.writeOutput(ActionsControll.DEL_DRIVER, new String[]{user}, true);
			}else{
				view .writeOutput(ActionsControll.DEL_DRIVER, new String[]{user}, false);
			}
		}
		
	}


	private void addDriver() {
		String [] driver = view.readInput(ActionsControll.ADD_DRIVER);
		if(driver!=null){
			String name=driver[0];
			String lastName=driver[1];
			String [] fecha1 = driver[2].split("/");
			int day = Integer.parseInt(fecha1[0]);
			int month = Integer.parseInt(fecha1[1]);
			int year = Integer.parseInt(fecha1[2]);
			GregorianCalendar makeDate = new GregorianCalendar(year,month,day);
			long cellMobile=Long.parseLong(driver[3]);
			String addres=driver[4];
			String user=driver[5];
			String password=driver[6];
			if(had.addDriver(name, lastName, makeDate, cellMobile, addres, user, password, "NO ASIGNADO")==true){
				view.writeOutput(ActionsControll.ADD_DRIVER, new String[]{user}, true);

			}else{
				view .writeOutput(ActionsControll.ADD_DRIVER, new String[]{user}, false);
			}
			
		}
		
	}


	private void findTaxi() {
		String [] taxi = view.readInput(ActionsControll.FIND_TAXI);
		if(taxi!=null){
			String plate=taxi[0];
			if(had.findTaxi(plate)!=-1){
				view.writeOutput(ActionsControll.FIND_TAXI, new String[]{plate}, true);
			}else{
				view .writeOutput(ActionsControll.FIND_TAXI, new String[]{plate}, false);
			}
		}
		
	}


	private void upTaxi() {
		boolean Lugagge=false;
		String [] taxi = view.readInput(ActionsControll.UPDATE_TAXI);
		if(taxi!=null){
			String brand=taxi[0];
			int model=Integer.parseInt(taxi[1]);
			String plate=taxi[2];
			int numStall=Integer.parseInt(taxi[3]);
			if(taxi[4].equals("SI")){
				Lugagge=true;
			}
			if(had.updateTaxi(brand, model, plate, numStall, Lugagge, false)==true){
				view.writeOutput(ActionsControll.UPDATE_TAXI, new String[]{plate}, true);
			}else{
				view .writeOutput(ActionsControll.UPDATE_TAXI, new String[]{plate}, false);
			}
			
		}
		
	}


	private void delTaxi() {
		String [] taxi = view.readInput(ActionsControll.DEL_TAXI);
		if(taxi!=null){
			String plate=taxi[0];
			if(had.delTaxi(plate)==true){
				view.writeOutput(ActionsControll.DEL_TAXI, new String[]{plate}, true);
			}else{
				view .writeOutput(ActionsControll.DEL_TAXI, new String[]{plate}, false);
			}
		}
		
	}


	private void addTaxi() {
		boolean Lugagge;
		String [] taxi = view.readInput(ActionsControll.ADD_TAXI);
		if(taxi!=null){
			String brand=taxi[0];
			int model=Integer.parseInt(taxi[1]);
			String plate=taxi[2];
			int numStall=Integer.parseInt(taxi[3]);
			if(taxi[4].equals("SI")){
				Lugagge=true;
			}else{
				Lugagge=false;
			}
			if(had.addTaxi(brand, model, plate, numStall, Lugagge, true)==true){
				view.writeOutput(ActionsControll.ADD_TAXI, new String[]{plate}, true);
			}else{
				view .writeOutput(ActionsControll.ADD_TAXI, new String[]{plate}, false);
			}
			
		}
	}

}
