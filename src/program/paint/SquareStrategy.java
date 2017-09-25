package program.paint;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class SquareStrategy implements Strategy {
	/**
	 * Concrete square that allows user to create square and sets its parameters
	 */
	private MainShape currentShape;
	private PaintModel model;
	
	public SquareStrategy(PaintModel model){
		/**
		 * hooks the model
		 */
		this.model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e){
		/**
		 * Sets the x/y values for the square
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY());
		this.model.addShape(this.currentShape);
	}
	@Override
	public void mouseReleased(MouseEvent e){
		/**
		 * Sets the x/y values of the square
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY());
		this.model.addShape(this.currentShape);
	}
	@Override
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill) {
		/**
		 * Creates a new square with default parameters
		 */
		Point centre = new Point(e.getX(),e.getY());
		this.currentShape = new DrawSquare(centre,0,0,color,stroke,fill);
	}

	//Not used MouseHandlers
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
}

