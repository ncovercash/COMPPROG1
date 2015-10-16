import objectdraw.*;
import java.awt.*;
import java.util.*;
public class TackyBoard extends WindowController {
	Location startLoc;
	int xColPadding;
	int yRowPadding;
	int boardWidth;
	int boardHeight;
	int boardRowHeight;
	int boardColWidth;
	int xCol0;
	int xCol1;
	int xCol2;
	int xCol3;
	int yCol0;
	int yCol1;
	int yCol2;
	int yCol3;
	Color boardColor = new Color(255, 0, 0);
	public static void main(String[] args) {
		TackyBoard oc = new TackyBoard();
		oc.startController(600, 600);
	}
	public void begin() {
		int xColPadding = canvas.getWidth()/20;
		int yRowPadding = canvas.getHeight()/20;
		Location startLoc = new Location(xColPadding, yRowPadding);
		int boardWidth = canvas.getWidth()/10*9;
		int boardHeight = canvas.getHeight()/10*9;
		int boardRowHeight = boardHeight/3;
		int boardColWidth = boardWidth/3;
		int xCol0 = xColPadding;
		int xCol1 = xCol0+boardColWidth;
		int xCol2 = xCol1+boardColWidth;
		int xCol3 = xCol2+boardColWidth;
		int yCol0 = yRowPadding;
		int yCol1 = yCol0+boardRowHeight;
		int yCol2 = yCol1+boardRowHeight;
		int yCol3 = yCol2+boardRowHeight;
		
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
		int xColPadding = canvas.getWidth()/20;
		int yRowPadding = canvas.getHeight()/20;
		Location startLoc = new Location(xColPadding, yRowPadding);
		int boardWidth = canvas.getWidth()/10*9;
		int boardHeight = canvas.getHeight()/10*9;
		int boardRowHeight = boardHeight/3;
		int boardColWidth = boardWidth/3;
		int xCol0 = xColPadding;
		int xCol1 = xCol0+boardColWidth;
		int xCol2 = xCol1+boardColWidth;
		int xCol3 = xCol2+boardColWidth;
		int yCol0 = yRowPadding;
		int yCol1 = yCol0+boardRowHeight;
		int yCol2 = yCol1+boardRowHeight;
		int yCol3 = yCol2+boardRowHeight;
		
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
