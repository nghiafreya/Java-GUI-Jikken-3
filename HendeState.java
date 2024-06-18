import java.awt.Color;

public class HendeState extends State {
    StateManager stateManager;
    MyHendecagonal currentHende;
    int old_x, old_y;


    //constructor 
    public HendeState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    //Set what will happen after using mouse in each state

    public void mouseDown (int x, int y) {
        /*課題2-1 */
        //stateManager.addDrawing(new MyHendecagonal(x, y));
        /************ */

        /*課題2-2 */
        // old_x = x;
        // old_y = y;

        // currentHende= new MyHendecagonal(x, y, 0, 0);
        // /*dash */
        // currentHende.setDashed(stateManager.getDashed()); 
        //stateManager.addDrawing(currentHende);

        /*課題2-3 */
        old_x = x;
        old_y = y;

        currentHende = new MyHendecagonal(x, y, 0, 0, Color.black, Color.white);
        /*dash */
        currentHende.setDashed(stateManager.getDashed()); 
        /*shadow*/
        currentHende.setShadow(stateManager.getShadow());
        stateManager.addDrawing(currentHende);
    }   
    
    
    public void mouseDrag(int x, int y) {
        int width = Math.abs(x - old_x);
        int height = Math.abs(y - old_y);
        int newX = Math.min(x, old_x);
        int newY = Math.min(y, old_y);
        
        currentHende.setLocation(newX, newY);
        currentHende.setSize(width, height);
        stateManager.updateDrawing();
    }

    
    public void mouseUp(int x, int y) {
        //if the hendecagonal is too small, delete it
        if (Math.abs(x - old_x) < 5 || Math.abs(y - old_y) < 5) {
            stateManager.removeDrawing(currentHende);   
        //else: draw it
        } else {
            stateManager.updateDrawing();
        }   
    } 
}
