import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * Represents a oval
 */
public class Oval extends Item {

    private Point corner1;
    private Point corner2;
    private Ellipse2D ellipse2D;

    /**
     * Creates a oval with the given rectangular pointss
     * @param point1 one rectangular point
     * @param point2 another rectangular point
     */
    public Oval(Point point1, Point point2) {
        corner1 = point1;
        corner2 = point2;
    }

    /**
     * Creates a oval with no specific endpoints
     */
    public Oval() { }

    /**
     * Checks whether the given point falls within the rectangular points of the
     * oval.
     * @return true iff the given point is close to one of the corner points
     */
    @Override
    public boolean includes(Point point) {
        return ellipse2D.contains(point);
    }

    /**
     * Displays the oval
     */
    @Override
    public void render() {
        uiContext.draw(this);
    }

    /**
     * Sets the first of the corner points
     * @param point a corner point
     */
    public void setCorner1(Point point) {
        corner1 = point;
    }

    /**
     * Sets the second of the corner points
     * @param point a corner point
     */
    public void setCorner2(Point point) {
        corner2 = point;

        double x = (corner2.getX() > corner1.getX()) ? corner1.getX() : corner2.getX();
        double y = (corner2.getY() > corner1.getY()) ? corner1.getY() : corner2.getY();

        double width = (corner2.getX() > corner1.getX()) ? corner2.getX() - corner1.getX() : corner2.getX() - corner2.getX();
        double height = (corner2.getY() > corner1.getY()) ? corner2.getY() - corner1.getY() : corner1.getY() - corner2.getY();
        
        ellipse2D = new Ellipse2D.Double(x, y, width, height);
    }

    /**
     * Returns ellipse to be drawn
     * @return ellipse
     */
    public Ellipse2D getEllipse2D() {
        return ellipse2D;
    }

    /**
     * Returns a string representation of the oval
     * @return a string representation
     */
    @Override
    public String toString() {
        return "Oval from " + corner1 + " to " + corner2;
    }
}