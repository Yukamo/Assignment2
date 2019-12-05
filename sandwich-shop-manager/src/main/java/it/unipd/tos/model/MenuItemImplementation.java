////////////////////////////////////////////////////////////////////
// [Enrico] [Galdeman] [1169549]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItemImplementation implements MenuItem{
	private String name;
	private ItemType type;
	private double price;
	public MenuItemImplementation(String name, ItemType type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
	}
	public String getName() {return name;}
	public ItemType getType() {return type;}
	public double getPrice() {return price;}
}