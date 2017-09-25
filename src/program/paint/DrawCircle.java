package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DrawCircle extends MainShape implements DrawingCommands{
	/**
	 * DrawCircle is a concrete command, It is called in a strategy and passes its parameters to mainshape class
	 * The drawing of circle is done with the specific recipe
	 */
	public DrawCircle(){
		
	}
	
	public DrawCircle(Point centre, int x2, int y2, Color color, Stroke stroke, Boolean fill){
		/**
		 * This is the constructor, that creates the circle and sends it to the MainShape class
		 * 
		 * @Param centre - a point from mouseclick
		 * @Param x2 - Next x value
		 * @Param y2 - Next y value
		 * @Param color - Color of shape
		 * @Param stroke - stroke of shape
		 * @Param fill - If its solid or empty
		 */
		super(centre,x2,y2,color,stroke,fill); //Send to parent class which is MainShape
	}
	
	@Override
	public void execute(Graphics g) {
	/**
	 * Execute is from the command,
	 * where it executes the drawing of circle with the given recipe
	 * 
	 * @Param g - Graphics so it can use graphics methods
	 */
	Graphics2D g2d = (Graphics2D) g; //Cast g with Graphics2D
	g.setColor(getColor()); //set the color of draw with the color chosen
	g2d.setStroke(getStroke()); //set the stroke with stroke chosen
	if(getFill()){ //If the boolean was set to true, make the shape filled
		g.fillOval(getCentre().getX() - getLength(), getCentre().getY() - getLength(), 2*getLength(), 2*getLength());
	}else{ //If not then draw it empty
		g.drawOval(getCentre().getX() - getLength(), getCentre().getY() - getLength(), 2*getLength(), 2*getLength());
	}
	}
}
