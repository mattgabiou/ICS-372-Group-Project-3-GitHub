
/**
 * Creates the model and "connects" all the three modules.
 */
public class DrawingProgram {
    
	/**
	 * Creates the model and connects the three subsytems.
	 * @param args not used
	 */
  public static void main(String[] args){
    Model model = new Model();
    Controller.instance().setModel(model);
    View.setModel(model);
    View view = new View();
    model.addObserver(view);
    view.setVisible(true);
  }
}