import objectdraw.*;
import java.awt.*;
import java.util.*;
public class A3_012_DrawGrid_Overcash extends WindowController {
    Location verticalCorner;
    Location horizontalCorner;
    Text startingMessage;
    public static void main(String[] args) {
        A3_012_DrawGrid_Overcash oc = new A3_012_DrawGrid_Overcash();
        oc.startController(600, 600);
        oc.verticalCorner = new Location(0, 0);
        oc.horizontalCorner = new Location(0, 0);
        oc.startingMessage = new Text("Click to draw a 2 color grid", 0, 0, oc.canvas);
        oc.startingMessage.setColor(new Color(50,128,60));
        oc.startingMessage.setFontSize(16);
        oc.startingMessage.moveTo(oc.canvas.getWidth()/2, oc.canvas.getHeight()/2);
        oc.startingMessage.move(-oc.startingMessage.getWidth()/2, -oc.startingMessage.getHeight()/2);
    }
    public void onMouseClick(Location p) {
        startingMessage.hide();
        new FilledRect(verticalCorner.getX(), 0, 5, canvas.getHeight(), canvas).setColor(new Color(0,0,255));
        new FilledRect(0, horizontalCorner.getY(), canvas.getWidth(), 5, canvas).setColor(new Color(255,0,0));
        horizontalCorner.translate(10, 10);
        verticalCorner.translate(10, 10);
    }
    public void onMouseExit(Location p) {
        canvas.clear();
        verticalCorner = new Location(0, 0);
        horizontalCorner = new Location(0, 0);
        startingMessage = new Text("Click to draw a 2 color grid", 0, 0, canvas);
        startingMessage.setColor(new Color(50,128,60));
        startingMessage.setFontSize(16);
        startingMessage.moveTo(canvas.getWidth()/2, canvas.getHeight()/2);
        startingMessage.move(-startingMessage.getWidth()/2, -startingMessage.getHeight()/2);
    }
}