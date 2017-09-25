package program.paint;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class LineStrategy implements Strategy {
	/**
	 * A concrete strategy for line, that takes in mousehandles to set the shapes parameters
	 */
	private MainShape currentShape; //An abstract class for all shapes
	private PaintModel model; //Current model
	
	public LineStrategy(PaintModel model){
		/**
		 * Constructor to set the current model
		 */
		this.model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e){
		/**
		 * Default mousehandler that takes in mouseevent and sets the second x and y values, which are the future x/y
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY()); //Sets the next x and y position
		this.model.addShape(this.currentShape); //Add it to arraylist in model
	}

	@Override
	public void mouseReleased(MouseEvent e){
		/**
		 * Default mousehandle that takes mouseevent and sets x/y
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY()); //Sets the x and y in mainshape
		this.model.addShape(this.currentShape);
	}

	@Override
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill) {
		/**
		 * Default mousehandle that creates a point and takes in default params
		 * 
		 * @Param color - Color of shape
		 * @Param stroke - stroke of shape
		 * @Param fill - If its solid or empty
		 */
		Point point = new Point(e.getX(),e.getY()); //Makes a new centre point
		this.currentShape = new DrawLine(point,0,0,color,stroke,fill); //Creates a line with default params
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
}
