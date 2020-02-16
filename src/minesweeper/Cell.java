package minesweeper;

public class Cell {
	private int value = 0;
	private boolean visible = false;
	
	public Cell() {}
	
	public Cell(int k) {
		value = k;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void increase() {
		value++;
	}
}
