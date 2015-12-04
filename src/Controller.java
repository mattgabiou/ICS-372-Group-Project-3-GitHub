import java.awt.Point;
import java.util.Enumeration;

/*
 * The controller orchestrates the drawing program. It receives requests from
 * the user via the view and then transmits them appropriately to the model.
 */
public class Controller {

    private static Controller controller;
    private static Model model;
    
    private Line line;
    private Polygon polygon;
    private Oval oval;
    private Label label;
    
    private int pointCount;

    /**
     * Singleton
     */
    private Controller() {}

    /**
     * Returns the instance of the controller
     * @return the instance
     */
    public static Controller instance() {
        if (controller == null) {
            controller = new Controller();
        }
        
        return controller;
    }

    /**
     * Sets the reference to the model
     * @param model the model
     */
    public static void setModel(Model model) {
        Controller.model = model;
    }

    /**
     * Constructs a line and sends the info to the model.
     */
    public void makeLine() {
        line = new Line();
        pointCount = 0;
        model.addItem(line);
    }

    /**
     * Stores one of the line endpoints.
     * @param point one of the two points
     */
    public void setLinePoint(Point point) {
        if (++pointCount == 1) {
            line.setPoint1(point);
        } else {
            line.setPoint2(point);
        }
        model.updateView();
    }
    
    /**
     * Constructs a polygon and sends the info to the model.
     */
    public void makePolygon() {
        polygon = new Polygon();
        pointCount = 0;
        model.addItem(polygon);
    }
    
    /**
     * Stores one of the polygon points.
     * @param point the point to set
     */
    public void setPolygonPoint(Point point) {
        polygon.setPoint(point);
        pointCount++;
        model.updateView();
    }

    public boolean isPolygonDone() {
        return polygon.isDone();
    }
    
    /**
     * Constructs a oval and sends the info to the model.
     */
    public void makeOval() {
        oval = new Oval();
        pointCount = 0;
        model.addItem(oval);
    }
    
    /**
     * Stores one of the oval rectangular points.
     * @param point one of the two corner points
     */
    public void setOvalPoint(Point point) {
        if (++pointCount == 1) {
            oval.setCorner1(point);
        } else {
            oval.setCorner2(point);
        }
        model.updateView();
    }

    /**
     * Creates a label and informs the model.
     * @param point the start point
     */
    public void makeLabel(Point point) {
        label = new Label(point);
        model.addItem(label);
    }

    /**
     * Receives a character and accumulates it. The model is asked to update the
     * view.
     * @param character the typed in character
     */
    public void addCharacter(char character) {
        label.addCharacter(character);
        model.updateView();
    }

    /**
     * A command to remove a character. The model will then update the view.
     */
    public void removeCharacter() {
        label.removeCharacter();
        model.updateView();
    }

    /**
     * Given a point, see if any of the items contains it.
     * @param point the point
     */
    public void selectItem(Point point) {
        Enumeration enumeration = model.getItems();
        
        while (enumeration.hasMoreElements()) {
            Item item = (Item) (enumeration.nextElement());
            
            if (item.includes(point)) {
                model.markSelected(item);
                break;
            }
        }
    }

    /**
     * Processes the command to delete the selected items.
     */
    public void deleteItems() {
        model.deleteSelectedItems();
    }

    /**
     * Processes the command to open a file
     * @param fileName the name of the file
     */
    public void openFile(String fileName) {
        model.retrieve(fileName);
    }

    /**
     * Processes the command to close a file
     * @param fileName the name of the file
     */
    public void saveFile(String fileName) {
        model.save(fileName);
    }
}