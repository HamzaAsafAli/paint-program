package program.paint;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public interface Strategy {
	/**
	 * Default strategies, create the blueprint for each concrete strategy
	 * These pass the mouseevent from paintpanel to each concrete strategy and uses the mouseevents to sets each shape parameters
	 * 
	 */
	public void mouseDragged(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);
	public void mouseClicked(MouseEvent e);
	
}
