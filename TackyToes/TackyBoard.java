import objectdraw.*;
import java.awt.*;
import java.util.*;
public class TackyBoard extends WindowController {
	Location startLoc;
	double xColPadding;
	double yRowPadding;
	double boardWidth;
	double boardHeight;
	double boardRowHeight;
	double boardColWidth;
	double xCol0;
	double xCol1;
	double xCol2;
	double xCol3;
	double yCol0;
	double yCol1;
	double yCol2;
	double yCol3;
	Color boardColor = new Color(255, 0, 0);
	public static void main(String[] args) {
		TackyBoard oc = new TackyBoard();
		oc.startController(600, 600);
	}
	public void begin() {
		double xColPadding = canvas.getWidth()/20;
		double yRowPadding = canvas.getHeight()/20;
		Location startLoc = new Location(xColPadding, yRowPadding);
		double boardWidth = canvas.getWidth()*0.9;
		double boardHeight = canvas.getHeight()*0.9;
		double boardRowHeight = boardHeight/3;
		double boardColWidth = boardWidth/3;
		double xCol0 = xColPadding;
		double xCol1 = xCol0+boardColWidth;
		double xCol2 = xCol1+boardColWidth;
		double xCol3 = xCol2+boardColWidth;
		double yCol0 = yRowPadding;
		double yCol1 = yCol0+boardRowHeight;
		double yCol2 = yCol1+boardRowHeight;
		double yCol3 = yCol2+boardRowHeight;
		
		System.out.println("xColPadding: "+xColPadding);
		System.out.println("yRowPadding: "+yRowPadding);
		System.out.println("startLoc: "+startLoc);
		System.out.println("boardWidth: "+boardWidth);
		System.out.println("boardHeight: "+boardHeight);
		System.out.println("boardRowHeight: "+boardRowHeight);
		System.out.println("boardColWidth: "+boardColWidth);
		System.out.println("xCol0: "+xCol0);
		System.out.println("xCol1: "+xCol1);
		System.out.println("xCol2: "+xCol2);
		System.out.println("xCol3: "+xCol3);
		System.out.println("yCol0: "+yCol0);
		System.out.println("yCol1: "+yCol1);
		System.out.println("yCol2: "+yCol2);
		System.out.println("yCol3: "+yCol3);
		
		new Line(xCol0, yCol0, xCol0, yCol3, canvas).setColor(boardColor);
		new Line(xCol1, yCol0, xCol1, yCol3, canvas).setColor(boardColor);
		new Line(xCol2, yCol0, xCol2, yCol3, canvas).setColor(boardColor);
		new Line(xCol3, yCol0, xCol3, yCol3, canvas).setColor(boardColor);
		new Line(xCol0, yCol0, xCol3, yCol0, canvas).setColor(boardColor);
		new Line(xCol0, yCol1, xCol3, yCol1, canvas).setColor(boardColor);
		new Line(xCol0, yCol2, xCol3, yCol2, canvas).setColor(boardColor);
		new Line(xCol0, yCol3, xCol3, yCol3, canvas).setColor(boardColor);
	}
	public void onMouseExit(Location p) {
		canvas.clear();
		double xColPadding = canvas.getWidth()/20;
		double yRowPadding = canvas.getHeight()/20;
		Location startLoc = new Location(xColPadding, yRowPadding);
		double boardWidth = canvas.getWidth()*0.9;
		double boardHeight = canvas.getHeight()*0.9;
		double boardRowHeight = boardHeight/3;
		double boardColWidth = boardWidth/3;
		double xCol0 = xColPadding;
		double xCol1 = xCol0+boardColWidth;
		double xCol2 = xCol1+boardColWidth;
		double xCol3 = xCol2+boardColWidth;
		double yCol0 = yRowPadding;
		double yCol1 = yCol0+boardRowHeight;
		double yCol2 = yCol1+boardRowHeight;
		double yCol3 = yCol2+boardRowHeight;
		
		System.out.println("xColPadding: "+xColPadding);
		System.out.println("yRowPadding: "+yRowPadding);
		System.out.println("startLoc: "+startLoc);
		System.out.println("boardWidth: "+boardWidth);
		System.out.println("boardHeight: "+boardHeight);
		System.out.println("boardRowHeight: "+boardRowHeight);
		System.out.println("boardColWidth: "+boardColWidth);
		System.out.println("xCol0: "+xCol0);
		System.out.println("xCol1: "+xCol1);
		System.out.println("xCol2: "+xCol2);
		System.out.println("xCol3: "+xCol3);
		System.out.println("yCol0: "+yCol0);
		System.out.println("yCol1: "+yCol1);
		System.out.println("yCol2: "+yCol2);
		System.out.println("yCol3: "+yCol3);
		
		new Line(xCol0, yCol0, xCol0, yCol3, canvas).setColor(boardColor);
		new Line(xCol1, yCol0, xCol1, yCol3, canvas).setColor(boardColor);
		new Line(xCol2, yCol0, xCol2, yCol3, canvas).setColor(boardColor);
		new Line(xCol3, yCol0, xCol3, yCol3, canvas).setColor(boardColor);
		new Line(xCol0, yCol0, xCol3, yCol0, canvas).setColor(boardColor);
		new Line(xCol0, yCol1, xCol3, yCol1, canvas).setColor(boardColor);
		new Line(xCol0, yCol2, xCol3, yCol2, canvas).setColor(boardColor);
		new Line(xCol0, yCol3, xCol3, yCol3, canvas).setColor(boardColor);
	}
}
