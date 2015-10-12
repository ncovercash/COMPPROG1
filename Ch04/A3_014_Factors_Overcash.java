package Ch04;

import objectdraw.*;
import java.awt.*;
import java.util.*;
public class A3_014_Factors_Overcash extends WindowController {
    int[] equation = new int [3]; // [0] is the first factor, [1] is the 2nd factor, [2] is the answer
    RandomIntGenerator rGen = new RandomIntGenerator(0, 9);
    Text instructions;
    Text equationText;
    public static void main(String[] args) {
        A3_014_Factors_Overcash oc = new A3_014_Factors_Overcash();
        oc.startController(1200, 600);
        oc.instructions = new Text("Press for equation, release for answer", 0, 100, oc.canvas);
        oc.instructions.setColor(new Color(113, 48, 56));
        oc.instructions.setFontSize(18);
        oc.instructions.moveTo(oc.canvas.getWidth()/2, oc.instructions.getY());
        oc.instructions.move(-oc.instructions.getWidth()/2, 0);
        oc.equationText = new Text("What is", 0, 300, oc.canvas);
        oc.equationText.setFontSize(24);
        oc.equationText.moveTo(oc.canvas.getWidth()/2, oc.equationText.getY());
        oc.equationText.move(-oc.equationText.getWidth()/2, 0);
    }
    public void onMousePress(Location p) {
        equation[0] = rGen.nextValue();
        equation[1] = rGen.nextValue();
        equation[2] = equation[0] * equation[1];
        System.out.println(Arrays.toString(equation));
        equationText.setText("What is "+equation[0]+" * "+equation[1]+"");
        equationText.moveTo(canvas.getWidth()/2, equationText.getY());
        equationText.move(-equationText.getWidth()/2, 0);
    }
    public void onMouseRelease(Location p) {
        equationText.setText("What is "+equation[0]+" * "+equation[1]+": "+equation[2]);
        equationText.moveTo(canvas.getWidth()/2, equationText.getY());
        equationText.move(-equationText.getWidth()/2, 0);
    }
}