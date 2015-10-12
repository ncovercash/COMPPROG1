
/**
 * @author Noah Overcash -- smileytechguy
 * @version 2.0.1.2.43.3.2.3
 * explainations of code: https://goo.gl/RyIzwb
 */

import objectdraw.*;
import java.awt.*;
import java.util.*;

public class A3_010_RandomBox_Overcash extends WindowController {
	public static void main(String[ ]args) {
		A3_010_RandomBox_Overcash oc = new A3_010_RandomBox_Overcash();
		oc.startController(600, 600);
	}
	RandomIntGenerator rColorg = new RandomIntGenerator(0, 255);
	RandomIntGenerator rHWg = new RandomIntGenerator(0, 300);
	int[] rColor = {0, 0, 0};
	int rWidth;
	int rHeight;
	FilledRect box = new FilledRect(250, 250, 100, 100, canvas);
	FramedRect boxFrame = new FramedRect(250, 250, 100, 100, canvas);
	Text widthT = new Text("Width: null", 0, 0, canvas);
	Text heightT = new Text("Height: null", 0, 14, canvas);
	Text locT = new Text("Location: null", 0, 28, canvas);
	Text colorT = new Text("Color: rgb(null)", 0, 42, canvas);
	public void onMousePress(Location p) {
		rColor[0] = rColorg.nextValue();
		rColor[1] = rColorg.nextValue();
		rColor[2] = rColorg.nextValue();
		rWidth = rHWg.nextValue();
		rHeight = rHWg.nextValue();
		System.out.println("new color "+Arrays.toString(rColor));
		System.out.println("new h/w "+Arrays.toString(new int[] {rWidth, rHeight}));
		System.out.println("calculated coords ["+((canvas.getWidth()/2)-(rWidth/2))+", "+((canvas.getHeight()/2)-(rHeight/2))+"]");
		box.setColor(new Color(rColor[0], rColor[1], rColor[2]));
		box.setWidth(rWidth);
		box.setHeight(rHeight);
		boxFrame.setWidth(rWidth);
		boxFrame.setHeight(rHeight);
		box.moveTo(((canvas.getWidth()/2)-(rWidth/2)), ((canvas.getHeight()/2)-(rHeight/2)));
		boxFrame.moveTo(((canvas.getWidth()/2)-(rWidth/2)), ((canvas.getHeight()/2)-(rHeight/2)));
		widthT.setText("Widt: "+rWidth);
		heightT.setText("Heit: "+rHeight);
		locT.setText("Locashun: ["+((canvas.getWidth()/2)-(rWidth/2))+", "+((canvas.getHeight()/2)-(rHeight/2))+"]");
		colorT.setText("Colaaaaaaaaaaaaaaaaaaaaa: rgb("+Arrays.toString(rColor)+")");
	}
	public void begin() {
		rColor[0] = rColorg.nextValue();
		rColor[1] = rColorg.nextValue();
		rColor[2] = rColorg.nextValue();
		rWidth = rHWg.nextValue();
		rHeight = rHWg.nextValue();
		System.out.println("new color "+Arrays.toString(rColor));
		System.out.println("new h/w "+Arrays.toString(new int[] {rWidth, rHeight}));
		System.out.println("calculated coords ["+((canvas.getWidth()/2)-(rWidth/2))+", "+((canvas.getHeight()/2)-(rHeight/2))+"]");
		box.setColor(new Color(rColor[0], rColor[1], rColor[2]));
		box.setWidth(rWidth);
		box.setHeight(rHeight);
		boxFrame.setWidth(rWidth);
		boxFrame.setHeight(rHeight);
		box.moveTo(((canvas.getWidth()/2)-(rWidth/2)), ((canvas.getHeight()/2)-(rHeight/2)));
		boxFrame.moveTo(((canvas.getWidth()/2)-(rWidth/2)), ((canvas.getHeight()/2)-(rHeight/2)));
		widthT.setText("Widt: "+rWidth);
		heightT.setText("Heit: "+rHeight);
		locT.setText("Locashun: ["+((canvas.getWidth()/2)-(rWidth/2))+", "+((canvas.getHeight()/2)-(rHeight/2))+"]");
		colorT.setText("Colaaaaaaaaaaaaaaaaaaaaa: rgb("+Arrays.toString(rColor)+")");
	}
	public void onMouseEnter(Location p) {
		boxFrame.show();
		box.show();
		rColor[0] = rColorg.nextValue();
		rColor[1] = rColorg.nextValue();
		rColor[2] = rColorg.nextValue();
		rWidth = rHWg.nextValue();
		rHeight = rHWg.nextValue();
		System.out.println("new color "+Arrays.toString(rColor));
		System.out.println("new h/w "+Arrays.toString(new int[] {rWidth, rHeight}));
		System.out.println("calculated coords ["+((canvas.getWidth()/2)-(rWidth/2))+", "+((canvas.getHeight()/2)-(rHeight/2))+"]");
		box.setColor(new Color(rColor[0], rColor[1], rColor[2]));
		box.setWidth(rWidth);
		box.setHeight(rHeight);
		boxFrame.setWidth(rWidth);
		boxFrame.setHeight(rHeight);
		box.moveTo(((canvas.getWidth()/2)-(rWidth/2)), ((canvas.getHeight()/2)-(rHeight/2)));
		boxFrame.moveTo(((canvas.getWidth()/2)-(rWidth/2)), ((canvas.getHeight()/2)-(rHeight/2)));
		widthT.setText("Widt: "+rWidth);
		heightT.setText("Heit: "+rHeight);
		locT.setText("Locashun: ["+((canvas.getWidth()/2)-(rWidth/2))+", "+((canvas.getHeight()/2)-(rHeight/2))+"]");
		colorT.setText("Colaaaaaaaaaaaaaaaaaaaaa: rgb("+Arrays.toString(rColor)+")");
	}
	public void onMouseExit(Location p) {
		box.hide();
		boxFrame.hide();
		widthT.setText("Width: null");
		heightT.setText("Height: null");
		locT.setText("Location: null");
		colorT.setText("Color: null");
	}
}