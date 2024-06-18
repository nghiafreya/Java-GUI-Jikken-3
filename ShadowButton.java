import javax.swing.*;
import java.awt.event.*;

public class ShadowButton extends JButton {
    StateManager stateManager;

    // Constructor
    public ShadowButton(StateManager stateManager) {
        super("Toggle Shadow"); 
        this.stateManager = stateManager;
        addActionListener(new ShadowListener()); //add an action listener for the button
    }

    class ShadowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) { //if anything happens to the button
            // execute the code below
            stateManager.setShadow(!stateManager.getShadow());
        }
    }
}
