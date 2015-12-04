import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a polygon
 */
public class Polygon extends Item {

    private ArrayList<Point> points;
    private ArrayList<Line> lines;
    private int pointCounter = 0;
    private boolean isDone = false;

    /**
     * Points
     * @param points
     */
    public Polygon(ArrayList<Point> points) {
        this.points = points;
    }

    /**
     * Creates a polygon with no specific points
     */
    public Polygon() {
        points = new ArrayList<>();
        lines = new ArrayList<>();
    }

    /**
     * Displays the polygon
     */
    @Override
    public void render() {
        uiContext.draw(this);
    }

    /**
     * Sets one of the points
     * @param point a point on the polygon
     */
    public void setPoint(Point point) {

        double dist = this.points.isEmpty() ? Double.MAX_VALUE : distance(this.points.get(0), point);

        System.out.println("Size of points: " + this.points.size() + ", distance: " + dist);

        if(this.points.size() > 2 && dist < 10) {
            point.setLocation(this.points.get(0));
            closePolygon();
        }

        if(this.points.size() > 0) {
            Line l = new Line(this.points.get(this.points.size() - 1), point);
            lines.add(l);
        }

        this.points.add(point);
    }

    /**
     * Returns a point from the given integer
     * @param pointNumber the point to be returned
     * @return a point on the polygon
     */
    public Point getPoint(int pointNumber) {
        return points.get(pointNumber);
    }

    /**
     * Closes the polygon
     */
    private void closePolygon() {
        isDone = true;
    }

    public boolean isDone() {
        return isDone;
    }

    /**
     * lines getter
     * @return lines
     */
    public ArrayList<Line> getLines() {
        return lines;
    }

    /**
     * Checks whether the given point falls within the polygon
     * @return true iff the given point is close to one of the endpoints
     */
    @Override
    public boolean includes(Point point) {
        Iterator<Line> iterator = lines.iterator();

        while(iterator.hasNext()) {
            if(iterator.next().includes(point)) return true;
        }

        return false;
    }

    /**
     * Returns a string representation of a polygon
     * @return a string representation
     */
    @Override
    public String toString() {
        return "Polygon  from " + points.get(0) + " to " + points.get(pointCounter - 1);
    }
}