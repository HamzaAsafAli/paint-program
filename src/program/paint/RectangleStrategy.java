package program.paint;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class RectangleStrategy implements Strategy {
	/**
	 * Concrete strategy to set parameters of the shape
	 */
	private MainShape currentShape;
	private PaintModel model;
	
	public RectangleStrategy(PaintModel model){
		/**
		 * Hook the current model
		 */
		this.model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e){
		/**
		 * Sets the mouseevent to the x/y
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY());
		this.model.addShape(this.currentShape);
	}
	@Override
	public void mouseReleased(MouseEvent e){
		/**
		 * Sets the mouseevent to the x/y
		 */
		this.currentShape.setX2(e.getX());this.currentShape.setY2(e.getY());
		this.model.addShape(this.currentShape);
	} 
	@Override
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill) {
		/**
		 * Sets centre value and send default params with new shape
		 */
		Point centre = new Point(e.getX(),e.getY());
		this.currentShape = new DrawRectangle(centre,0,0,color,stroke,fill);
	}

	//Not used mouseHandlers
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
}

