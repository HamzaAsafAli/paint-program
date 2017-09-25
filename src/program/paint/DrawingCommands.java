package program.paint;

import java.awt.Graphics;

public interface DrawingCommands {
	/**
	 * Interface of Command,
	 * each draw class, implements this class which allows it to draw its own shape
	 * 
	 */
	public void execute(Graphics g); //Is the drawing method
}
