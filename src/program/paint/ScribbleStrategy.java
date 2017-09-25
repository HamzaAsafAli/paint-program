package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class ScribbleStrategy implements Strategy {
	/**
	 * Concrete strategy to make scribbles on the canvas
	 */
	private MainShape currentShape;
	private PaintModel model;
		
	public ScribbleStrategy(PaintModel model){
		/**
		 * Hook the model
		 */
		this.model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e){
		/**
		 * Adds the point to a point arraylist
		 */
	  Point point = new Point(e.getX(),e.getY());
	  this.currentShape.addPointToList(point);
	  this.model.addShape(this.currentShape);

	}

	@Override
	public void mouseReleased(MouseEvent e){
		/**
		 * Adds point to a point arraylist
		 */
	  Point point = new Point(e.getX(),e.getY());
      this.currentShape.addPointToList(point);
	}

	@Override
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill) {
		/**
		 * Create a new scribble with default params
		 */
		Point point = new Point(e.getX(),e.getY());
		this.currentShape = new DrawScribble(point,0,0,color,stroke,fill);
		this.model.addShape(this.currentShape);
	}

	//Not used MouseHandlers
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
}
