package com.pack;

import java.util.ArrayList;

public class Ticket {
	String tname;
	String from;
	String to;
	String clas;
	String date;
	ArrayList<Passenger> tl;

	public Ticket(String tname, String from, String to, String clas, String date) {
		this.tname = tname;
		this.from = from;
		this.to = to;
		this.clas = clas;
		this.date = date;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<Passenger> getTl() {
		return tl;
	}

	public void setTl(ArrayList<Passenger> tl) {
		this.tl = tl;
	}

	public void setDate(String date) {
		this.date = date;
	}

}