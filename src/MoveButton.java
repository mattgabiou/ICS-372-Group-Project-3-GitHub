
import javax.swing.*;
import java.awt.event.*;

/**
 * Creates a button for selecting items.
 */
public class MoveButton  extends JButton implements ActionListener {
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;

    /**
     * Creates the button
     * @param jFrame frame where the button lives
     * @param jPanel the panel where the items are
     */
    public MoveButton(View jFrame, JPanel jPanel) {
        super("Move");
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
    }

    /**
     * Handles the click by listening to mouse clicks
     * @param event the click event
     */
    public void actionPerformed(ActionEvent event) {
        drawingPanel.addMouseListener(mouseHandler = new MouseHandler());
    }

    /**
     * Handles mouse clicks for selecting items
     */
    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
        }
    }
}