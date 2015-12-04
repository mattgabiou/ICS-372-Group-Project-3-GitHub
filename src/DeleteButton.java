
import javax.swing.*;
import java.awt.event.*;

/**
 * The button to delete items. Processes the click
 * by calling the deleteItems method of controller.
 *
 */
public class DeleteButton  extends JButton implements ActionListener {
    
	/**
	 * Creates the button with the proper text and
	 * makes itself listen to clicks.
	 */
	public DeleteButton() {
		super("Delete");
		addActionListener(this);
	}
	
	/**
	 * Processes the click by calling the deleteItems method
	 * of controller.
	 */
	public void actionPerformed(ActionEvent event) {
		Controller.instance().deleteItems();
	}
}