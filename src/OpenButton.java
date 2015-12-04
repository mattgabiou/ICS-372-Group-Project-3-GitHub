
import javax.swing.*;
import java.awt.event.*;

/**
 * The button to open a file.
 *
 */
public class OpenButton  extends JButton implements ActionListener {
  protected View view;
  
  /**
   * Creates the button
   * @param jFrame the frame where the button lives
   */
  public OpenButton(View jFrame) {
    super("Open");
    addActionListener(this);
    view = jFrame;
  }
  
  /**
   * Handles the click by notifying the controller
   * @param event the click event
   */
  public void actionPerformed(ActionEvent event){
    String string = JOptionPane.showInputDialog(view, "Please type new file name");
    Controller.instance().openFile(string);
    view.setFileName(string);
  }
}