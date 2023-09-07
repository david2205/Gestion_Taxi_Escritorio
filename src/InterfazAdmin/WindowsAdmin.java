package InterfazAdmin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controll.ActionsControll;
import Controll.ControlTaxi;
import Logic.Client;
import Logic.Driver;
import Logic.Taxi;
import Login.Login;

public class WindowsAdmin extends JFrame implements ActionsControll{
	private JDesktopPane desktop;
	private MainMenuAdmin menu;
	private ControlTaxi controll;
	private AddDriver addD;
	private AddTaxi addT;
	public AsignTaxi asigT;
	private DelClient delC;
	private DelDriver delD;
	private DelTaxi delT;
	private UpdateClient upC;
	private UpdateDriver upD;
	private UpdateTaxi upT;
	
	
	public WindowsAdmin(){
		setTitle("Servicio De Taxis");
		setSize(new Dimension(800,600));
        setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
	}
	

	@Override
	public void begin() {
		beginElements();
		addElements();
		getControll().had.pullJsonD();
		getControll().had.pullJsonC();
		getControll().had.pullJsonT();
		addTableAddD(getControll().had.getDrivers());
		addTableAddT(getControll().had.getTaxis());
		addTableDelC(getControll().had.getClients());
		addTableDelD(getControll().had.getDrivers());
		addTableDelT(getControll().had.getTaxis());
		AddTableAsign(getControll().had.getDrivers());
	}
	
	private void beginElements() {
		desktop=new JDesktopPane();
		menu=new MainMenuAdmin(this);
		addD=new AddDriver(this,desktop);
		addT=new AddTaxi(this,desktop);
		asigT=new AsignTaxi(this,desktop);
		delC=new DelClient(this,desktop);
		delD=new DelDriver(this,desktop);
		delT=new DelTaxi(this,desktop);
		upD=new UpdateDriver(this,desktop);
		upT=new UpdateTaxi(this,desktop);
		upC=new UpdateClient(this,desktop);
	
	}

	private void addElements() {
		add(addD,BorderLayout.CENTER);
		add(addT,BorderLayout.CENTER);
		add(asigT,BorderLayout.CENTER);
		add(delC,BorderLayout.CENTER);
		add(delD,BorderLayout.CENTER);
		add(delT,BorderLayout.CENTER);
		add(upC,BorderLayout.CENTER);
		add(upT,BorderLayout.CENTER);
		add(upD,BorderLayout.CENTER);
		add(desktop,BorderLayout.CENTER);
		add(menu,BorderLayout.CENTER);
		this.setJMenuBar(menu);
	}


	@Override
	public void change() {
		controll.had.pushJsonD();
		controll.had.pushJsonC();
		controll.had.pushJsonT();
		this.setVisible(false);
		new Login().setVisible(true); 
		
	}

	@Override
	public void exit() {
		int option = JOptionPane.showConfirmDialog(null,"Desea Salir?","Salir",JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_NO_OPTION){
			controll.had.pushJsonD();
			controll.had.pushJsonC();
			controll.had.pushJsonT();
			System.exit(0);
		}
		
	}
	public void Error(){
		JOptionPane.showMessageDialog(null, "Por Favor Ingrese Los Datos Completos", "Error", JOptionPane.ERROR_MESSAGE);
	}




	@Override
	public String[] readInput(String Option) {
		switch (Option) {
		case ActionsControll.VIEW_ADD_DRIVER:
			addD.setVisible(true);
			break;
		case ActionsControll.VIEW_ADD_TAXI:
			addT.setVisible(true);
			break;	
		case ActionsControll.VIEW_DEL_CLIENT:
			delC.setVisible(true);
			break;
		case ActionsControll.VIEW_DEL_DRIVER:
			delD.setVisible(true);
			break;		
		case ActionsControll.VIEW_DEL_TAXI:
			delT.setVisible(true);
			break;
		case ActionsControll.VIEW_UPDATE_CLIENT:
			upC.setVisible(true);
			break;
		case ActionsControll.VIEW_UPDATE_DRIVER:
			upD.setVisible(true);
			break;
		case ActionsControll.VIEW_UPDATE_TAXI:
			upT.setVisible(true);
			break;
		case ActionsControll.VIEW_ASIGN:
			asigT.setVisible(true);
			break;
		case ActionsControll.ADD_DRIVER:
			return addDriver();
		case ActionsControll.DEL_DRIVER:
			return delDriver();
		case ActionsControll.UPDATE_DRIVER:
			return updateDriver();
		case ActionsControll.FIND_DRIVER:
			return finDriver();	
		case ActionsControll.ADD_TAXI:
			return addTaxi();
		case ActionsControll.DEL_TAXI:
			return delTaxi();
		case ActionsControll.UPDATE_TAXI:
			return updateTaxi();
		case ActionsControll.FIND_TAXI:
			return findTaxi();
		case ActionsControll.DEL_CLIENT:
			return delClient();
		case ActionsControll.UPDATE_CLIENT:
			return updateClient();
		case ActionsControll.FIND_CLIENT:
			return findClient();
		case ActionsControll.ASIGN:
			return asignTaxi();
		
		}
		return null;
	}

	private String[] asignTaxi() {
		String plate=asigT.getTaxi().getText();
		String driver=asigT.getDriver().getText();
		if(getControll().had.confirmAsignacion(plate)==false){
			yaAsignado();
		}else{
		return new String[] {plate,driver};
		}
		return null;
	}


	private void yaAsignado() {
		JOptionPane.showMessageDialog(null, "Lo Sentimos este taxi ya esta asignado", "Error", JOptionPane.ERROR_MESSAGE);
		
	}


	private String[] findClient() {
		String user=upC.getUser().getText();
		return new String[] {user};
	}


	private String[] updateClient() {
		String name=upC.getFirstName().getText();
		String lastName=upC.getLastName().getText();
		String identification=upC.getCedula().getText();
		String user=upC.getUser().getText();
		String password=upC.getPassword().getText();
		return new String[] {name,lastName,identification,user,password};
	}


	private String[] delClient() {
		String user=delC.getUser().getText();
		return new String[] {user};
	}


	private String[] findTaxi() {
		String plate=upT.getPlate().getText();
		return new String[] {plate};
	}


	private String[] updateTaxi() {
		String brand=upT.getBrand().getText();
		String model=upT.getModel().getValue().toString();
		String plate=upT.getPlate().getText();
		String numStall=upT.getnPuestos().getValue().toString();
		String Lugagge=upT.getpEquipaje().getSelectedItem().toString();
		return new String[] {brand,model,plate,numStall,Lugagge};
	}


	private String[] delTaxi() {
		String plate=delT.getPlate().getText();
		return new String[] {plate};
	}


	private String[] addTaxi() {
		String brand=addT.getBrand().getText();
		String model=addT.getModel().getValue().toString();
		String plate=addT.getPlate().getText();
		String numStall=addT.getnPuestos().getValue().toString();
		String Lugagge=addT.getpEquipaje().getSelectedItem().toString();
		return new String[] {brand,model,plate,numStall,Lugagge};
	}


	private String[] finDriver() {
		String user=upD.getUser().getText();
		return new String[] {user};
	}


	private String[] updateDriver() {
		String name=upD.getFirstName().getText();
		String lastName=upD.getLastName().getText();
		String cellMobile=upD.getCell().getText();
		String addres=upD.getAddres().getText();
		String user=upD.getUser().getText();
		String password=upD.getPassword().getText();
		return new String[] {name,lastName,cellMobile,addres,user,password};
	}


	private String[] delDriver() {
		String user=delD.getUser().getText();
		return new String[] {user};
	}

	private String[] addDriver() {
		String name=addD.getFirstName().getText();
		String lastName=addD.getLastName().getText();
		java.util.Date fecha=addD.getDateMake().getDate();
		DateFormat f= new SimpleDateFormat("dd/MM/yyyy");
		String dateMake=f.format(fecha);
		String [] fecha1 = dateMake.split("/");
		int year = Integer.parseInt(fecha1[2]);
		if(year>2002){
			Menor();
		}else{
		String cellMobile=addD.getCell().getText();
		String addres=addD.getAddres().getText();
		String user=addD.getUser().getText();
		String password=addD.getPassword().getText();
		return new String[] {name,lastName,dateMake,cellMobile,addres,user,password};
		}
		return null;
	}

	
	
	public void Menor(){
		JOptionPane.showMessageDialog(null, "Lo Sentimos necesitas ser Mayor de edad", "Error", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void writeOutput(String Option, String[] Output, boolean state) {
		switch (Option) {
		case ActionsControll.ADD_DRIVER:
			if(state) {
				JOptionPane.showMessageDialog(null, "Conductor añadido Con exito");
				addTableAddD(controll.had.getDrivers());
				addTableDelD(controll.had.getDrivers());
				addD.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el Conductor", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case ActionsControll.ADD_TAXI:
			if(state) {
				JOptionPane.showMessageDialog(null, "Taxi añadido Con exito");
				addTableAddT(controll.had.getTaxis());
				addTableDelT(controll.had.getTaxis());
				addT.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el Taxi", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
			
		case ActionsControll.DEL_DRIVER:
			if(state) {
				JOptionPane.showMessageDialog(null, "Conductor eliminado Con exito");
				addTableAddD(controll.had.getDrivers());
				addTableDelD(controll.had.getDrivers());
				AddTableAsign(controll.had.getDrivers());
				delD.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el Conductor", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case ActionsControll.UPDATE_DRIVER:
			if(state) {
				JOptionPane.showMessageDialog(null, "Conductor actualizado Con exito");
				upD.getFirstName().setEnabled(false);
				upD.getLastName().setEnabled(false);
				upD.getPassword().setEnabled(false);
				upD.getAddres().setEnabled(false);
				upD.getCell().setEnabled(false);
				upD.getUser().setEnabled(true);
				addTableAddD(controll.had.getDrivers());
				AddTableAsign(controll.had.getDrivers());
				addTableDelD(controll.had.getDrivers());
				upD.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido actualizado el Conductor", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
			
		case ActionsControll.FIND_DRIVER:
			if(state) {
				upD.getFirstName().setEnabled(true);
				upD.getLastName().setEnabled(true);
				upD.getPassword().setEnabled(true);
				upD.getAddres().setEnabled(true);
				upD.getCell().setEnabled(true);
				upD.getUser().setEnabled(false);
				upD.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Conductor", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case ActionsControll.DEL_TAXI:
			if(state) {
				JOptionPane.showMessageDialog(null, "Taxi eliminado Con exito");
				addTableAddT(controll.had.getTaxis());
				addTableDelT(controll.had.getTaxis());
				AddTableAsign(controll.had.getDrivers());
				delT.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el Taxi", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
			
		case ActionsControll.UPDATE_TAXI:
			if(state) {
				JOptionPane.showMessageDialog(null, "Taxi actualizado Con exito");
				upT.getPlate().setEnabled(true);
				upT.getBrand().setEnabled(false);
				upT.getnPuestos().setEnabled(false);
				upT.getModel().setEnabled(false);
				upT.getpEquipaje().setEnabled(false);
				addTableAddT(controll.had.getTaxis());
				addTableDelT(controll.had.getTaxis());
				AddTableAsign(controll.had.getDrivers());
				upT.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el Taxi", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case ActionsControll.FIND_TAXI:
			if(state) {
				upT.getPlate().setEnabled(false);
				upT.getBrand().setEnabled(true);
				upT.getnPuestos().setEnabled(true);
				upT.getModel().setEnabled(true);
				upT.getpEquipaje().setEnabled(true);
				upT.cleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Taxi", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
			
		case ActionsControll.DEL_CLIENT:
			if(state) {
				JOptionPane.showMessageDialog(null, "Cliente eliminado Con exito");
				addTableDelC(controll.had.getClients());
				AddTableAsign(controll.had.getDrivers());
				delC.CleanFields();
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case ActionsControll.UPDATE_CLIENT:
			if(state) {
				JOptionPane.showMessageDialog(null, "Cliente actualizado Con exito");
				upC.getFirstName().setEnabled(false);
				upC.getLastName().setEnabled(false);
				upC.getUser().setEnabled(false);
				upC.getPassword().setEnabled(false);
				upC.getCedula().setEnabled(true);
				addTableDelC(controll.had.getClients());
				upC.cleanFields();
				
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido actualizar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		
			
			case ActionsControll.FIND_CLIENT:
				if(state) {
					upC.getFirstName().setEnabled(true);
					upC.getLastName().setEnabled(true);
					upC.getUser().setEnabled(true);
					upC.getPassword().setEnabled(true);
					upC.getCedula().setEnabled(false);
					upC.cleanFields();
				}else{
					JOptionPane.showMessageDialog(null, "No se ha podido encontrar el cliente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case ActionsControll.ASIGN:
				if(state) {
					JOptionPane.showMessageDialog(null, "Taxi asignado Con exito");
					asigT.cleanFields();
					AddTableAsign(controll.had.getDrivers());
				}else{
					JOptionPane.showMessageDialog(null, "No se ha podido asignar el Taxi", "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
	}
	}

	
	
	public void addTableAddT(ArrayList<Taxi> arrayList){
		String Portaequipaje;
		DefaultTableModel dtm = addT.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < controll.had.getTaxis().size(); i++) {
			String Marca=controll.had.getTaxis().get(i).getBrand();
			String Modelo=String.valueOf(controll.had.getTaxis().get(i).getModel());
			String Placa=controll.had.getTaxis().get(i).getPlate();
			String Valor=String.valueOf(controll.had.getTaxis().get(i).getValor());
			if(controll.had.getTaxis().get(i).isLuggage()==true){
				Portaequipaje="SI"; 
			}else{
				Portaequipaje="NO";
			}
			Object[] row= new Object[]{Marca,Modelo,Placa,Valor,Portaequipaje};
			dtm.addRow(row);
		}
	}
	
	public void addTableDelT(ArrayList<Taxi> arrayList){
		DefaultTableModel dtm = delT.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < controll.had.getTaxis().size(); i++) {
			String Marca=controll.had.getTaxis().get(i).getBrand();
			String Modelo=String.valueOf(controll.had.getTaxis().get(i).getModel());
			String Placa=controll.had.getTaxis().get(i).getPlate();
			Object[] row= new Object[]{Placa,Modelo,Marca};
			dtm.addRow(row);
		}
	}
	
	public void addTableAddD(ArrayList<Driver> arrayList){
		DefaultTableModel dtm = addD.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < controll.had.getDrivers().size(); i++) {
			String Nombre=controll.had.getDrivers().get(i).getName();
			String Apellido=controll.had.getDrivers().get(i).getLastName();
			String Movil=String.valueOf(controll.had.getDrivers().get(i).getCellMobile());
			String Direccion=String.valueOf(controll.had.getDrivers().get(i).getAddress());
			String Usuario=controll.had.getDrivers().get(i).getUser();
			Object[] row= new Object[]{Nombre,Apellido,Movil,Direccion,Usuario};
			dtm.addRow(row);
		}
	}

	public void addTableDelD(ArrayList<Driver> arrayList){
		DefaultTableModel dtm = delD.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < controll.had.getDrivers().size(); i++) {
			String Nombre=controll.had.getDrivers().get(i).getName();
			String Movil=String.valueOf(controll.had.getDrivers().get(i).getCellMobile());
			String Usuario=controll.had.getDrivers().get(i).getUser();
			Object[] row= new Object[]{Nombre,Movil,Usuario};
			dtm.addRow(row);
		}
	}
	
	public void addTableDelC(ArrayList<Client> arrayList){
		DefaultTableModel dtm = delC.getModelTab();
		while(dtm.getRowCount()>0){
			dtm.removeRow(0);
		}
		for (int i = 0; i < controll.had.getClients().size(); i++) {
			String Nombre=controll.had.getClients().get(i).getName();
			String Cedula=String.valueOf(controll.had.getClients().get(i).getIdentification());
			String Usuario=controll.had.getClients().get(i).getUser();
			Object[] row= new Object[]{Nombre,Cedula,Usuario};
			dtm.addRow(row);
		}
	}
	
		public void AddTableAsign(ArrayList<Driver> arrayList){
			DefaultTableModel dtm = asigT.getModelTab();
			while(dtm.getRowCount()>0){
				dtm.removeRow(0);
			}
			for (int i = 0; i < controll.had.getDrivers().size(); i++) {
				if(controll.had.getDrivers().get(i).getTaxi().equals("NO ASIGNADO")){
					
				}else{
					String Placa=controll.had.getDrivers().get(i).getTaxi();
					String Conductor=controll.had.getDrivers().get(i).getName();
					String Telefono=String.valueOf(controll.had.getDrivers().get(i).getCellMobile());
					Object[] row= new Object[]{Placa,Conductor,Telefono};
					dtm.addRow(row);
				}
			}
		}
	
	public ControlTaxi getControll() {
		return controll;
	}
	@Override
	public void setControll(ControlTaxi control) {
		this.controll=control;
		
	}


	
}
