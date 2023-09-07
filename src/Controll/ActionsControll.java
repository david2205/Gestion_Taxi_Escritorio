package Controll;

public interface ActionsControll {
	
	String VIEW_ADD_TAXI="Ver Añadir Taxi";
	String VIEW_DEL_TAXI="Ver Eliminar Taxi";
	String VIEW_UPDATE_TAXI="Ver Actualizar Taxi";
	String VIEW_ADD_DRIVER="Ver añadir Conductor";
	String VIEW_DEL_DRIVER="Ver Eliminar Conductor";
	String VIEW_UPDATE_DRIVER="Ver Acturlizar Conductor";
	String ADD_TAXI="Añadir Taxi";
	String DEL_TAXI="Eliminar Taxi";
	String UPDATE_TAXI="Actualizar Taxi";
	String ADD_DRIVER="añadir Conductor";
	String DEL_DRIVER="Eliminar Conductor";
	String UPDATE_DRIVER="Acturlizar Conductor";
	String DEL_CLIENT="Eliminar Cliente";
	String UPDATE_CLIENT="Actualizar Cliente";
	String EXIT="Salir";
	String CHANGE_USER="Cambiar Usuario";
	String VIEW_ASIGN="Ver Asignar";
	String ASIGN="Asignar";
	String VIEW_UPDATE_CLIENT="Ver Actualizar Cliente";
	String VIEW_DEL_CLIENT="Ver Eliminar Cliente";
	String FIND_CLIENT="Buscar Cliente";
	String FIND_TAXI="Buscar Taxi";
	String FIND_DRIVER="Buscar Conductor";
	String REGISTRER="Registrar Cliente";
	String APPLY="Solicitar Servicio";
	String END="Terminar Serivicio";
	String CONFIRM_D="Confirmar estado";
	String END_S="Terminar Serivicio Cliente";
	String CANCEL="Cancelar Servicio";
	String CANCEL_D="Cancelar Servicio-Conductor";
	
	
	public void begin();
	 
	 public void change();
	 
	 public void exit();
	 
	 public void setControll(ControlTaxi control);
	 
	 String [] readInput(String Option);
	 
	 void writeOutput(String Option, String[] Output,boolean state);

}
