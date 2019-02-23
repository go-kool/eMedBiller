package com.cts.emedbiller.bean;

import java.util.Date;

public class Order {
	private int id;
	private Date date;
	private String patientName;
	private String doctorName;
	private Float price;
	private User user;
	


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", patientName=");
		builder.append(patientName);
		builder.append(", doctorName=");
		builder.append(doctorName);
		builder.append(", price=");
		builder.append(price);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public java.util.Date getDate() {
		return date;
	}


	public void setDate(java.util.Date date) {
		this.date = date;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Order() {

	}

}
