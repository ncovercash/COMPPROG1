

import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import javax.imageio.*;
public class Cacalatur extends ActiveObject {
	DrawingCanvas c;
	FramedRect calcBorder, nestedBorder, resultBorder, lowerSecBorder, historyTapeBox;
	Text mode, historyTapeHeader;
	ScoreBox top;
	Line historyHeader;
	double val1, val2;
	int op=-1;
	boolean historyTapeRight;
	String[] buttonTexts = new String[] {"m+", "m-", "mc", "mr", "ms", "CE/C", "¹⁄ᵪ", "x²", "√", "⁺⁄₋", "rand", "AC", "floor", "ceil", "++", "--", "round", "eᵡ", "sin", "cos", "tan", "SI", "DEG", "SCI", "sin⁻¹", "cos⁻¹", "tan⁻¹", "e", "10ᵡ", "÷", "log", "ln", "(", ")", "", "✕", "^", "π", "7", "8", "9", "–", "x³", "∛", "4", "5", "6", "+", "abs", "%", "1", "2", "3", "=", "OFF", "isint", "0", ".", "(−)"};
	ArrayList<String> inputs;
	ArrayList<Integer> buttonIDs;
	ArrayList<Button> buttons;
	ArrayList<String> tapeEntries;
	Text[] tapes;
	ArrayList<Line> historySperators;
	public Cacalatur(DrawingCanvas c) {
		this.c=c;
		inputs = new ArrayList<String>();
		buttons = new ArrayList<Button>(buttonTexts.length);
		buttonIDs = new ArrayList<Integer>(buttonTexts.length);
		tapeEntries = new ArrayList<String>();
		tapes = new Text[11];
		historySperators = new ArrayList<Line>(10);
		if ((c.getHeight()-10)/2 < c.getWidth()-10) {
			historyTapeRight=true;
			calcBorder = new FramedRect(5, 5, (c.getHeight()-10)/2, c.getHeight()-10, c); 
		} else {
			historyTapeRight=false;
			calcBorder = new FramedRect(5, 5, c.getWidth()-10, (c.getWidth()-10)/2, c);
		}
		nestedBorder = new FramedRect(calcBorder.getX()+3, calcBorder.getY()+3, calcBorder.getWidth()-6, calcBorder.getHeight()-6, c);
		top = new ScoreBox(nestedBorder.getX()+nestedBorder.getWidth()/16, nestedBorder.getY()+nestedBorder.getHeight()/40, nestedBorder.getWidth()-nestedBorder.getWidth()/8, nestedBorder.getHeight()*0.1, new Color(0xffffff), "", c);
		resultBorder = new FramedRect(top.getX()-4, top.getY()-4, top.getWidth()+8, top.getHeight()+8, c);
		mode = new Text("DEG", top.getX(), top.getY()+top.getHeight(), c);
		mode.setFontSize((int)top.getHeight()/6);
		mode.move(0,-mode.getHeight());
		lowerSecBorder = new FramedRect(resultBorder.getX(), top.getY()+top.getHeight()+nestedBorder.getHeight()/40, resultBorder.getWidth(), nestedBorder.getHeight()-nestedBorder.getHeight()/13-resultBorder.getHeight(), c);
		// lowerSecBorder.setHeight(nestedBorder.getHeight()-nestedBorder.getHeight()/40);
		for (int i=0; i<buttonTexts.length; i++) {
			buttons.add(createButton((int)Math.floor(i/6.0), i%6, 10, 6, buttonTexts[i], i));
			buttonIDs.add(Integer.parseInt(""+(int)Math.floor(i/6.0)+i%6));
		}
		lowerSecBorder.move(0,-4);
		lowerSecBorder.setHeight(lowerSecBorder.getHeight()+10);
		for (int i=0; i<buttonTexts.length; i++) {
			if (buttonTexts[i] == "=") {
				buttons.get(i).sendToFront();
			}
		}
		lowerSecBorder.sendToFront();
		nestedBorder.sendToFront();
		calcBorder.sendToFront();
		if (historyTapeRight) {
			historyTapeBox = new FramedRect(calcBorder.getX()+calcBorder.getWidth()+10, 5, c.getWidth()-25-calcBorder.getWidth(), c.getHeight()-11, c);
		} else {
			historyTapeBox = new FramedRect(5, calcBorder.getY()+calcBorder.getHeight()+10, c.getWidth()-11, c.getHeight()-25-calcBorder.getHeight(), c);
		}
		historyTapeHeader = new Text("History Tape:", historyTapeBox.getX()+5, historyTapeBox.getY()+5, c);
		historyTapeHeader.setFontSize((int)(top.getHeight()/3.0*1.5));
		historyHeader = new Line(historyTapeBox.getX(), historyTapeBox.getY()+10+historyTapeHeader.getHeight(), historyTapeBox.getX()+historyTapeBox.getWidth(), historyTapeBox.getY()+10+historyTapeHeader.getHeight(), c);
		for (int i=0; i<11; i++) {
			historySperators.add(new Line(historyTapeBox.getX(), historyHeader.getStart().getY()+(((historyTapeBox.getHeight()-(historyTapeBox.getY()+10+historyTapeHeader.getHeight()))/11)*i), historyTapeBox.getX()+historyTapeBox.getWidth(), historyHeader.getStart().getY()+(((historyTapeBox.getHeight()-(historyTapeBox.getY()+10+historyTapeHeader.getHeight()))/11)*i), c));
			tapes[i] = (new Text("", historyTapeBox.getX()+10, historyHeader.getStart().getY()+(((historyTapeBox.getHeight()-(historyTapeBox.getY()+10+historyTapeHeader.getHeight()))/11)*i), c));
			tapes[i].setFontSize(80);
		}
	}
	public void onMouseClick(Location p) {
		for (Button b:buttons) {
			if (b.testClick(p)) {
				System.out.println(b.getBID2());
				switch (b.getBID2()) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						inputs = new ArrayList<String>();
						updateDisplay();
						break;
					case 6:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(1/top.getScore() * 10000d) / 10000d);
						tapeEntries.add("1 / "+val1+" = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 7:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.pow(top.getScore(), 2) * 10000d) / 10000d);
						tapeEntries.add(val1+"² = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 8:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.sqrt(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("√("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 9:
						if (inputs.size() != 0) {
							if (inputs.get(0) == "-") {
								inputs.remove(0);
							} else {
								inputs.add(0, "-");
							}
						}
						updateDisplay();
						break;
					case 10:
						double result = Math.random();
						top.setScore((double)Math.round(result * 10000d) / 10000d);
						tapeEntries.add("rand() = "+result);
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 11:
						op=0;
						val1=0;
						val2=0;
						inputs = new ArrayList<String>();
						updateDisplay();
						break;
					case 12:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.floor(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("floor("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 13:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.ceil(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("ceil("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 14:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(top.getScore()+1 * 10000d) / 10000d);
						tapeEntries.add(val1+"++ = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 15:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(top.getScore()-1 * 10000d) / 10000d);
						tapeEntries.add(val1+"-- = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 16:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.round(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("round("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 17:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.pow(Math.E, top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("e^"+val1+" = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 18:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.sin(Math.toRadians(val1)) * 10000d) / 10000d);
						tapeEntries.add("sin("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 19:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.cos(Math.toRadians(val1)) * 10000d) / 10000d);
						tapeEntries.add("cos("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 20:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.tan(Math.toRadians(val1)) * 10000d) / 10000d);
						tapeEntries.add("tan("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 21:
						// mode.setText("SCI");
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						tapeEntries.add(val1+" => "+getSIs(val1));
						updateTape();
						break;
					case 22:
						mode.setText("DEG");
						break;
					case 23:
						// mode.setText("SCI");
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						tapeEntries.add(val1+" => "+parseToCientificNotation(val1));
						updateTape();
						break;
					case 24:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.sin(Math.toRadians(val1)) * 10000d) / 10000d);
						top.setScore((double)Math.round(1/(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("sin⁻¹("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 25:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.cos(Math.toRadians(val1)) * 10000d) / 10000d);
						top.setScore((double)Math.round(1/(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("cos⁻¹("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 26:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.tan(Math.toRadians(val1)) * 10000d) / 10000d);
						top.setScore((double)Math.round(1/(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("tan⁻¹("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 27:
						inputs = new ArrayList<String>();
						top.setScore((double)Math.round(Math.E * 10000d) / 10000d);
						break;
					case 28:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.pow(10, top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("10^"+val1+" = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 29:
						if (calculateInput() != top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
						} else {
							updateDisplay();
							val1 = calculateInput();
						}
						op=29;
						// updateTape();
						inputs = new ArrayList<String>();
						break;
					case 30:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.log10(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("log("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 31:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.log(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("ln("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 32:
						break;
					case 33:
						break;
					case 34:
						break;
					case 35:
						if (calculateInput() != top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
						} else {
							updateDisplay();
							val1 = calculateInput();
						}
						op=35;
						// updateTape();
						inputs = new ArrayList<String>();
						break;
					case 36:
						if (calculateInput() != top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
						} else {
							updateDisplay();
							val1 = calculateInput();
						}
						op=36;
						// updateTape();
						inputs = new ArrayList<String>();
						break;
					case 37:
						inputs = new ArrayList<String>();
						top.setScore((double)Math.round(Math.E * 10000d) / 10000d);
						break;
					case 38:
						inputs.add("7");
						updateDisplay();
						break;
					case 39:
						inputs.add("8");
						updateDisplay();
						break;
					case 40:
						inputs.add("9");
						updateDisplay();
						break;
					case 41:
						if (calculateInput() != top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
						} else {
							updateDisplay();
							val1 = calculateInput();
						}
						op=41;
						// updateTape();
						inputs = new ArrayList<String>();
						break;
					case 42:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.pow(top.getScore(), 3) * 10000d) / 10000d);
						tapeEntries.add(val1+"³ = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 43:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.cbrt(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("∛("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 44:
						inputs.add("4");
						updateDisplay();
						break;
					case 45:
						inputs.add("5");
						updateDisplay();
						break;
					case 46:
						inputs.add("6");
						updateDisplay();
						break;
					case 47:
						if (calculateInput() != top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
						} else {
							updateDisplay();
							val1 = calculateInput();
						}
						op=47;
						// updateTape();
						inputs = new ArrayList<String>();
						break;
					case 48:
						val1 = top.getScore();
						val1 = (double)Math.round(val1 * 10000d) / 10000d;
						top.setScore((double)Math.round(Math.abs(top.getScore()) * 10000d) / 10000d);
						tapeEntries.add("abs("+val1+") = "+top.getScore());
						updateTape();
						inputs = new ArrayList<String>();
						break;
					case 49:
						if (calculateInput() != top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
						} else {
							updateDisplay();
							val1 = calculateInput();
						}
						op=49;
						// updateTape();
						inputs = new ArrayList<String>();
						break;
					case 50:
						inputs.add("1");
						updateDisplay();
						break;
					case 51:
						inputs.add("2");
						updateDisplay();
						break;
					case 52:
						inputs.add("3");
						updateDisplay();
						break;
					case 53:
						// equals
						result=0;
						switch(op) {
							case -1:
								if (inputs.size() != 0) {
									val1 = calculateInput();
									result = calculateInput();
								} else {
									val1 = top.getScore();
									val1 = (double)Math.round(val1 * 10000d) / 10000d;
									result = top.getScore();
								}
								tapeEntries.add(val1 + " = " + result);
								break;
							case 29:
								val2 = calculateInput();
								val2 = (double)Math.round(val2 * 10000d) / 10000d;
								result = val1/val2;
								tapeEntries.add(val1 + " ÷ " + val2 + " = " + result);
								break;
							case 35:
								val2 = calculateInput();
								val2 = (double)Math.round(val2 * 10000d) / 10000d;
								result = val1*val2;
								tapeEntries.add(val1 + " * " + val2 + " = " + result);
								break;
							case 36:
								val2 = calculateInput();
								val2 = (double)Math.round(val2 * 10000d) / 10000d;
								result = Math.pow(val1, val2);
								tapeEntries.add(val1 + "^" + val2 + " = " + result);
								break;
							case 41:
								val2 = calculateInput();
								val2 = (double)Math.round(val2 * 10000d) / 10000d;
								result = val1-val2;
								tapeEntries.add(val1 + " - " + val2 + " = " + result);
								break;
							case 47:
								val2 = calculateInput();
								val2 = (double)Math.round(val2 * 10000d) / 10000d;
								result = val1+val2;
								tapeEntries.add(val1 + " + " + val2 + " = " + result);
								break;
							case 49:
								val2 = calculateInput();
								val2 = (double)Math.round(val2 * 10000d) / 10000d;
								result = val1%val2;
								tapeEntries.add(val1 + " % " + val2 + " = " + result);
								break;
						}
						top.setScore((double)Math.round(result * 10000d) / 10000d);
						updateTape();
						val2 = 0;
						op = -1;
						inputs = new ArrayList<String>();
						break;
					case 54:
						System.exit(1);
						break;
					case 55:
						if ((int)top.getScore() == top.getScore()) {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
							top.setScore((double)Math.round(1 * 10000d) / 10000d);
							tapeEntries.add("isint("+val1+") = YES");
							updateTape();
							inputs = new ArrayList<String>();
						} else {
							val1 = top.getScore();
							val1 = (double)Math.round(val1 * 10000d) / 10000d;
							top.setScore((double)Math.round(0 * 10000d) / 10000d);
							tapeEntries.add("isint("+val1+") = NO");
							updateTape();
							inputs = new ArrayList<String>();
						}
						break;
					case 56:
						inputs.add("0");
						updateDisplay();
						break;
					case 57:
						inputs.add(".");
						break;
					case 58:
						if (inputs.size() == 0) {
							inputs.add("-");
						}
						break;
				}
			}
		}
	}
	public void onMouseMove(Location p) {
	}
	public void onMouseEnter(Location p) {
	}
	public void onMouseExit(Location p) {
	}
	public void onMousePress(Location p) {
	}
	public void onMouseDrag(Location p) {
	}
	public void updateTape() {
		// 11 spaces
		if (tapeEntries.size() != 0) {
			for (String a : tapeEntries) {
				System.out.println(a);
			}
			tapes[10].setText(tapeEntries.get(tapeEntries.size()-1));
			if (tapeEntries.size() > 1) {
				tapes[9].setText(tapeEntries.get(tapeEntries.size()-2));
				if (tapeEntries.size() > 2) {
					tapes[8].setText(tapeEntries.get(tapeEntries.size()-3));
					if (tapeEntries.size() > 3) {
						tapes[7].setText(tapeEntries.get(tapeEntries.size()-4));
						if (tapeEntries.size() > 4) {
							tapes[6].setText(tapeEntries.get(tapeEntries.size()-5));
							if (tapeEntries.size() > 5) {
								tapes[5].setText(tapeEntries.get(tapeEntries.size()-6));
								if (tapeEntries.size() > 6) {
									tapes[4].setText(tapeEntries.get(tapeEntries.size()-7));
									if (tapeEntries.size() > 7) {
										tapes[3].setText(tapeEntries.get(tapeEntries.size()-8));
										if (tapeEntries.size() > 8) {
											tapes[2].setText(tapeEntries.get(tapeEntries.size()-9));
											if (tapeEntries.size() > 9) {
												tapes[1].setText(tapeEntries.get(tapeEntries.size()-10));
												if (tapeEntries.size() > 10) {
													tapes[0].setText(tapeEntries.get(tapeEntries.size()-11));
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	public double calculateInput() {
		if (inputs.size() != 0) {
			double tmpResult=0;
			String tmpString="";
			for (String s:inputs) {
				tmpString+=s;
			}
			if (inputs.get(0) == "-") {
				inputs.remove(0);
				for (String s:inputs) {
					tmpString+=s;
				}
				return -Double.parseDouble(tmpString);
			} else {
				return Double.parseDouble(tmpString);
			}
		} else {
			return 0;
		}
	}
	public int getSIs(double in) {
		BigDecimal input = new BigDecimal(in);
  		return input.scale() <= 0
        ? input.precision() + input.stripTrailingZeros().scale()
        : input.precision();
	}
	public void updateDisplay() {
		top.setScore((double)Math.round(calculateInput() * 10000d) / 10000d);
	}
	public Button createButton(int row, int col, int totalRows, int totalCols, String string, int opID) {
		if (string == "=") {
			return new Button(string, lowerSecBorder.getX()+6+((lowerSecBorder.getWidth()-8)/totalCols*col), lowerSecBorder.getY()+(2*row)+(((lowerSecBorder.getHeight()-12)/totalRows)*row), (lowerSecBorder.getWidth()-8)/totalCols-4, ((lowerSecBorder.getHeight()-(4*totalRows)-8)/totalRows)*2+5, new Color(0xffffff), new Color(0x000000), c, Integer.parseInt(""+row+col), opID);
		} else {
			return new Button(string, lowerSecBorder.getX()+6+((lowerSecBorder.getWidth()-8)/totalCols*col), lowerSecBorder.getY()+(2*row)+(((lowerSecBorder.getHeight()-12)/totalRows)*row), (lowerSecBorder.getWidth()-8)/totalCols-4, (lowerSecBorder.getHeight()-(4*totalRows)-8)/totalRows, new Color(0xffffff), new Color(0x000000), c, Integer.parseInt(""+row+col), opID);
		}
	}
	public static String parseToCientificNotation(double value) {
		int cont = 0;
		java.text.DecimalFormat DECIMAL_FORMATER = new java.text.DecimalFormat("0.####");
		while (value/10 > 1 || value*10 < 10) {
			if (value/10 > 1) {
				value /= 10;
				cont++;
			} else {
				value *= 10;
				cont--;
			}
		}
		return DECIMAL_FORMATER.format(value).replace(",", ".") + " x10^" + cont;
	}
}