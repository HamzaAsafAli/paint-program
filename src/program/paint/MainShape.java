package program.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Stroke;
import java.util.ArrayList;


public abstract class MainShape implements DrawingCommands{
		/**
		 * Abstract class, which is a generic shape. Which all shapes are children to
		 * This is a basic shape that takes in parameters and creates a default shape
		 */
		private Color color; //A color for shape
		private Point centre; //The point of the shape, either centre or corner
		private int x2,y2; //The next X/Y points
		private Stroke stroke; //Stroke for shape
		private Boolean fill; //If shape is filled or not
		
		public ArrayList<Point> points = new ArrayList<Point>(); //Arraylist of points
		private ArrayList<Integer> tempX,tempY; //This is for polyline but not used

		public MainShape(){
			/**
			 * Constructor for MainShape that initalize all the variables
			 */
			this.color = Color.black;
			this.x2 = 0;
			this.y2 = 0;
			this.centre = new Point(0,0);
			this.stroke = new BasicStroke(1);
			this.fill = false;
		}
		
		public MainShape(Point centre, int x2, int y2, Color color, Stroke stroke, Boolean fill){
			/**
			 * MainShape constructor that creates a default shape
			 * 
			 * @Param centre - a point from mouseclick
			 * @Param x2 - Next x value
			 * @Param y2 - Next y value
			 * @Param color - Color of shape
			 * @Param stroke - stroke of shape
			 * @Param fill - If its solid or empty
			 */
			this.color = color;
			this.centre = centre;
			this.x2 = x2;
			this.y2 = y2;
			this.stroke = stroke;
			this.fill = fill;
			this.points.add(centre);
		}
		
		//Setters 
		
		public void setX2(int x2){
			this.x2 = x2;}
		public void setY2(int y2){
			this.y2 = y2;}
		public void setCentre(Point centre){
			this.centre = centre;}
		public void addPointToList(Point p){
			this.points.add(p);}
		public void setColor(Color color){
			this.color = color;}
		public void setStroke(Stroke stroke){
			this.stroke = stroke;}
		public void setFill(Boolean fill){
			this.fill = fill;}
		
		//Getters
		
		public int getX2(){
			return x2;}
		public int getY2(){
			return y2;}
		public Point getCentre(){
			return centre;}
		public Color getColor(){
			return color;}
		public Stroke getStroke(){
			return stroke;}
		public Boolean getFill(){
			return fill;}
		public int getLength(){
			return Math.abs(getCentre().getX() - getX2());}
		public int getHeight(){
			return Math.abs(getCentre().getY() - getY2());}
		public ArrayList<Point> getPoints(){
			return points;
		}
		
		//For Polyline, we did not use
		
		public void XArrayConverter(ArrayList<Integer> tempX){
			int[] xSet = new int[tempX.size()];
			for(int i = 0; i < xSet.length; i++){
				xSet[i] = tempX.get(i);
				}}
		public void YArrayConverter(ArrayList<Integer> tempY){
			int[] ySet = new int[tempY.size()]; 
			for(int j = 0; j < ySet.length; j++){
				ySet[j] = tempY.get(j);
			}}
		public void addX(int x){
			tempX.add(x);
			XArrayConverter(tempX);}
		public void addY(int y){
			tempY.add(y);
			YArrayConverter(tempY);}

		public abstract void execute(Graphics g);
}