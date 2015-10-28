import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Tacky3 extends WindowController {
	Location startLoc;
	ArrayList clickedPieces = new ArrayList();
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
	int totalLegalClicks = 0;
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
		Tacky3 oc = new Tacky3();
		oc.startController(1000, 1000);
	}
	public void makeBoard() {
		boardColor = new Color(59, 59, 60);
		xColor = new Color(255, 0, 0);
		oColor = new Color(0, 0, 255);
		startColor = new Color(0, 255, 0);
		xColPadding = canvas.getWidth()/10;
		yRowPadding = canvas.getHeight()/10;
		Location startLoc = new Location(xColPadding, yRowPadding);
		boardWidth = canvas.getWidth()*0.8;
		boardHeight = canvas.getHeight()*0.8;
		boardRowHeight = boardHeight/3;
		boardColWidth = boardWidth/3;
		xCol0 = xColPadding;
		xCol1 = xCol0+boardColWidth;
		xCol2 = xCol1+boardColWidth;
		xCol3 = xCol2+boardColWidth;
		yCol0 = yRowPadding;
		yCol1 = yCol0+boardRowHeight;
		yCol2 = yCol1+boardRowHeight;
		yCol3 = yCol2+boardRowHeight;
		pieceHeight = boardRowHeight*0.9;
		pieceWidth = boardColWidth*0.9;
		pieceHeightOffset = boardRowHeight/20;
		pieceWidthOffset = boardColWidth/20;
		pieceTextHeightOffset = 0;
		pieceTextWidthOffset = 0;
		textSize = (int)(pieceWidth*0.8);
		piece1 = new FilledRect(xCol0+pieceWidthOffset, yCol0+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece1.setColor(startColor);
		piece2 = new FilledRect(xCol1+pieceWidthOffset, yCol0+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece2.setColor(startColor);
		piece3 = new FilledRect(xCol2+pieceWidthOffset, yCol0+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece3.setColor(startColor);
		piece4 = new FilledRect(xCol0+pieceWidthOffset, yCol1+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece4.setColor(startColor);
		piece5 = new FilledRect(xCol1+pieceWidthOffset, yCol1+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece5.setColor(startColor);
		piece6 = new FilledRect(xCol2+pieceWidthOffset, yCol1+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece6.setColor(startColor);
		piece7 = new FilledRect(xCol0+pieceWidthOffset, yCol2+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece7.setColor(startColor);
		piece8 = new FilledRect(xCol1+pieceWidthOffset, yCol2+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece8.setColor(startColor);
		piece9 = new FilledRect(xCol2+pieceWidthOffset, yCol2+pieceHeightOffset, pieceWidth, pieceHeight, canvas);
		piece9.setColor(startColor);
		text1 = new Text("T", piece1.getX(), piece1.getY(), canvas);
		text1.setFontSize(textSize);
		text1.move(piece1.getWidth()/2, piece1.getHeight()/2);
		text1.move(text1.getWidth()/-2, text1.getHeight()/-2);
		pieceTextHeightOffset = text1.getY()-piece1.getY();
		pieceTextWidthOffset = text1.getX()-piece1.getX();
		text2 = new Text("A", piece2.getX()+pieceTextWidthOffset, piece2.getY()+pieceTextHeightOffset, canvas);
		text2.setFontSize(textSize);
		text3 = new Text("K", piece3.getX()+pieceTextWidthOffset, piece3.getY()+pieceTextHeightOffset, canvas);
		text3.setFontSize(textSize);
		text4 = new Text("I", piece4.getX()+pieceTextWidthOffset, piece4.getY()+pieceTextHeightOffset, canvas);
		text4.setFontSize(textSize);
		text5 = new Text("T", piece5.getX()+pieceTextWidthOffset, piece5.getY()+pieceTextHeightOffset, canvas);
		text5.setFontSize(textSize);
		text6 = new Text("O", piece6.getX()+pieceTextWidthOffset, piece6.getY()+pieceTextHeightOffset, canvas);
		text6.setFontSize(textSize);
		text7 = new Text("E", piece7.getX()+pieceTextWidthOffset, piece7.getY()+pieceTextHeightOffset, canvas);
		text7.setFontSize(textSize);
		text8 = new Text("Z", piece8.getX()+pieceTextWidthOffset, piece8.getY()+pieceTextHeightOffset, canvas);
		text8.setFontSize(textSize);
		text9 = new Text("™", piece9.getX()+pieceTextWidthOffset, piece9.getY()+pieceTextHeightOffset, canvas);
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
		xScoreText.setFontSize(canvas.getHeight()/25);
		xScoreText.moveTo((canvas.getWidth()/10)+((canvas.getWidth()*0.4)/3), 0);
		xScoreText.move(xScoreText.getWidth()/-2, 0);
		oScoreText = new Text("O Score: 0", 0, 0, canvas);
		oScoreText.setFontSize(canvas.getHeight()/25);
		oScoreText.moveTo((canvas.getWidth()/10)+(((canvas.getWidth()*0.4)/3)*5), 0);
		oScoreText.move(oScoreButton.getWidth()/-2, 0);
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
		titleText = new Text("TakiToez ᵖᵃᵗᵉᶰᵗ ᵖᵉᶰᵈᶦᶰᵍ™©®", 0, 0, canvas);
		titleText.setFontSize(canvas.getHeight()/25);
		titleText.moveTo(canvas.getWidth()/2, canvas.getHeight()-titleText.getHeight()-10);
		titleText.move(titleText.getWidth()/-2, 0);
		titleText.setFont("Comic Sans MS");
	}
	FilledRect boxClicked(Location p) {
		if (piece1.contains(p)) {
			if (piece1.getColor() == startColor) {
				return piece1;
			} else {
				return null;
			}
		} else if (piece2.contains(p)) {
			if (piece2.getColor() == startColor) {
				return piece2;
			} else {
				return null;
			}
		} else if (piece3.contains(p)) {
			if (piece3.getColor() == startColor) {
				return piece3;
			} else {
				return null;
			}
		} else if (piece4.contains(p)) {
			if (piece4.getColor() == startColor) {
				return piece4;
			} else {
				return null;
			}
		} else if (piece5.contains(p)) {
			if (piece5.getColor() == startColor) {
				return piece5;
			} else {
				return null;
			}
		} else if (piece6.contains(p)) {
			if (piece6.getColor() == startColor) {
				return piece6;
			} else {
				return null;
			}
		} else if (piece7.contains(p)) {
			if (piece7.getColor() == startColor) {
				return piece7;
			} else {
				return null;
			}
		} else if (piece8.contains(p)) {
			if (piece8.getColor() == startColor) {
				return piece8;
			} else {
				return null;
			}
		} else if (piece9.contains(p)) {
			if (piece9.getColor() == startColor) {
				return piece9;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	Text boxTextClicked(Location p) {
		if (piece1.contains(p)) {
			if (piece1.getColor() == startColor) {
				return text1;
			} else {
				return null;
			}
		} else if (piece2.contains(p)) {
			if (piece2.getColor() == startColor) {
				return text2;
			} else {
				return null;
			}
		} else if (piece3.contains(p)) {
			if (piece3.getColor() == startColor) {
				return text3;
			} else {
				return null;
			}
		} else if (piece4.contains(p)) {
			if (piece4.getColor() == startColor) {
				return text4;
			} else {
				return null;
			}
		} else if (piece5.contains(p)) {
			if (piece5.getColor() == startColor) {
				return text5;
			} else {
				return null;
			}
		} else if (piece6.contains(p)) {
			if (piece6.getColor() == startColor) {
				return text6;
			} else {
				return null;
			}
		} else if (piece7.contains(p)) {
			if (piece7.getColor() == startColor) {
				return text7;
			} else {
				return null;
			}
		} else if (piece8.contains(p)) {
			if (piece8.getColor() == startColor) {
				return text8;
			} else {
				return null;
			}
		} else if (piece9.contains(p)) {
			if (piece9.getColor() == startColor) {
				return text9;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	public void begin() {
		makeBoard();
		makePlayAgainButton();
		makeScoreBoxes();
		makeTitle();
	}
	public void onMouseClick(Location p) {
		System.out.println(boxClicked(p));
		if (boxClicked(p) != null) {
			if (totalLegalClicks%2 == 0) {
				boxTextClicked(p).setText("X");
				boxClicked(p).setColor(xColor);
				totalLegalClicks++;
			} else {
				boxTextClicked(p).setText("O");
				boxClicked(p).setColor(oColor);
				totalLegalClicks++;
			}
		}
		if (playAgainButton.contains(p)) {
			totalLegalClicks = 0;
			canvas.clear();
			makeBoard();
			makePlayAgainButton();
			makeScoreBoxes();
			makeTitle();
		}
	}
}