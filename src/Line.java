
import java.awt.*;

/**
 * Represents a line
 */
public class Line extends Item {
  private Point point1;
  private Point point2;
  
  /**
   * Creates a line with the given endpoints
   * @param point1 one endpoint
   * @param point2 another endpoint
   */
  public Line(Point point1, Point point2) {
    this.point1 = point1;
    this.point2 = point2;
  }
  
  /**
   * Creates a line with no specific endpoints
   */
  public Line() {
  }
  
  /**
   * Checks whether the given point falls within the line
   * @return true iff the given point is close to one of the endpoints
   */
  public boolean includes(Point point) {
    return ((distance(point, point1 ) < 10.0) || (distance(point, point2)< 10.0));
  }
  
  /**
   * Displays the line
   */
  public void render() {
    uiContext.draw(this);
  }
  
  /**
   * Sets one of the endpoints
   * @param point an endpoint
   */
  public void setPoint1(Point point) {
    point1 = point;
  }
  
  /**
   * Sets one of the endpoints
   * @param point an endpoint
   */
  public void setPoint2(Point point) {
    point2 = point;
  }
  
  /**
   * Returns one of the endpoints
   * @return an endpoint
   */
  public Point getPoint1() {
    return point1;
  }
  
  /**
   * Returns one of the endpoints
   * @return an endpoint
   */
  public Point getPoint2() {
    return point2;
  }
  
  /**
   * Returns a string representation of the line
   * @return a string representation
   */
  public String toString() {
    return "Line  from " + point1 + " to " + point2;
  }
}