package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DrawSquare extends MainShape implements DrawingCommands {
	/**
	 * Concrete command that allows user to create a square
	 */
	public DrawSquare(){
	}
	
	public DrawSquare(Point centre, int x2, int y2, Color color, Stroke stroke, Boolean fill){
		/**
		 * Constructor that makes a square upon called
		 * 
		 * @Param centre - a point from mouseclick
		 * @Param x2 - Next x value
		 * @Param y2 - Next y value
		 * @Param color - Color of shape
		 * @Param stroke - stroke of shape
		 * @Param fill - If its solid or empty
		 */
		super(centre,x2,y2,color, stroke,fill); //Send to mainShape
	}
	
	@Override
	public void execute(Graphics g) {
	/**
	 * From command, which allows user to create square with the given recipe
	 */
	Graphics2D g2d = (Graphics2D) g;
		
	g.setColor(getColor());
	g2d.setStroke(getStroke());
	if(getFill()){
		g.fillRect(getCentre().getX(), getCentre().getY(),getLength(), getLength()); 
	}else{
	g.drawRect(getCentre().getX(), getCentre().getY(),getLength(), getLength());
	}
}
}

