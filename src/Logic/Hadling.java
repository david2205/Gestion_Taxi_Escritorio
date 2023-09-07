package Logic;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import Persistence.FileClient;
import Persistence.FileDriver;
import Persistence.FileServicio;
import Persistence.FileTaxi;

public class Hadling {
	ArrayList<Taxi> taxis;
	ArrayList<Driver> drivers;
	ArrayList<Client> clients;
	ArrayList<Serivicio> servicios;
	private FileDriver fileD;
	private FileClient fileC;
	private FileTaxi fileT;
	private FileServicio fileS;
	
	public Hadling(){
		taxis=new ArrayList<>();
		drivers=new ArrayList<>();
		clients=new ArrayList<>();
		servicios=new ArrayList<>();
	}
	
	public void pushJsonS(){
		fileS = new FileServicio();
		fileS.setPathFile("Resources/files/");
		fileS.setNameFile("servicios.json");
		fileS.openFile();
		try {
			fileS.pushJson(servicios);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pullJsonS(){
		fileS = new FileServicio();
		fileS.setPathFile("Resources/files/");
		fileS.setNameFile("servicios.json");
		fileS.openFile();
		try {
			servicios = fileS.pullJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void pushJsonC(){
		fileC = new FileClient();
		fileC.setPathFile("Resources/files/");
		fileC.setNameFile("clients.json");
		fileC.openFile();
		try {
			fileC.pushJson(clients);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pullJsonC(){
		fileC = new FileClient();
		fileC.setPathFile("Resources/files/");
		fileC.setNameFile("clients.json");
		fileC.openFile();
		try {
			clients = fileC.pullJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pushJsonT(){
		fileT = new FileTaxi();
		fileT.setPathFile("Resources/files/");
		fileT.setNameFile("taxis.json");
		fileT.openFile();
		try {
			fileT.pushJson(taxis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pullJsonT(){
		fileT = new FileTaxi();
		fileT.setPathFile("Resources/files/");
		fileT.setNameFile("taxis.json");
		fileT.openFile();
		try {
			taxis = fileT.pullJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pushJsonD(){
		fileD = new FileDriver();
		fileD.setPathFile("Resources/files/");
		fileD.setNameFile("drivers.json");
		fileD.openFile();
		try {
			fileD.pushJson(drivers);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pullJsonD(){
		fileD = new FileDriver();
		fileD.setPathFile("Resources/files/");
		fileD.setNameFile("drivers.json");
		fileD.openFile();
		try {
			drivers = fileD.pullJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean AsigTaxi(String user,String plate){
		int pos=findDriver(user);
		if(pos!=-1){
			if(findTaxi(plate)!=-1){
				for (int i = 0; i < drivers.size(); i++) {
					Driver driver=new Driver(drivers.get(pos).getName(), drivers.get(pos).getLastName(), drivers.get(pos).getDateBirth(), drivers.get(pos).getCellMobile(), drivers.get(pos).getAddress(), drivers.get(pos).getUser(), drivers.get(pos).getPasword(), plate);
					drivers.remove(pos);
					drivers.add(driver);
					return true;
				}
			}
			
		}
		return false;
	}
	
	public boolean confirmClient(String user,String pasword){
		int pos=findClient(user);
		if(pos!=-1){
			if(clients.get(pos).getPasword().equals(pasword)){
			return true;
			}
		}
			return false;
		
		
	}
	public boolean confirmDriver(String user,String pasword){
		int pos=findDriver(user);
		if(pos!=-1){
			if(drivers.get(pos).getPasword().equals(pasword)){
			return true;
			}
		}
			return false;
		}
		
	
	
	
	public int findTaxi(String id){
		for (int i = 0; i < taxis.size(); i++) {
			if(taxis.get(i).getPlate().equals(id)){
				return i;
			}
			
		}
		return -1;
	}
	
	public boolean addTaxi(String brand, int model, String plate, int valor, boolean luggage,boolean state){
		if(findTaxi(plate)==-1){
			taxis.add(new Taxi(brand, model, plate, valor, luggage,state));
			return true;
		}
		return false;
	}

	public boolean delTaxi(String id){
		if(findTaxi(id)!=-1){
			taxis.remove(findTaxi(id));
			return true;
		}
		return false;
	}
	
	public boolean updateTaxi(String brand, int model, String plate, int numStall, boolean luggage,boolean state){
		if(findTaxi(plate)!=-1){
			taxis.remove(findTaxi(plate));
			taxis.add(new Taxi(brand, model, plate, numStall, luggage,state));
			return true;
		}
		return false;
	}
	
	public int findDriver(String id){
		for (int i = 0; i < drivers.size(); i++) {
			if(drivers.get(i).getUser().equals(id)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean addDriver(String name, String lastName, GregorianCalendar dateBirth, long cellMobile, String address,
			String user, String pasword,String Taxi){
		if(findDriver(user)==-1){
			drivers.add(new Driver(name, lastName, dateBirth, cellMobile, address, user, pasword,Taxi));
			return true;
		}
		return false;
	}
	
	public boolean delDriver(String id){
		if(findDriver(id)!=-1){
			drivers.remove(findDriver(id));
			return true;
		}
		return false;
	}
	
	public boolean updateDriver(String name, String lastName, long cellMobile, String address,
			String user, String pasword,String Taxi){
			if(findDriver(user)!=-1){	
			GregorianCalendar dateBirth	=drivers.get(findDriver(user)).getDateBirth();
			drivers.remove(findDriver(user));
			drivers.add(new Driver(name, lastName,dateBirth, cellMobile, address, user, pasword,Taxi));
			return true;
		}
		return false;
	}
	
	public int findClient(String id){
		for (int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getUser().equals(id)){
				return i;
			}
		}
		return -1;
	}
	
	public boolean addClient(String name, String lastName, GregorianCalendar dateBirth, long identification, String user,
			String pasword){
		if(findClient(user)==-1){
			clients.add(new Client(name, lastName, dateBirth, identification, user, pasword));
			return true;
		}
		return false;
	}
	
	public boolean delClient(String id){
		if(findClient(id)!=-1){
			clients.remove(findClient(id));
			return true;
		}
		return false;
	}
	
	public boolean updateClient(String name, String lastName, long identification, String user,
			String pasword){
		if (findClient(user)!=-1) {
			clients.remove(findClient(user));
			clients.add(new Client(name, lastName, clients.get(findClient(user)).getDateBirth(), identification, user, pasword));
			return true;
		}
		return false;
		
	}
	
	public int findServicio(String taxi){
		for (int i = 0; i < servicios.size(); i++) {
			if(servicios.get(i).getTaxi().equals(taxi)){
				if(servicios.get(i).getHoraFin().equals("POR DETERMINAR")){
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean InicioSerivio(String horaInicio, String cliente, String taxi){
		servicios.add(new Serivicio(horaInicio, "POR DETERMINAR", cliente, 0, 0, taxi));
		return true;
	}
	
	public boolean FinalizarServicio(String horaFin, int tiempoRec, double costoTotal,String taxi){
		int pos=findServicio(taxi);
		if(pos!=-1){
		Serivicio servicio=new Serivicio(servicios.get(pos).getHoraInicio(), horaFin, servicios.get(pos).getCliente(), tiempoRec, costoTotal, taxi);
		servicios.remove(pos);
		servicios.add(servicio);
		return true;
		}
		return false;
	}
	
	public void cambiarEstado(String placa,boolean stat){
		int pos=findTaxi(placa);
		taxis.get(pos).setState(stat);
	}
	
	public int calcSegundos(String placa,String horF){
		int SegundosT = 0;
		int pos=findServicio(placa);
				String [] horaI=servicios.get(pos).getHoraInicio().split(":");
				int minutoI = Integer.parseInt(horaI[1]);
				int segundoi = Integer.parseInt(horaI[2]);
				String [] horaF=horF.split(":");
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
	
	public boolean confirmAsignacion(String taxi){
		for (int i = 0; i < drivers.size(); i++) {
			if(drivers.get(i).getTaxi().equals(taxi)){
				return false;
			}
		}
		return true;
	}
	
	public void cancelServicio(String taxi){
		int pos=findServicio(taxi);
		servicios.remove(pos);
	}
	
	public ArrayList<Taxi> getTaxis() {
		return taxis;
	}
	public void setTaxis(ArrayList<Taxi> taxis) {
		this.taxis = taxis;
	}
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Serivicio> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<Serivicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
}
