////////////////////////////////////////////////////////////////////
// [Enrico] [Galdeman] [1169549]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public enum ItemType {
	Panino("PANINO"), Fritto("FRITTO"), Bevanda("BEVANDA");
	private String text;
	ItemType(String text) {
		this.text=text;
	}
	@Override
	public String toString() {
		return text;
	}
}