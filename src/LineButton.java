
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
* The button to create lines. Processes the mouse movements and
* clicks calling the appropriate methods of controller.
*
*/
public class LineButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  
  /**
   * Creates the button for the line
   * @param jFrame the frame where the label is put
   * @param jPanel the panel within the frame
   */
  public LineButton(View jFrame, JPanel jPanel) {
    super("Line");
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
  }
  
  /**
   * Handle click for creating a new line
   */
  public void actionPerformed(ActionEvent event) {
    drawingPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    mouseHandler = new MouseHandler();
    // Change cursor when button is clicked
    Controller.instance().makeLine();
    drawingPanel.addMouseListener(mouseHandler);
  // Start listening for mouseclicks on the drawing panel
  }
  
  /**
   * Handles mouse click so that the points can now be captured.
   * 
   */
  private class MouseHandler extends MouseAdapter {
    private int pointCount;
    public void mouseClicked(MouseEvent event) {
      Controller.instance().setLinePoint(View.mapPoint(event.getPoint()));
      if (++pointCount == 2) {
        pointCount = 0;
        drawingPanel.removeMouseListener(this);
        drawingPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
      }
    }
  }
}