package program.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

class ShapeChooserPanel extends JPanel implements ActionListener {
	/**
	 * Class to create all the shape choosers with images
	 * Each shape has its own action
	 */
	private View view; // So we can talk to our parent or other components of the view
	
	public ShapeChooserPanel(View view) {
		/**
		 * Hooks the current view
		 * Adds all the buttons of shapes to the current view on the left side
		 * Each shape has its own Image of what it is
		 */
		this.view=view;
		
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline", "Line" };
		this.setLayout(new GridLayout(buttonLabels.length, 1));
		for (String label : buttonLabels) {
			JButton button = new JButton();
			if (label == "Circle"){
				button.setActionCommand(label);
			 try {
				    Image img = ImageIO.read(getClass().getResource("/shapeicons/oval.png"));
				    button.setIcon(new ImageIcon(img));
				  } catch (IOException ex) {
				  }
			}
			else if (label == "Rectangle"){
				button.setActionCommand(label);
				 try {
					    Image img = ImageIO.read(getClass().getResource("/shapeicons/rectangle.png"));
					    button.setIcon(new ImageIcon(img));
					  } catch (IOException ex) {
					  }
				}
			else if (label == "Square"){
				button.setActionCommand(label);
				 try {
					    Image img = ImageIO.read(getClass().getResource("/shapeicons/square.png"));
					    button.setIcon(new ImageIcon(img));
					  } catch (IOException ex) {
					  }
				}
			else if (label == "Squiggle"){
				button.setActionCommand(label);
				 try {
					    Image img = ImageIO.read(getClass().getResource("/shapeicons/scribble.png"));
					    button.setIcon(new ImageIcon(img));
					  } catch (IOException ex) {
					  }
				}
			else if (label == "Polyline"){
				button.setActionCommand(label);
				 try {
					    Image img = ImageIO.read(getClass().getResource("/shapeicons/polyline.png"));
					    button.setIcon(new ImageIcon(img));
					  } catch (IOException ex) {
					  }
				}
			else if(label == "Line"){
				button.setActionCommand(label);
				try {
					Image img = ImageIO.read(getClass().getResource("/shapeicons/line.png"));
					button.setIcon(new ImageIcon(img));
				} catch(IOException ex) {
				}
			}
			this.add(button);
			button.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * Sets the mode of the view depending on what button is clicked, so whatever button is clicked that shape is selected
		 * and will be drawn
		 */
		this.view.getPaintPanel().setMode(e.getActionCommand());
		System.out.println(e.getActionCommand());
	}

	
}
