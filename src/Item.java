import java.io.*;
import java.awt.*;

/**
 * Superclass for all types of drawable objects.
 *
 */
public abstract class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static UIContext uiContext;
	
  /**
   * Stores reference to the type of UI.
   * @param uiContext reference to the 
   */
    public static void setUIContext(UIContext uiContext) {
		Item.uiContext = uiContext;
	}
    
	/**
	 * Checks whether a point falls within the figure.
	 * @param point the point
	 * @return true iff the point is in the figure
	 */
	public abstract boolean includes(Point point);
	
	/**
	 * Calculates the distance between two points
	 * @param point1 one of the two points
	 * @param point2 one of the two points
	 * @return distance between the points
	 */
	protected double distance(Point point1, Point point2) {
		double xDifference = point1.getX() - point2.getX();
		double yDifference = point1.getY() - point2.getY();
		return ((double) (Math.sqrt(xDifference * xDifference + yDifference * yDifference)));
	}
	
	/**
	 * Draw the figure on the UI
	 */
	public  void render() {
		uiContext.draw(this);
	}
}