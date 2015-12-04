
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * The button to put labels. Processes the mouse movements and
 * clicks calling the appropriate methods of controller.
 *
 */
class LabelButton  extends JButton implements ActionListener {
  protected JPanel drawingPanel;
  protected View view;
  private KeyHandler keyHandler;
  private MouseHandler mouseHandler;
  
  /**
   * Creates the button for the label
   * @param jFrame the frame where the label is put
   * @param jPanel the panel within the frame
   */
  public LabelButton(View jFrame, JPanel jPanel) {
    super("Label");
    keyHandler = new KeyHandler();
    addActionListener(this);
    view = jFrame;
    drawingPanel = jPanel;
  }
  
  /**
   * Handle click for creating a new label
   */
  public void actionPerformed(ActionEvent event) {
    drawingPanel.addMouseListener(mouseHandler = new MouseHandler());
  }
  
  /**
   * Handles mouse click so that the text can now be captured.
   * 
   */
  private class MouseHandler extends MouseAdapter {
    public void mouseClicked(MouseEvent event) {
      drawingPanel.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
      Controller.instance().makeLabel(View.mapPoint(event.getPoint()));
      drawingPanel.requestFocusInWindow();
      drawingPanel.addKeyListener(keyHandler);
    }
  }
  
  /**
   * Handles characters in the label
   */
  private class KeyHandler extends KeyAdapter {
      
      /**
	  * Handles printable characters
	  * @param event the key event
	  */
    public void keyTyped(KeyEvent event) {
      char character = event.getKeyChar();
      
      if (character >= 32 && character <= 126) {
        Controller.instance().addCharacter(event.getKeyChar());
      }
    }
    
    /**
     * Handles the enter and backspace keys
	  * @param event the key event
     */
    public void keyPressed(KeyEvent event) {
      if (event.getKeyCode() == KeyEvent.VK_ENTER) {
        drawingPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        drawingPanel.removeMouseListener(mouseHandler);
        drawingPanel.removeKeyListener(keyHandler);
        drawingPanel.repaint();
      } else if (event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
        Controller.instance().removeCharacter();
      }
    }
  }
}