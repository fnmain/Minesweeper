package minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class View extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int GRID_SIZE = 32;
	private Field theField;

	public View(Field field) {
		theField = field;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.white);
		for (int row = 0; row < theField.getHeight(); row++) {
			g.drawLine(0, row * GRID_SIZE, theField.getWidth() * GRID_SIZE, row * GRID_SIZE);
		}
		for (int col = 0; col < theField.getWidth(); col++) {
			g.drawLine(col * GRID_SIZE, 0, col * GRID_SIZE, theField.getHeight() * GRID_SIZE);
		}
		for (int row = 0; row < theField.getHeight(); row++) {
			for (int col = 0; col < theField.getWidth(); col++) {
				Cell cell = theField.get(row, col);
				if (cell != null) {
					g.setColor(Color.LIGHT_GRAY);
					if (cell.isVisible() || Mine.show_hidden) {
						g.drawString("" + (cell.getValue() > 0 ? cell.getValue() : " "), col*GRID_SIZE + GRID_SIZE * 1 / 4, row*GRID_SIZE + GRID_SIZE * 3 / 4);
					} else {
						g.fillRoundRect(col * GRID_SIZE + 2, row * GRID_SIZE + 2, GRID_SIZE-4, GRID_SIZE-4, 3, 3);
					}
				}
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth() * GRID_SIZE, theField.getHeight() * GRID_SIZE);
	}

}
