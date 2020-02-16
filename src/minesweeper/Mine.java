package minesweeper;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Mine {
	public static boolean show_hidden = false;
	private static final int WIDTH = 20;
	private static final int HEIGHT = 20;
	private static final int numMines = 8;
	private static final int kMine = 20;
	private static Field field = new Field(WIDTH, HEIGHT);
	
	public static void main(String[] args) {
		for (int row = 0; row < field.getHeight(); row++) {
			for (int col = 0; col < field.getWidth(); col++) {
				field.place(row, col, new Cell());
			}
		}
		
		int minesPlaced = 0;
		while (minesPlaced < numMines) {
			int row = (int) (Math.random()*field.getHeight());
			int col = (int) (Math.random()*field.getWidth());
			if (field.get(row, col).getValue() == kMine) {
				continue;
			}
			minesPlaced++;
			field.place(row, col, new Cell(kMine));
			for (Cell cell : field.getNeighbour(row, col)) {
				if (cell.getValue() != kMine)
					cell.increase();
			}
		}
		
		View view = new View(field);
		JFrame frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
		
		
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row = e.getY() / View.GRID_SIZE-1;
				int col = e.getX() / View.GRID_SIZE;
				System.out.println("["+row+"]"+"["+col+"]");
				onClick(row, col);
				frame.repaint();
			}
		});
		
	}
	
	public static boolean onClick(int row, int col) {
		if (row < 0 || row >= field.getHeight() || col < 0 || col >= field.getWidth()) {
			return false;
		}
		if (field.get(row, col).isVisible()) {
			return false;
		}
		field.get(row, col).setVisible(true);
		if (field.get(row, col).getValue() == kMine) {
			System.out.println("BOOM!");
			return true;
		}
		if (field.get(row, col).getValue() != 0) { return false; }
		onClick(row - 1, col);
	    onClick(row + 1, col);
	    onClick(row, col - 1);
	    onClick(row, col + 1);
		return false;
	}

}
