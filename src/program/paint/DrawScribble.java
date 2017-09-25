package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

public class DrawScribble extends MainShape implements DrawingCommands {
		
	public DrawScribble(){
		
	}
	
	public DrawScribble(Point centre, int x2, int y2, Color color, Stroke stroke, Boolean fill){
		super(centre,x2,y2,color,stroke,fill);
	}

	@Override
	public void execute(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(getColor());
		g2d.setStroke(getStroke());
		ArrayList<Point> listOfPoints = getPoints();
		for(int i=0;i<listOfPoints.size()-1; i++){
			Point p1=listOfPoints.get(i);
			Point p2=listOfPoints.get(i+1);
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
	}
}
