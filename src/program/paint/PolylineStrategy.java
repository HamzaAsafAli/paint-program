package program.paint;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.MouseEvent;

public class PolylineStrategy implements Strategy {
	/**
	 * Not used
	 */
	private MainShape currentShape;
	private PaintModel model;
	
	public PolylineStrategy(PaintModel model){
		this.model = model;
	}

	@Override
	public void mouseDragged(MouseEvent e){
		// TODO Auto-generated method stub
		this.currentShape.addX(e.getX());this.currentShape.addY(e.getY());
		this.model.addShape(this.currentShape);
	}

	@Override
	public void mouseReleased(MouseEvent e){
		// TODO Auto-generated method stub
		this.currentShape.addX(e.getX());this.currentShape.addY(e.getY());
		this.model.addShape(this.currentShape);
	}

	@Override
	public void mousePressed(MouseEvent e, Color color, Stroke stroke, Boolean fill) {
		// TODO Auto-generated method stub
		Point point = new Point(e.getX(),e.getY());
		this.currentShape = new DrawPolyline(point,0,0,color,stroke,fill);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
