import objectdraw.*;
import java.awt.*;
import java.util.*;
public class A3_013_ICanCountALot_Overcash extends WindowController {
    int xTranslateVal;
    int yTranslateVal;
    Location nLine;
    Text countTextNumMClick;
    Text countTextNumMExit;
    Text countTextNumMPress;
    Text countTextNumMDrag;
    Text countTextNumMRelease;
    Text countTextNumMEnter;
    Text countTextNumRand;
    int numMClick = 0;
    int numMExit = 0;
    int numMPress = 0;
    int numMDrag = 0;
    int numMRelease = 0;
    int numMEnter = 0;
    RandomIntGenerator rGen = new RandomIntGenerator(101, 999);
    public static void main(String[] args) {
        A3_013_ICanCountALot_Overcash oc = new A3_013_ICanCountALot_Overcash();
        oc.startController(1200, 600);
        oc.xTranslateVal = oc.canvas.getWidth()/32;
        oc.yTranslateVal = oc.canvas.getHeight()/10;
        oc.nLine = new Location(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumMClick = new Text("Number of clicks: " + oc.numMClick, oc.nLine, oc.canvas);
        oc.countTextNumMClick.setFontSize(oc.yTranslateVal);
        oc.nLine.translate(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumMExit = new Text("Number of exits: " + oc.numMExit, oc.nLine, oc.canvas);
        oc.countTextNumMExit.setFontSize(oc.yTranslateVal);
        oc.nLine.translate(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumMPress = new Text("Number of presses: " + oc.numMPress, oc.nLine, oc.canvas);
        oc.countTextNumMPress.setFontSize(oc.yTranslateVal);
        oc.nLine.translate(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumMDrag = new Text("Number of drags: " + oc.numMDrag, oc.nLine, oc.canvas);
        oc.countTextNumMDrag.setFontSize(oc.yTranslateVal);
        oc.nLine.translate(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumMRelease = new Text("Number of releases: " + oc.numMRelease, oc.nLine, oc.canvas);
        oc.countTextNumMRelease.setFontSize(oc.yTranslateVal);
        oc.nLine.translate(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumMEnter = new Text("Number of enters: " + oc.numMEnter, oc.nLine, oc.canvas);
        oc.countTextNumMEnter.setFontSize(oc.yTranslateVal);
        oc.nLine.translate(oc.xTranslateVal, oc.yTranslateVal);
        oc.countTextNumRand = new Text("Number of randomness: " + oc.rGen.nextValue(), oc.nLine, oc.canvas);
        oc.countTextNumRand.setFontSize(oc.yTranslateVal);
    }
    public void onMouseClick(Location p) {
        numMClick = numMClick + 1;
        countTextNumMClick.setText("Number of clicks: " + numMClick);
        countTextNumRand.setText("Number of randomness: " + rGen.nextValue());
    }
    public void onMouseExit(Location p) {
        numMExit = numMExit + 1;
        countTextNumMExit.setText("Number of exits: " + numMExit);
        countTextNumRand.setText("Number of randomness: " + rGen.nextValue());
    }
    public void onMousePress(Location p) {
        numMPress = numMPress + 1;
        countTextNumMPress.setText("Number of presses: " + numMPress);
        countTextNumRand.setText("Number of randomness: " + rGen.nextValue());
    }
    public void onMouseDrag(Location p) {
        numMDrag = numMDrag + 1;
        countTextNumMDrag.setText("Number of drags: " + numMDrag);
        countTextNumRand.setText("Number of randomness: " + rGen.nextValue());
    }
    public void onMouseRelease(Location p) {
        numMRelease = numMRelease + 1;
        countTextNumMRelease.setText("Number of releases: " + numMRelease);
        countTextNumRand.setText("Number of randomness: " + rGen.nextValue());
    }
    public void onMouseEnter(Location p) {
        numMEnter = numMEnter + 1;
        countTextNumMEnter.setText("Number of enters: " + numMEnter);
        countTextNumRand.setText("Number of randomness: " + rGen.nextValue());
    }
}