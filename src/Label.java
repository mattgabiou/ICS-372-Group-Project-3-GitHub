
import java.awt.*;

/**
 * Implements a line; stores the end points.
 *
 */
public class Label extends Item {
  private Point startingPoint;
  private String text = "";
  
  /**
   * Creates a label object with the starting point determined.
   * @param point the start of the label
   */
  public Label(Point point) {
    startingPoint = point;
  }
  
  /**
   * Adds one more character to the label
   * @param character a new character in the label
   */
  public void addCharacter(char character) {
    text += character;
  }
  
  /**
   * removes the rightmost character in the label
   */
  public void removeCharacter() {
    if (text.length() > 0) {
      text = text.substring(0, text.length() - 1);
    }
  }
  
  /**
   * Checks if the given point is in the label
   */
  public boolean includes(Point point) {
    return distance(point, startingPoint) < 10.0;
  }
  
  /**
   * Displays the label
   */
  public void render() {
    uiContext.draw(this);
  }
  
  /**
   * Returns the actual text in the label
   * @return the text in the label
   */
  public String getText() {
    return text;
  }
  
  /**
   * Returns the starting point
   * @return starting point
   */
  public Point getStartingPoint() {
    return startingPoint;
  }
}