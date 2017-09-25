package program.paint;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class CircleStrategy implements Strategy {
	/**
	 * Circle Strategy is a concrete strategy, that takes in the blueprint methods of Strategy
	 * These take in the mousehandle events from PainPanel and used them to create and define a shapes parameters
	 * 
	 */
	private MainShape currentShape; //Reference to Abstract Class of all shapes
	private PaintModel model; //Reference to the paintmodel
	
	public CircleStrategy(PaintModel model){
		/**
		 * Constructor for circle strategy which makes the current model, so we can add shapes to an arraylist
		 * 
		 * @Params model - The paintmodel that holds the arrays of shapes
		 */
		this.model = model;
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		/**
		 * Default mousehandle method, where it reads the mouse dragged events
		 * 
		 * @Params e - A mouseevent that takes in where the mouse is dragged. Used to set the current x and y spot
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY()); //The mainshape sets its second x and y values to where mouseevent is
		this.model.addShape(this.currentShape); //Add the shape to the model array
	}
	@Override
	public void mouseReleased(MouseEvent e){
		/**
		 * Default mousehandle method, where it reads the mouse released events
		 * 
		 * @Param e - Mouseevent that takes in where the mouse is released. Used to set the final x and y values
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY()); //Sets the x and y values of the shape
		this.model.addShape(this.currentShape);//Adds it to model array
	} 
	@Override
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill) {
		/**
		 * Default mousehandle method, where it reads the mouse pressed at location. Used to create a default shape with centre point
		 * 
		 * @Param e - Used to create a centre point of shape
		 * @Param color - color of the shape
		 * @Param stroke - stroke of the shape
		 * @Param fill - is it filled or no? (Solid or empty)
		 */
		Point centre = new Point(e.getX(),e.getY()); //We create a point so the shape can take it in 
		this.currentShape = new DrawCircle(centre,0,0,color,stroke,fill); //Create a shape with default parameters and a given point
	}
	//Unused MouseHandles
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
}

