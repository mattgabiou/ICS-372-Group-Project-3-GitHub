
import javax.swing.*;
import java.awt.event.*;

/**
 * The button to save the items.
 *
 */
public class SaveButton  extends JButton implements ActionListener {
  protected View view;
  
  /**
   * Creates the button
   * @param jFrame the frame where the button lives
   */
  public SaveButton(View jFrame) {
    super("Save");
    addActionListener(this);
    view = jFrame;
  }
  
  /**
   * Handles the click by notifying the controller
   * @param event the click event
   */
  public void actionPerformed(ActionEvent event) {
    String string = view.getFileName();
    if (string == null) {
      string = JOptionPane.showInputDialog(view, "Please specify file name");
      view.setFileName(string);
    }
    Controller.instance().saveFile(string);
  }
}