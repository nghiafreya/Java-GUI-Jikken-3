import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.event.*;

public class DeleteButton extends JButton {
    StateManager stateManager;
    Mediator med;

    // Constructor
    public DeleteButton(StateManager stateManager, Mediator med) {
        super("Toggle Delete"); 
        this.stateManager = stateManager;
        this.med = med;
        addActionListener(new DeleteListener()); //add an action listener for the button
    }

    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { //if anything happens to the button
            if (med.getSelectedDrawing() != null) {
                med.removeDrawing(stateManager.getSelectedDrawing());
                stateManager.updateDrawing();
            } else { //if no shape is selected then dont remove anything
                //do nothing
            }
        }
    }
}
