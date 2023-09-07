package Logic;

import java.util.GregorianCalendar;

public class Driver {
	private String name;
	private String lastName;
	private GregorianCalendar dateBirth;
	private long cellMobile;
	private String address;
	private String user;
	private String pasword;
	private String Taxi;
	private int secods=(int) Math.floor(Math.random()*30+10);
	
	
	public Driver(String name, String lastName, GregorianCalendar dateBirth, long cellMobile, String address,
			String user, String pasword,String Taxi) {
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.cellMobile = cellMobile;
		this.address = address;
		this.user = user;
		this.pasword = pasword;
		this.Taxi=Taxi;
		this.secods=secods;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public GregorianCalendar getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(GregorianCalendar dateBirth) {
		this.dateBirth = dateBirth;
	}
	public long getCellMobile() {
		return cellMobile;
	}
	public void setCellMobile(long cellMobile) {
		this.cellMobile = cellMobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getTaxi() {
		return Taxi;
	}
	public void setTaxi(String taxi) {
		Taxi = taxi;
	}
	public int getSecods() {
		return secods;
	}
	public void setSecods(int secods) {
		this.secods = secods;
	}
	
	
	
}
