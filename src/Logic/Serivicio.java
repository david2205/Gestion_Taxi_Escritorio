package Logic;

import java.text.SimpleDateFormat;

public class Serivicio {

	
	private String horaInicio;
	private String horaFin;
	private String cliente;
	private int tiempoRec;
	private double costoTotal;
	private String taxi;
	
	public Serivicio(String horaInicio, String horaFin, String cliente, int tiempoRec, double costoTotal, String taxi) {
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.cliente = cliente;
		this.tiempoRec = tiempoRec;
		this.costoTotal = costoTotal;
		this.taxi = taxi;
	}

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getTiempoRec() {
		return tiempoRec;
	}
	public void setTiempoRec(int tiempoRec) {
		this.tiempoRec = tiempoRec;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public String getTaxi() {
		return taxi;
	}
	public void setTaxi(String taxi) {
		this.taxi = taxi;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	
	
	
}
