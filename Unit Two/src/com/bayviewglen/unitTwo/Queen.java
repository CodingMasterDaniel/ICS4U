package com.bayviewglen.unitTwo;

public class Queen {
	
	private int row;
	private int col;
	
	public Queen() {
		row = 0;
		col = 0;
	}
	
	public Queen(int x, int y) {
		row = x;
		col = y;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setRow(int x) {
		row = x;
	}
	
	public void setCol(int y) {
		col = y;		
	}
}
