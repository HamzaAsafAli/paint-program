package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DrawRectangle extends MainShape {
	/**
	 * Concrete command that allows user to create a rectangle
	 */
	public DrawRectangle(){
	}
	
	public DrawRectangle(Point centre, int x2, int y2, Color color, Stroke Stroke, Boolean fill){
		/**
		 * Constructor for rectangle
		 * 
		 * @Param centre - a point from mouseclick
		 * @Param x2 - Next x value
		 * @Param y2 - Next y value
		 * @Param color - Color of shape
		 * @Param stroke - stroke of shape
		 * @Param fill - If its solid or empty
		 */
		super(centre,x2,y2,color, Stroke,fill); //Send to MainShape
	}
	
	@Override
	public void execute(Graphics g) {
	/**
	 * From command, draws the shape with given recipe
	 */
	Graphics2D g2d = (Graphics2D) g;
		
	g.setColor(getColor());
	g2d.setStroke(getStroke());
	if(getFill()){
		g.fillRect(getCentre().getX(), getCentre().getY(),getLength(), getHeight());
	}else{
		g.drawRect(getCentre().getX(), getCentre().getY(),getLength(), getHeight());
	}
}
}
