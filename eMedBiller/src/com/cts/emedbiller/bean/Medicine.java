package com.cts.emedbiller.bean;

public class Medicine {
	private int id;
	private String name;
	private float costPrice;
	private float sellingPrice;
	private int itemsPerStrip;
	private int strips;
	private int quantity;
	private Item item;
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medicine [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", costPrice=");
		builder.append(costPrice);
		builder.append(", sellingPrice=");
		builder.append(sellingPrice);
		builder.append(", itemsPerStrip=");
		builder.append(itemsPerStrip);
		builder.append(", strips=");
		builder.append(strips);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", item=");
		builder.append(item);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * @return the itemsPerStrip
	 */
	public int getItemsPerStrip() {
		return itemsPerStrip;
	}
	/**
	 * @param itemsPerStrip the itemsPerStrip to set
	 */
	public void setItemsPerStrip(int itemsPerStrip) {
		this.itemsPerStrip = itemsPerStrip;
	}
	/**
	 * @return the noofStrips
	 */
	public int getStrips() {
		return strips;
	}
	/**
	 * @param noofStrips the noofStrips to set
	 */
	public void setStrips(int noofStrips) {
		this.strips = noofStrips;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Medicine() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(float costPrice) {
		this.costPrice = costPrice;
	}
	public float getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
