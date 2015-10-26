import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Tacky2 extends WindowController {
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
	double pieceHeight;
	double pieceWidth;
	double pieceHeightOffset;
	double pieceWidthOffset;
	double pieceTextHeightOffset;
	double pieceTextWidthOffset;
	int textSize;
	int oScore = 0;
	int xScore = 0;
	Color boardColor;
	Color xColor;
	Color oColor;
	Color startColor;
	FilledRect piece1;
	FilledRect piece2;
	FilledRect piece3;
	FilledRect piece4;
	FilledRect piece5;
	FilledRect piece6;
	FilledRect piece7;
	FilledRect piece8;
	FilledRect piece9;
	FramedRect playAgainButton;
	FramedRect xScoreButton;
	FramedRect oScoreButton;
	Text text1;
	Text text2;
	Text text3;
	Text text4;
	Text text5;
	Text text6;
	Text text7;
	Text text8;
	Text text9;
	Text titleText;
	Text xScoreText;
	Text oScoreText;
	Image img;
	VisibleImage playAgainImage;
	public static void main(String[] args) {
		Tacky2 oc = new Tacky2();
		oc.startController(1000, 1000);
	}
	public void makeBoard() {
		Color boardColor = new Color(59, 59, 60);
		Color xColor = new Color(255, 0, 0);
		Color oColor = new Color(0, 0, 255);
		Color startColor = new Color(0, 255, 0);
		double xColPadding = canvas.getWidth()/10;
		double yRowPadding = canvas.getHeight()/10;
		Location startLoc = new Location(xColPadding, yRowPadding);
		double boardWidth = canvas.getWidth()*0.8;
		double boardHeight = canvas.getHeight()*0.8;
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
		double pieceHeight = boardRowHeight*0.9;
		double pieceWidth = boardColWidth*0.9;
		double pieceHeightOffset = boardRowHeight/20;
		double pieceWidthOffset = boardColWidth/20;
		double pieceTextHeightOffset = 0;
		double pieceTextWidthOffset = 0;
		int textSize = (int)(pieceWidth*0.8);
		FilledRect piece1 = new FilledRect(xCol0+pieceWidthOffset, yCol0+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece1.setColor(startColor);
		FilledRect piece2 = new FilledRect(xCol1+pieceWidthOffset, yCol0+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece2.setColor(startColor);
		FilledRect piece3 = new FilledRect(xCol2+pieceWidthOffset, yCol0+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece3.setColor(startColor);
		FilledRect piece4 = new FilledRect(xCol0+pieceWidthOffset, yCol1+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece4.setColor(startColor);
		FilledRect piece5 = new FilledRect(xCol1+pieceWidthOffset, yCol1+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece5.setColor(startColor);
		FilledRect piece6 = new FilledRect(xCol2+pieceWidthOffset, yCol1+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece6.setColor(startColor);
		FilledRect piece7 = new FilledRect(xCol0+pieceWidthOffset, yCol2+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece7.setColor(startColor);
		FilledRect piece8 = new FilledRect(xCol1+pieceWidthOffset, yCol2+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece8.setColor(startColor);
		FilledRect piece9 = new FilledRect(xCol2+pieceWidthOffset, yCol2+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece9.setColor(startColor);
		text1 = new Text("H", piece1.getX(), piece1.getY(), canvas);
		text1.setFontSize(textSize);
		text1.move(piece1.getWidth()/2, piece1.getHeight()/2);
		text1.move(text1.getWidth()/-2, text1.getHeight()/-2);
		pieceTextHeightOffset = text1.getY()-piece1.getY();
		pieceTextWidthOffset = text1.getX()-piece1.getX();
		text2 = new Text("H", piece2.getX()+pieceTextWidthOffset, piece2.getY()+pieceTextHeightOffset, canvas);
		text2.setFontSize(textSize);
		text3 = new Text("H", piece3.getX()+pieceTextWidthOffset, piece3.getY()+pieceTextHeightOffset, canvas);
		text3.setFontSize(textSize);
		text4 = new Text("H", piece4.getX()+pieceTextWidthOffset, piece4.getY()+pieceTextHeightOffset, canvas);
		text4.setFontSize(textSize);
		text5 = new Text("H", piece5.getX()+pieceTextWidthOffset, piece5.getY()+pieceTextHeightOffset, canvas);
		text5.setFontSize(textSize);
		text6 = new Text("H", piece6.getX()+pieceTextWidthOffset, piece6.getY()+pieceTextHeightOffset, canvas);
		text6.setFontSize(textSize);
		text7 = new Text("H", piece7.getX()+pieceTextWidthOffset, piece7.getY()+pieceTextHeightOffset, canvas);
		text7.setFontSize(textSize);
		text8 = new Text("H", piece8.getX()+pieceTextWidthOffset, piece8.getY()+pieceTextHeightOffset, canvas);
		text8.setFontSize(textSize);
		text9 = new Text("H", piece9.getX()+pieceTextWidthOffset, piece9.getY()+pieceTextHeightOffset, canvas);
		text9.setFontSize(textSize);
		new Line(xCol0, yCol0, xCol0, yCol3, canvas).setColor(boardColor);
		new Line(xCol1, yCol0, xCol1, yCol3, canvas).setColor(boardColor);
		new Line(xCol2, yCol0, xCol2, yCol3, canvas).setColor(boardColor);
		new Line(xCol3, yCol0, xCol3, yCol3, canvas).setColor(boardColor);
		new Line(xCol0, yCol0, xCol3, yCol0, canvas).setColor(boardColor);
		new Line(xCol0, yCol1, xCol3, yCol1, canvas).setColor(boardColor);
		new Line(xCol0, yCol2, xCol3, yCol2, canvas).setColor(boardColor);
		new Line(xCol0, yCol3, xCol3, yCol3, canvas).setColor(boardColor);
	}
	public void makeScoreBoxes() {
		xScoreButton = new FramedRect(0, 0, canvas.getWidth()/5, canvas.getHeight()/20, canvas);
		xScoreButton.moveTo((canvas.getWidth()/10)+((canvas.getWidth()*0.4)/3), 0);
		xScoreButton.move(xScoreButton.getWidth()/-2, 0);
		oScoreButton = new FramedRect(0, 0, canvas.getWidth()/5, canvas.getHeight()/20, canvas);
		oScoreButton.moveTo((canvas.getWidth()/10)+(((canvas.getWidth()*0.4)/3)*5), 0);
		oScoreButton.move(oScoreButton.getWidth()/-2, 0);
		xScoreText = new Text("X Score: 0", 0, 0, canvas);
<<<<<<< HEAD
		xScoreText.setFontSize(canvas.getHeight()/25);
		xScoreText.moveTo((canvas.getWidth()/10)+((canvas.getWidth()*0.4)/3), 0);
		xScoreText.move(xScoreText.getWidth()/-2, 0);
		oScoreText = new Text("O Score: 0", 0, 0, canvas);
		oScoreText.setFontSize(canvas.getHeight()/25);
		oScoreText.moveTo((canvas.getWidth()/10)+(((canvas.getWidth()*0.4)/3)*5), 0);
		oScoreText.move(oScoreButton.getWidth()/-2, 0);
=======
		xScoreText.moveTo((canvas.getWidth()/10)+((canvas.getWidth()*0.4)/3), 0);
		xScoreText.move(xScoreText.getWidth()/-2, 0);
		//playAgainImage.move(playAgainImage.getWidth()/-2, 0);
>>>>>>> 3b44b128dcb74fe8530bdca22f1cc62afb38f75c
	}
	public void makePlayAgainButton() {
		playAgainButton = new FramedRect(0, 0, canvas.getWidth()/5, canvas.getHeight()/20, canvas);
		playAgainButton.moveTo(canvas.getWidth()/2, 0);
		playAgainButton.move(playAgainButton.getWidth()/-2, 0);
		try {
			playAgainImage = new VisibleImage(ImageIO.read(new File("play_again.png")), 0, 0, canvas.getHeight()/20, canvas.getHeight()/20, canvas);
		} catch (IOException e) {
			// shouldn't make an error afaik
			System.out.println(e);
		}
		playAgainImage.moveTo(canvas.getWidth()/2, 0);
		playAgainImage.move(playAgainImage.getWidth()/-2, 0);
	}
	public void makeTitle() {
		titleText = new Text("TackiToes ᵖᵃᵗᵉᶰᵗ ᵖᵉᶰᵈᶦᶰᵍ™©®", 0, 0, canvas);
		titleText.setFontSize(canvas.getHeight()/25);
		titleText.moveTo(canvas.getWidth()/2, canvas.getHeight()-titleText.getHeight()-10);
		titleText.move(titleText.getWidth()/-2, 0);
	}
	public void begin() {
		makeBoard();
		makePlayAgainButton();
		makeScoreBoxes();
<<<<<<< HEAD
		makeTitle();
=======
>>>>>>> 3b44b128dcb74fe8530bdca22f1cc62afb38f75c
	}
}