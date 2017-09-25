package program.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorPanel extends JPanel implements ActionListener{
	/**
	 * Colorpanel is a class that builds a color choose panel
	 * User is allowed to pick colors for background, drawing and shapes
	 * A full RGB dialog shows up, alongside a preview
	 * 
	 * Implement Actionlistener so each button has a action that it can perform
	 */
	private Color colorChosen; //Is the color chosen of the user that he/she wants to draw/create with
	private Color backgroundColor; //Color chosen for the background
	private View view; //The current view frame
	private PaintModel model;//The current model
		
	private JPanel panel; //To create a panel
	
	public ColorPanel(View view,PaintModel model){
	/**
	 * Colorpanel is the constructor that takes in a view and model, so we can hook up each button to the current view/model
	 */
	this.view = view;
	this.model = model;
	
	JButton button = new JButton("Paint Color Chooser"); //Button for user to choose color
	button.addActionListener(this); //Add a default action listener
	button.setActionCommand("Colors");
	JButton button2 = new JButton("Background Color"); //Button for background color
	button2.addActionListener(this);
	button2.setActionCommand("Background");
	JButton button3 = new JButton("Fill"); //Button for if user want the shape filled or empty
	button3.addActionListener(this);
	JButton button4 = new JButton("Outline"); //Button for if user want the shape just outlined
	button4.addActionListener(this);
	JButton button5 = new JButton("Clear");//Button if user wants to reset the board
	button5.addActionListener(this);
	
	this.add(button);
	this.add(button2);
	this.add(button3); //Add the buttons to the main view
	this.add(button4);
	this.add(button5);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * actionperformed is a default actionlistener method that takes in an action event
		 * Here it decides which button will do what
		 * 
		 * @Param e - Depending on what button is pressed, execute designated line
		 */
		if(e.getActionCommand() == "Colors"){
			colorChosen = JColorChooser.showDialog(panel, "Choose a color", Color.BLACK); //Open a color dialog and whatever color is pressed, assign it to colorChosen
			this.view.getPaintPanel().setColor(this.colorChosen); //Pass the colorChosen to paintpanel, where then it is used by the strategies
		}else if(e.getActionCommand() == "Background"){
			backgroundColor = JColorChooser.showDialog(panel, "Choose a background Color", Color.white); //Open color dialog
			this.view.getPaintPanel().setBackground(backgroundColor); //Send the color chosen to view and set the background
		}else if(e.getActionCommand() == "Fill"){
			this.view.getPaintPanel().setFill(true); //If user clicks fill, it sets the boolean to true making all shapes filled
		}else if(e.getActionCommand() == "Outline"){
			this.view.getPaintPanel().setFill(false); //If user clicks outline, it creates all future shapes only with an outline
		}else if(e.getActionCommand() == "Clear"){
			this.model.removeShape(); //If user clicks clear, clear the canvas
			
		}
	}
	
}
