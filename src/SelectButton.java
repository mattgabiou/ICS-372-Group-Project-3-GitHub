
import javax.swing.*;
import java.awt.event.*;

/**
 * Creates a button for selecting items.
 */
public class SelectButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private MouseHandler mouseHandler;
  
  /**
   * Creates the button
   * @param jFrame frame where the button lives
   * @param jPanel the panel where the items are
   */
  public SelectButton(View jFrame, JPanel jPanel) {
    super("Select");
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
      
      /**
       * Handles the clicks
       * @param event the click event
       */
      public void mouseClicked(MouseEvent event) {
        Controller.instance().selectItem(View.mapPoint(event.getPoint()));
        drawingPanel.removeMouseListener(this);
      }
  }
}