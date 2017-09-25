package program.paint;

public class ShapeFactory {
	/**
	 * ShapeFactory to help simplify the if statments of what shape is being chosed
	 */
	private PaintModel model; //Connects model
	
	
	public ShapeFactory(PaintModel model){
		/**
		 * Hooks the current model
		 */
		this.model = model;
	}
	
	public Strategy createStrategy(String mode){
		/**
		 * Creates the strategy depending on what mode is being chosed
		 */
		switch(mode){
		case "Circle":
			return new CircleStrategy(this.model);
		case "Rectangle":
			return new RectangleStrategy(this.model);
		case "Square":
			return new SquareStrategy(this.model);
		case "Scribble":
			return new ScribbleStrategy(this.model);
		case "Polyline":
			return new PolylineStrategy(this.model);
		case "Line":
			return new LineStrategy(this.model);
		default:
			return new ScribbleStrategy(this.model);
		}
	}
}
