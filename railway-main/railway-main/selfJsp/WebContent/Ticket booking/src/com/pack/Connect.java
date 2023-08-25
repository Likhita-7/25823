package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Connect {
	Connection con;

	public Connect() {
	}

	Connection meth() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48:5432/plf_training", "plf_training_admin",
				"pff123");
		return con;
	}

	// for (Passenger p : pass) {
	// System.out.println(p.getAge() + "" + p.getName() + "" + p.getGender());
	// }
	public Ticket meth3(String tlist, String from, String to, String clas, String dat, String[] nam, String[] ag,
			String[] gen) {
		ArrayList<Passenger> pass = new ArrayList<>();
		Passenger pg;
		for (int i = 0; i < nam.length; i++) {
			pg = new Passenger(nam[i], Integer.parseInt(ag[i]), gen[i]);
			pass.add(pg);
		}
		Ticket tk = new Ticket(tlist, from, to, clas, dat);
		tk.setTl(pass);
		return tk;
	}

	public void meth4() {

	}
}