import objectdraw.*;
import java.awt.*;
import java.util.*;
public class A3_016_ThreeButtonRoll_Overcash extends WindowController {
	RandomIntGenerator rGen = new RandomIntGenerator(1, 3);
	int redColor = 3;
	int blueColor = 2;
	int greenColor = 1;
	int offset;
	int oneThirdScreenX;
	int twoThirdScreenX;
	int boxYValue;
	int boxWidth;
	int boxHeight;
	int oneThirdScreenY;
	int twoThirdScreenY;
	int pointsThisRound = 0;
	int totalScore = 0;
	int changeColor = 0;
	FilledRect box1;
	FilledRect box2;
	FilledRect box3;
	Text scoreText;
	public static void main(String[] args) {
		A3_016_ThreeButtonRoll_Overcash oc = new A3_016_ThreeButtonRoll_Overcash();
		oc.startController(600, 600);
	}
	public void begin() {
		offset = (canvas.getWidth()/33);
		oneThirdScreenX = canvas.getWidth()/3;
		twoThirdScreenX = (canvas.getWidth()/3)*2;
		oneThirdScreenY = canvas.getHeight()/3;
		twoThirdScreenY = (canvas.getHeight()/3)*2;
		boxYValue = canvas.getHeight()/3+offset;
		boxWidth = (canvas.getWidth()/3)-(offset*2)+2; // TODO : MAKE THIS PRETTIER
		boxHeight = (canvas.getHeight()/3)-(offset*2)+2; // TODO : MAKE THIS PRETTIER
		new Line(0, oneThirdScreenY, canvas.getWidth(), oneThirdScreenY, canvas);
		new Line(0, twoThirdScreenY, canvas.getWidth(), twoThirdScreenY, canvas);
		new Line(0, oneThirdScreenY, 0, twoThirdScreenY, canvas);
		new Line(oneThirdScreenX, oneThirdScreenY, oneThirdScreenX, twoThirdScreenY, canvas);
		new Line(twoThirdScreenX, oneThirdScreenY, twoThirdScreenX, twoThirdScreenY, canvas);
		new Line(canvas.getWidth()-1, oneThirdScreenY, canvas.getWidth()-1, twoThirdScreenY, canvas);
		box1 = new FilledRect(offset, boxYValue, boxWidth, boxHeight, canvas);
		box1.setColor(new Color(255, 0, 0));
		box2 = new FilledRect(oneThirdScreenX+offset, boxYValue, boxWidth, boxHeight, canvas);
		box2.setColor(new Color(0, 255, 0));
		box3 = new FilledRect(twoThirdScreenX+offset, boxYValue, boxWidth, boxHeight, canvas);
		box3.setColor(new Color(0, 0, 255));
		new Text("Red: 3", offset, offset, canvas).setFontSize(20);
		new Text("Green: 2", offset, offset+25, canvas).setFontSize(20);
		new Text("Blue: 1", offset, offset+50, canvas).setFontSize(20);
		scoreText = new Text("This Round: "+pointsThisRound+" == New Score: "+totalScore, offset, offset+90, canvas);
		scoreText.setFontSize(30);
		scoreText.moveTo(canvas.getWidth()/2, offset+90);
		scoreText.move(-scoreText.getWidth()/2, 0);
	}
	public void onMouseClick(Location p) {
		pointsThisRound = 0;
		scoreText.setText("This Round: "+pointsThisRound+" == New Score: "+totalScore);
		changeColor = rGen.nextValue();
		if (changeColor == redColor) {
			box1.setColor(new Color(255, 0, 0));
			pointsThisRound += 3;
		} else if (changeColor == blueColor) {
			box1.setColor(new Color(0, 255, 0));
			pointsThisRound += 2;
		} else if (changeColor == greenColor) {
			box1.setColor(new Color(0, 0, 255));
			pointsThisRound ++;
		}
		changeColor = rGen.nextValue();
		if (changeColor == redColor) {
			box2.setColor(new Color(255, 0, 0));
			pointsThisRound += 3;
		} else if (changeColor == blueColor) {
			box2.setColor(new Color(0, 255, 0));
			pointsThisRound += 2;
		} else if (changeColor == greenColor) {
			box2.setColor(new Color(0, 0, 255));
			pointsThisRound ++;
		}
		changeColor = rGen.nextValue();
		if (changeColor == redColor) {
			box3.setColor(new Color(255, 0, 0));
			pointsThisRound += 3;
		} else if (changeColor == blueColor) {
			box3.setColor(new Color(0, 255, 0));
			pointsThisRound += 2;
		} else if (changeColor == greenColor) {
			box3.setColor(new Color(0, 0, 255));
			pointsThisRound ++;
		}
		totalScore += pointsThisRound;
		scoreText.setText("This Round: "+pointsThisRound+" == New Score: "+totalScore);
	}
	public void onMouseExit() {
		totalScore = 0;
		pointsThisRound = 0;
                scoreText.setText("This Round: "+pointsThisRound+" == New Score: "+totalScore);
	}
}
