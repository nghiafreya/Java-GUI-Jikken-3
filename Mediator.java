import java.util.Enumeration;
import java.util.Vector;
import java.awt.*; 


public class Mediator{
    Vector<MyDrawing> drawings;
    MyCanvas canvas;
    MyDrawing selectedDrawing = null;

    //constructor
    public Mediator(MyCanvas canvas) {
        this.canvas = canvas;
        drawings = new Vector<MyDrawing>();
    }

    public Enumeration<MyDrawing> drawingsElements() {
        return drawings.elements();
    }

    public void addDrawing (MyDrawing d) {
        drawings.add(d);
        setSelectedDrawing(d);
    }

    public void removeDrawing(MyDrawing d) {
        drawings.remove(d);
    }

    public void repaint() {
        canvas.repaint();
    }

    public void setSelectedDrawing(MyDrawing d) {

        if (selectedDrawing != null) {
            selectedDrawing.setSelected(false);
        }
        this.selectedDrawing = d;
    }

    
    public MyDrawing getSelectedDrawing() {
        return selectedDrawing;
    }

    public void setSelected(int x, int y) {
        if (selectedDrawing != null) {
            selectedDrawing.setSelected(false);
        }
        selectedDrawing = null;
        for (int i = drawings.size() - 1; i >= 0; i--) {
            MyDrawing d = drawings.get(i);
            if (d.contains(x, y)) {
                selectedDrawing = d;
                selectedDrawing.setSelected(true);
                break;
            } else { //when the selected point (x, y) doesn't belong to any shapes
                //do nothing
            }
        }
    }

    /*******************/
    //課題3-1
    public void move(int dx, int dy) {
        if (selectedDrawing != null) {
            selectedDrawing.move(dx, dy);
        }
    }

   
    public void setLineColor(Color lineColor) {
        if (selectedDrawing != null) {
            selectedDrawing.setLineColor(lineColor);
            repaint();
        }
    }

    public void setFillColor(Color fillColor) {
        if (selectedDrawing != null) {
            selectedDrawing.setFillColor(fillColor);
            repaint();
        }
    }

    public void setLineWidth(int lineWidth) {
        if (selectedDrawing != null) {
            selectedDrawing.setLineWidth(lineWidth);
            repaint();
        }
    }
/***************/



    MyDrawing buffer = null; // Cut, Copyバッファ

    public void clearBuffer()
    {
        buffer = null;
    }

    public void copy()
    {
        // バッファをクリアする
        if (selectedDrawing == null) {
            //do nothing
        } else {       
        clearBuffer();
        buffer = selectedDrawing.clone();
        }
    }

    public void cut()
    {
        // バッファをクリアする
        if (selectedDrawing == null) {
            //do nothing
        } else {
            clearBuffer();
            buffer = selectedDrawing.clone();
            removeDrawing(selectedDrawing); // drawingsからselectedDrawingを削除。
            repaint();
        }

    }

    public void paste(int x, int y)
    { 
        if (buffer != null) {
            MyDrawing clone = (MyDrawing) buffer.clone();
            int newX = buffer.getX() + 10; // X offset
            int newY = buffer.getY() + 10; // Y offset
            clone.setLocation(newX, newY);
            addDrawing(clone);
            repaint();
            buffer.move(10, 10);
        }

    }
}