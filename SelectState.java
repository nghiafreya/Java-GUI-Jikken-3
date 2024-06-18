import java.awt.Color;


public class SelectState extends State {
    StateManager stateManager;
    int Chosen_point_x;
    int Chosen_point_y;

    //constructor 
    public SelectState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    //Set what will happen after using mouse in each state
    public void mouseDown(int x, int y) {
        stateManager.setSelected(x, y);
        stateManager.updateDrawing();


        //Task 3-1, firstly we save the coordinates of the point we just clicked
        Chosen_point_x = x;
        Chosen_point_y = y;


    }
    
    public void mouseDrag(int x, int y) {
        //counting the gap between the point we first clicked and the point after dragging
        int dx = x - Chosen_point_x;
        int dy = y - Chosen_point_y;

        //Move the shape
        if (stateManager.getSelectedDrawing() != null) { //if there is a shape that is selected
            stateManager.move(dx, dy);
            //The point after dragging now became the starting point (treated as "the point we just clicked")
            Chosen_point_x = x;
            Chosen_point_y = y;
            stateManager.updateDrawing();
        } else { //if there is no selected shape, in the other words the clicked point doesn't belong to any shape
            //do nothing
        }
    }

    
    public void mouseUp(int x, int y) {

    } 
}
