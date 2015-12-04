
/**
 * A given technology can implement this to draw the items in 
 * its own way.
 */
public interface UIContext {
	//  public abstract void drawCircle(Circle circle);
    
	/**
	 * Draw the line
	 * @param line the line
	 */
	public abstract void draw(Line line);
	
	/**
	 * Draw the label
	 * @param label the label
	 */
	public abstract void draw(Label label);
	
	/**
	 * Draws unspecified items
	 * @param item the item
	 */
	public abstract void draw(Item item);

	/**
	 * Draws unspecified items
	 * @param oval the item
	 */
	public abstract void draw(Oval oval);

	/**
	 * Draws unspecified items
	 * @param polygon the item
	 */
	public abstract void draw(Polygon polygon);
}