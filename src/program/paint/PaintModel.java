package program.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {
	/**
	 * Paintmodel which holds all the ArrayLists of the MainShapes
	 */
	
	private ArrayList<MainShape> Shapes = new ArrayList<MainShape>(); //Arraylist of all the shapes
	private ArrayList<MainShape> UndoShapes = new ArrayList<MainShape>(); //Arraylist of the undoshapes
	
	private ArrayList<Point> points = new ArrayList<Point>(); //Arraylist of points
	
	private int shapeSize;
	
	public void addPoint(Point p){
		/**
		 * AddPoint that adds point to arraylist
		 * and notifys observer
		 */
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<Point> getPoints(){
		/**
		 * get the ArrayList of points
		 */
		return points;
	}	
	public ArrayList<Point> resetPoints(){
		/**
		 * Reset the arraylist point
		 */
      return points = new ArrayList<Point>();
	}	
	public void addShape(MainShape mainshape){
		/**
		 * Add the Shape drawn to the arraylist of shapes
		 * and update the observer so it can repaint
		 */
		this.Shapes.add(mainshape);
		this.shapeSize = this.Shapes.size();
		this.setChanged();
		this.notifyObservers();
	}
	public void addShapeUndo(MainShape mainshape){
		/**
		 * Undo shapes are put into a temporary arraylist
		 * so it can be access if wanted to redo
		 */
		this.UndoShapes.add(mainshape);
	}
	public void removeShape(){
		/**
		 * This is used to clear the canvas
		 * Goes through the mainshape arraylist and removing each index
		 */
		int index = this.Shapes.size();
		for(int i = this.shapeSize; i>0; i--){
			index--;
		this.Shapes.remove(index);}
		this.setChanged();
		this.notifyObservers();
	}
	public ArrayList<MainShape> getShapes(){
		/**
		 * Return the Arraylist of shapes
		 */
		return Shapes;
	}
	public ArrayList<MainShape> getUndo(){
		/**
		 * Return the undo arraylist shape
		 */
		return UndoShapes;
	}
	public int getSize(){
		return shapeSize;
	}
}
