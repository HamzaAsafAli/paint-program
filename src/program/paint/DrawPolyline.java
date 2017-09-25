package program.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class DrawPolyline extends MainShape implements DrawingCommands {

	public DrawPolyline(){
		}
	
	public  DrawPolyline(Point centre, int x2, int y2, Color color, Stroke stroke, Boolean fill){
		super(centre,x2,y2,color, stroke,fill);
	}
	
	@Override
	public void execute(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(getColor());
		g2d.setStroke(getStroke());
		//g.drawPolyline(xPoints, yPoints, nPoints);
	}

}
