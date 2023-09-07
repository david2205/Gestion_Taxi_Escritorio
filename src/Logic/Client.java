package Logic;

import java.util.GregorianCalendar;

public class Client {
	private String name;
	private String lastName;
	private GregorianCalendar dateBirth;
	private long identification;
	private String user;
	private String pasword;
	
	
	public Client(String name, String lastName, GregorianCalendar dateBirth, long identification, String user,
			String pasword) {
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.identification = identification;
		this.user = user;
		this.pasword = pasword;
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
	public long getIdentification() {
		return identification;
	}
	public void setIdentification(long identification) {
		this.identification = identification;
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
	
	
}
