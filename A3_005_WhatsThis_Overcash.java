
/**
 * @author Noah Overcash -- smileytechguy, Benjamin Sanders
 * @version 2.0.1.2.43.3.2.3
 */

import objectdraw.*;
import java.awt.*;
import java.util.Random;

public class A3_005_WhatsThis_Overcash extends WindowController {
    public static void main(String[ ]args) {
        new A3_005_WhatsThis_Overcash().startController(200, 250);
    }
    Random rand = new Random();
    public void begin() {
        float r = rand.nextFloat() / 2f;
        float g = rand.nextFloat() / 2f;
        float b = rand.nextFloat() / 2f;
        new FramedRect(20,20,160,160,canvas).setColor(new Color(r, g, b));
    }
    public void onMousePress(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new Line(100,100,180,100,canvas).setColor(new Color(r, g, b));
    }
    public void onMouseRelease(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new Line(100,20,100,180,canvas).setColor(new Color(r, g, b));
    }
    public void onMouseClick(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new FilledOval(100,100,80,80,canvas).setColor(new Color(r, g, b));
    }
    public void onMouseEnter(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new FilledOval(100,100,80,80,canvas).setColor(new Color(r, g, b));
    }
    public void onMouseExit(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new Line(20,180,100,20,canvas).setColor(new Color(r, g, b));
    }
    public void onMouseMove(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new FilledOval(100,100,80,80,canvas).setColor(new Color(r, g, b));
    }
    public void onMouseDrag(Location Point) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        new FramedRect(20,20,160,160,canvas).setColor(new Color(r, g, b));
    }
}
