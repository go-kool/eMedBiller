package com.cts.emedbiller.bean;

public class Item {
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	private int id;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Item(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
