package program.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class LineThicknessPanel extends JPanel implements ChangeListener{
	/**
	 * Class linethicknesspanel creates a slider for stroke width
	 */
	private View view; // So we can talk to our parent or other components of the view
	private Stroke stroke;
	
	public LineThicknessPanel(View view) {	
		/**
		 * Constructor that makes view to current view
		 */
		
		this.view=view;
		
		JSlider slider = new JSlider(JSlider.VERTICAL, 0, 20, 1);
		slider.setMinorTickSpacing(2);
	    slider.setMajorTickSpacing(10);
	    slider.setPaintTicks(true); //Slider options
	    slider.setPaintLabels(true);
	    slider.setLabelTable(slider.createStandardLabels(10));
	    this.setLayout(new BorderLayout());
	    slider.addChangeListener(this);
	    
	    this.add(slider);
		}

	@Override
	public void stateChanged(ChangeEvent changeEvent) {
		/**
		 * Changelistener, upon change of the slider. We grab the integer value and set it to stroke
		 */
		Object source = changeEvent.getSource();
		 if (source instanceof BoundedRangeModel) {
		      BoundedRangeModel aModel = (BoundedRangeModel) source;
		      if (!aModel.getValueIsAdjusting()) {
		        System.out.println("Changed: " + aModel.getValue());
		      }
		    } else if (source instanceof JSlider) {
		      JSlider theJSlider = (JSlider) source;
		      if (!theJSlider.getValueIsAdjusting()) {
		    	stroke = new BasicStroke(theJSlider.getValue());
		    	this.view.getPaintPanel().setThickness(this.stroke); //Send the stroke value to paintpanel so we can use it in our shapes
		        System.out.println("Slider changed: " + theJSlider.getValue());
		      }
		    } else {
		      System.out.println("Something changed: " + source);
		    }
		
	}
		
	}

