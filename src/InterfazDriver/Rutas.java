package InterfazDriver;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import InterfazClient.WindowsClient;

public class Rutas extends JPanel{
	WindowsDriver window;
	private JButton fecha;
	private JTable table;
	private DefaultTableModel modelTab;
	
	public Rutas(WindowsDriver window){
		this.window=window;	
		setLayout(new GridBagLayout());
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		TitledBorder title = BorderFactory.createTitledBorder(loweredbevel,"Rutas");
		this.setBorder(title);
		beginElements();
		addElements();
	}

	private void addElements() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx=1.0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gbc.gridx=2;
		gbc.gridy=0;
		gbc.gridwidth=2;
		add(fecha,gbc);
		
		
		gbc.gridy=2;
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridwidth=6;
		gbc.gridheight=8;
		gbc.fill=GridBagConstraints.BOTH;
		add(new JScrollPane(table),gbc);
		
	}

	private void beginElements() {
		Date fecha1 = Calendar.getInstance().getTime();
		DateFormat dateFormat =  new  SimpleDateFormat ("dd/MM/yyyy"); 
		String strDate = dateFormat.format (fecha1);  
		fecha=new JButton(strDate);
		fecha.setOpaque(true);
		fecha.setFocusPainted(false);
		fecha.setBorderPainted(false);
		fecha.setContentAreaFilled(false);
		fecha.setFont(new Font("arial",Font.BOLD,20));
		
		modelTab=new DefaultTableModel(new String[] {"Cliente","Inicio","Fin","Tiempo(s)","Total"}, 0);
		table=new JTable(modelTab);
		
	}

	public JButton getFecha() {
		return fecha;
	}

	public void setFecha(JButton fecha) {
		this.fecha = fecha;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public DefaultTableModel getModelTab() {
		return modelTab;
	}

	public void setModelTab(DefaultTableModel modelTab) {
		this.modelTab = modelTab;
	}

	
}
