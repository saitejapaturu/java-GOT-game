package model;

public class Pieces { 
	
	// fields
	private String color;
	private String type;
	//private int row;				Removed row and column fields since they are not needed here - Jerald
	//private int column;

	// constructors

	public Pieces(String color, String type) {
			
		this.color  = color;
		this.type   = type;
		//this.row	= row;				
		//this.column = column;
		
	}

	public String getColor() {
		return this.color;
	}

	
	public String getType() {
		return this.type;
	}

	
	//public int getRow() {
		//return this.row;
	//}

	
	//public int getColumn() {
		//return this.column;
	//}

	
	public String toString() {
		return this.type.substring(0, 1);
	}

}