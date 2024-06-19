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
            //普通の場合、選択した図形がない
            if (stateManager.getSelectedDrawing() == null) {
                stateManager.setShadow(!stateManager.getShadow());
            } else { //選択した図形がある
                MyDrawing selectedShadowDrawing = stateManager.getSelectedDrawing();
                stateManager.setShadow(!stateManager.getShadow());

                if (stateManager.getShadow()) { //影がある
                    //draw shadow:
                    selectedShadowDrawing.setShadow(true);
                    stateManager.updateDrawing();
                } else { //影がない
                    //delete shadow:
                    selectedShadowDrawing.setShadow(false);
                    stateManager.updateDrawing();
                }
 
                
            }
        }
    }
}
