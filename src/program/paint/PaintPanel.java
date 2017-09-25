package program.paint;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener  {
	/**
	 * PaintPanel is the core of the application
	 * Has the defualt mousehanldes and sends them to the strategies
	 * Creates the main view to wear to draw
	 * Calls the command so each shape is drawn
	 */
	private PaintModel model; 
	private View view; // So we can talk to our parent or other components of the view

	private String mode; // modifies how we interpret input (could be better?)
	
	private Color colorChosen = Color.black; //Default color
	private Stroke stroke = new BasicStroke(1); //Default stroke
	private Boolean fill = false; //Default fill...so empty
		
	public Graphics2D g2d; //Graphics

	private Strategy stratHolder; //What strategy
	private ShapeFactory shapefactory; //Factory design so user can send what shape wants to be created
	
	public PaintPanel(PaintModel model, View view){
		/**
		 * Creates a model and view in this current
		 * And sets default view options
		 */
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.mode="Squiggle"; //Sets default mode 
		
		this.model = model; 
		this.model.addObserver(this);
		
		this.view=view;
		
		shapefactory = new ShapeFactory(this.model);

	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		/**
		 * PaintComponent to used to create the graphics of the application
		 * Paints the background and runs a for loop of the arraylists of shape and draws each shape according to the execute of what shape it iterated
		 */
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; 

		ArrayList<MainShape> shapes = this.model.getShapes();
		for (int i =  0; i < shapes.size(); i++){
			shapes.get(i).execute(g); //Draws the shape with each being a separate recipe
		}
		g2d.dispose();	
	}

	@Override
	public void update(Observable o, Object arg) {
		
		this.repaint();
	}
	
	//Setters for variables that were passed from other classes
	
	public void setMode(String mode){
		this.mode=mode;
	}
	public void setFill(Boolean fill){
		this.fill=fill;
	}
	public void setColor(Color color){
		this.colorChosen = color;
	}
	public void setThickness(Stroke stroke){
		this.stroke = stroke;
	}

	
	// MouseMotionListener below
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(),e.getY()));
		}
		this.stratHolder.mouseDragged(e); //Calls the strategy mouseDragged with the mouseEvent
		}
	@Override
	public void mousePressed(MouseEvent e) {
		if(this.mode=="Squiggle"){
			this.model.resetPoints();
			}
		this.stratHolder = shapefactory.createStrategy(mode); //Whatever mode it is in, call the strategy
		this.stratHolder.mousePressed(e, colorChosen, stroke, fill); //With that strategy, call mousePressed and send those params
		}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.stratHolder.mouseReleased(e); //Call current strategy and use mouseRealsed and send the mouseEvent
		}

	//Unused MouseHandlers 
	
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
}

