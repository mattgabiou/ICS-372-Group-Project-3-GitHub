import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The button to create polygons. Processes the mouse movements and clicks
 * calling the appropriate methods of controller.
 */
public class PolygonButton extends JButton implements ActionListener {
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;

    /**
     * Creates the button for the polygon
     * @param jFrame the frame where the label is put
     * @param jPanel the panel within the frame
     */
    public PolygonButton(View jFrame, JPanel jPanel) {
        super("Polygon");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
    }

    /**
     * Handle click for creating a new polygon
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        drawingPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        mouseHandler = new MouseHandler();
        // Change cursor when button is clicked
        Controller.instance().makePolygon();
        drawingPanel.addMouseListener(mouseHandler);
        // Start listening for mouseclicks on the drawing panel
    }

    /**
     * Handles mouse click so that the points can now be captured.
     */
    private class MouseHandler extends MouseAdapter {

        private int pointCount;

        @Override
        public void mouseClicked(MouseEvent event) {
            Controller.instance().setPolygonPoint(View.mapPoint(event.getPoint()));

            if(Controller.instance().isPolygonDone()) {
                drawingPanel.removeMouseListener(this);
                drawingPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
}