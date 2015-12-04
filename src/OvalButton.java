import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The button to create ovals. Processes the mouse movements and clicks calling
 * the appropriate methods of controller.
 */
public class OvalButton extends JButton implements ActionListener {

    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;

    /**
     * Creates the button for the oval
     * @param jFrame the frame where the label is put
     * @param jPanel the panel within the frame
     */
    public OvalButton(View jFrame, JPanel jPanel) {
        super("Oval");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
    }

    /**
     * Handle click for creating a new oval
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        drawingPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        mouseHandler = new MouseHandler();
        // Change cursor when button is clicked
        Controller.instance().makeOval();
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
            Controller.instance().setOvalPoint(View.mapPoint(event.getPoint()));
            if (++pointCount == 2) {
                pointCount = 0;
                drawingPanel.removeMouseListener(this);
                drawingPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
}