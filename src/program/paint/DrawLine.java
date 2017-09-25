package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;


public class DrawLine extends MainShape implements DrawingCommands {
	/**
	 * DrawLine is concrete command that allows the user to draw a line
	 */
	public DrawLine(){
		
	}

	public DrawLine(Point centre, int x2, int y2, Color color, Stroke stroke, Boolean fill){
		/**
		 * This is the constructor, takes in default parameters and sends it to MainShape
		 * 
		 * @Param centre - a point from mouseclick
		 * @Param x2 - Next x value
		 * @Param y2 - Next y value
		 * @Param color - Color of shape
		 * @Param stroke - stroke of shape
		 * @Param fill - If its solid or empty
		 */
		super(centre,x2,y2,color, stroke,fill); //Send parameters to MainShape
	}
	
	@Override
	public void execute(Graphics g) {
		/**
		 * From the command, allows line to be created with the given recipe
		 */
		Graphics2D g2d = (Graphics2D) g;
	
		g.setColor(getColor());
		g2d.setStroke(getStroke());
		g.drawLine(getCentre().getX(), getCentre().getY(), getX2(), getY2());
	}
}
