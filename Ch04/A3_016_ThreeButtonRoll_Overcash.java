package Ch04;

import objectdraw.*;
import java.awt.*;
import java.util.*;
public class A3_016_ThreeButtonRoll_Overcash extends WindowController {
    RandomIntGenerator rGen = new RandomIntGenerator(1, 3);
    int redColor = 3;
	int blueColor = 2;
	int greenColor = 1;
	int offSet;
	int oneThirdScreenX;
	int twoThirdScreenX;
	int boxYValue;
	int boxWidth;
	int boxHeight;
	int pointsThisRound = 0;
	int totalScore = 0;
	int changeColor = 0;
    public static void main(String[] args) {
        A3_016_ThreeButtonRoll_Overcash oc = new A3_016_ThreeButtonRoll_Overcash();
        oc.startController(600, 600);
    }
    public void begin() {
		offSet = (canvas.getWidth()/33);
		oneThirdScreenX = canvas.getWidth()/3;
		twoThirdScreenX = canvas.getWidth()/(3/2);
		boxYValue = canvas.getHeight()/3+offSet;
		boxWidth = (canvas.getWidth()/33)*10;
		boxHeight = (canvas.getHeight()/33)*10;
    }
    public void onMouseClick(Location p) {
    	// do stuff
    }
}