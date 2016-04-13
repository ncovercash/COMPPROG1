package mathGame;



import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	ScoreBox sb;
	ResetButton RESET;
	Text problem;
	FramedRect pb;
	Button[] operands;
	String[] operandsText = new String[] {"+", "–", "✕", "÷", "%", "^"};
	String problemOp;
	int problemOpID;
	double val1, val2, val3;
	int[] nums;
	public static void main(String[] args) {
		Driver oc = new Driver();
		oc.startController((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-25); // Fullscreen dat		
		// oc.startController(1280,1024); // double desktop alt
	}
	public void begin() {
		nums = new int[50];
		sb = new ScoreBox(canvas, 0, new Color(250,193,102), "Score: ");
		RESET = new ResetButton(canvas);
		pb = new FramedRect(canvas.getWidth()/4, canvas.getHeight()/6, canvas.getWidth()/2, canvas.getHeight()/2, canvas);
		operands = new Button[operandsText.length];
		for (int i=0; i<operandsText.length; i++) {
			operands[i] = new Button(operandsText[i], ((canvas.getWidth()/(operandsText.length+1))*(i+1))-(canvas.getWidth()/20), (canvas.getHeight()/4)*3+canvas.getHeight()/30, canvas.getWidth()/15, canvas.getHeight()/15, new Color(0xffffff), new Color(0x000000), canvas, i);
		}
		/*operands = new Button[] {
			new Button("+", canvas.getWidth()/5-(canvas.getWidth()/20), (canvas.getHeight()/4)*3, canvas.getWidth()/10, canvas.getHeight()/10, new Color(0xffffff), new Color(0x000000), canvas)
			new Button("–", ((canvas.getWidth()/5)*2)-(canvas.getWidth()/20), (canvas.getHeight()/4)*3, canvas.getWidth()/10, canvas.getHeight()/10, new Color(0xffffff), new Color(0x000000), canvas)
			new Button("✕", ((canvas.getWidth()/5)*3)-(canvas.getWidth()/20), (canvas.getHeight()/4)*3, canvas.getWidth()/10, canvas.getHeight()/10, new Color(0xffffff), new Color(0x000000), canvas)
			new Button("÷", ((canvas.getWidth()/5)*4)-(canvas.getWidth()/20), (canvas.getHeight()/4)*3, canvas.getWidth()/10, canvas.getHeight()/10, new Color(0xffffff), new Color(0x000000), canvas)
		};*/
		genNums(-10, 10);
		newProblem();
	}
	public void onMouseClick(Location p) {
		if (RESET.testClick(p)) {
			reset();
		} else {
			for (Button b : operands) {
				if (b.testClick(p)) {
					boolean validOp=false;
					switch(b.getBID()) {
						case 0:
							if (val3 == val1+val2) {
								validOp=true;
							}
							break;
						case 1:
							if (val3 == val1-val2) {
								validOp=true;
							}
							break;
						case 2:
							if (val3 == val1*val2) {
								validOp=true;
							}
							break;
						case 3:
							if (val3 == val1/val2) {
								validOp=true;
							}
							break;
						case 4:
							if (val3 == val1%val2) {
								validOp=true;
							}
							break;
						case 5:
							if (val3 == Math.pow((int)val1, (int)val2)) {
								validOp=true;
							}
							break;
					}
					if (validOp) {
						sb.addScore(1);
						newProblem();
					} else {
						sb.addScore(-1);
					}
					break;
				}
			}
		}
	}
	public void reset() {
		sb.setScore(0);
		newProblem();
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
	public void genNums(int min, int max) {
		RandomIntGenerator gen = new RandomIntGenerator(min, max);
		for (int i=0; i<nums.length; i++) {
			nums[i] = gen.nextValue();
		}
	}
	public void newProblem() {
		boolean redo = false;
		try {
			problem.removeFromCanvas();
		} catch (Exception e) {
			//
		}
		RandomIntGenerator numGen = new RandomIntGenerator(0, nums.length-1);
		val1 = nums[numGen.nextValue()];
		problemOpID = operands[new RandomIntGenerator(0,operands.length-1).nextValue()].getBID();
		problemOp = operands[problemOpID].getButtonText();
		val2 = nums[numGen.nextValue()];
		val3=0;
		switch(problemOpID) {
			case 0:
				val3 = val1+val2;
				break;
			case 1:
				val3 = val1-val2;
				break;
			case 2:
				val3 = val1*val2;
				break;
			case 3:
				if (val2 == 0) {
					redo=true;
					break;
				}
				val3 = val1/val2;
				break;
			case 4:
				if (val2 == 0) {
					redo=true;
					break;
				}
				val3 = val1%val2;
				break;
			case 5:
				if (val2 == 0) {
					redo=true;
					break;
				}
				val3 = Math.pow((int)val1, (int)val2);
				break;
		}
		if (val3 == (int)val3) {
			problem = new Text((int)val1+" ? "+(int)val2+" = "+(int)val3, 100, 100, canvas);
		} else {
			problem = new Text((int)val1+" ? "+(int)val2+" = "+val3, 100, 100, canvas);
		}
		problem.setFontSize((int)pb.getHeight());
		int fs = (int)pb.getHeight();
		while (problem.getWidth() > pb.getWidth()-10 || problem.getHeight() > pb.getHeight()-10) {
			fs--;
			problem.setFontSize(fs);
		}
		problem.moveTo(pb.getX()+10, pb.getY()+10);
		problem.moveTo(problem.getX(), pb.getY()+pb.getHeight()/2-problem.getHeight()/2);
		if (redo) {
			newProblem();
		}
	}
	public void debugLine(Exception a) {
		StackTraceElement exfl = a.getStackTrace()[0];
		System.out.println(exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber());
	}
	public void debugLine(Exception a, String arg) {
		StackTraceElement exfl = a.getStackTrace()[0];
		System.out.println(arg+"  "+exfl.getClassName()+"/"+exfl.getMethodName()+":"+exfl.getLineNumber());
	}
}