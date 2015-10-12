import objectdraw.*;
import java.awt.*;
import java.util.*;
public class A3_011_CrossBox_Overcash extends WindowController {
    private Location centerOfCanvas;
    public static void main(String[] args) {
        A3_011_CrossBox_Overcash oc = new A3_011_CrossBox_Overcash();
        oc.startController(600, 600);
    }
    public void begin() {
        centerOfCanvas = new Location(canvas.getWidth()/2, canvas.getHeight()/2);
    }
    public void onMousePress(Location p) {
        new Line(0, 0, canvas.getWidth(), canvas.getHeight(), canvas).setColor(new Color(255,0,0));
        new Line(0, canvas.getHeight(), canvas.getWidth(), 0, canvas).setColor(new Color(0,255,0));
        new FilledRect(canvas.getWidth()/3, canvas.getHeight()/3, canvas.getWidth()/3, canvas.getHeight()/3, canvas).setColor(new Color(255,255,0));
        new FramedRect(canvas.getWidth()/3, canvas.getHeight()/3, canvas.getWidth()/3, canvas.getHeight()/3, canvas).setColor(new Color(0,0,0));
        new Line(centerOfCanvas.getX(), canvas.getHeight()/3, centerOfCanvas.getX(), canvas.getHeight()/1.5, canvas).setColor(new Color(128,255,0));
        new Line(canvas.getWidth()/3, centerOfCanvas.getY(), canvas.getWidth()/1.5, centerOfCanvas.getY(), canvas).setColor(new Color(255,128,0));
    }
    public void onMouseRelease(Location p) {
        new Line(centerOfCanvas.getX(), 0, centerOfCanvas.getX(), canvas.getHeight(), canvas).setColor(new Color(0,0,255));
        new Line(0, centerOfCanvas.getY(), canvas.getWidth(), centerOfCanvas.getY(), canvas).setColor(new Color(0,255,255));
    }
    public void onMouseClick(Location p) {
    	new FilledOval((centerOfCanvas.getX())-(centerOfCanvas.getX()/8), (centerOfCanvas.getY())-(centerOfCanvas.getY()/8), centerOfCanvas.getX()/4, centerOfCanvas.getY()/4, canvas).setColor(new Color(255,0,255));
    	new FramedOval((centerOfCanvas.getX())-(centerOfCanvas.getX()/8), (centerOfCanvas.getY())-(centerOfCanvas.getY()/8), centerOfCanvas.getX()/4, centerOfCanvas.getY()/4, canvas).setColor(new Color(0,0,0));
    }
    public void onMouseExit(Location p) {
    	canvas.clear();
    }
}