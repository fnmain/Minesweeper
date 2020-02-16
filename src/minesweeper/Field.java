package minesweeper;

import java.util.ArrayList;

public class Field {
	private int width;
	private int height;
	private Cell[][] field;
	
	public Field(int width, int height) {
		this.width = width;
		this.height = height;
		field = new Cell[height][width];
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void place(int row, int col, Cell c) {
		field[row][col] = c;
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	public ArrayList<Cell> getNeighbour(int row, int col) {
		ArrayList<Cell> ret = new ArrayList<Cell>();
		for (int r = Math.max(0, row-1); r <= Math.min(row+1, height-1); r++) {
			for (int c = Math.max(0, col-1); c <= Math.min(col+1, width-1); c++) {
				if (!(r == row && c == col)) 
					ret.add(field[r][c]);
			}
		}
		return ret;
	}
}
