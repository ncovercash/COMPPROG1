
import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Driver extends WindowController {
	// red: bad, [0-.2), yellow:GREAT, [.2-.25], green: meg, (.25,1)
	Pig pig;
	Slider size;
	ScoreBox scor;
	ResetButton RESET;
	int oldSize;
	Base base;
	ArrayList<Projectile> fired;
	Projectile deadProjectile;
	double nextPRandom;
	public static void main(String[] args) {
		new Driver().startController(1280, 1024);
	}
	public void begin() {
		pig = new Pig(0, 0, 400, 400, 3, 0, new Color(0xff0000), new Color(0x000000), new Color(0xffffff), canvas);
		size = new Slider(10, 100, 40, 200, new int[] {1,101}, 50, new boolean[] {true, false, true, true}, new Color(0xff0000), "Size", canvas);
		base = new Base(canvas, 0, 1);
		scor = new ScoreBox(canvas, 0, new Color(250,193,102), "Score: ");
		RESET = new ResetButton(canvas);
		deadProjectile = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, 0, "img/projectile/green.png", 1, canvas);
		nextPRandom=.5;
	}
	public void onMouseClick(Location p) {
		if (RESET.testClick(p)) {
			reset();
		} else {
			fire();
		}
	}
	public void fire() {
		nextPRandom = Math.random();
		Projectile t;
		if (nextPRandom < .2) {
			deadProjectile.setImg("img/projectile/red.png");
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -10, "img/projectile/red.png", 1, canvas);
		} else if (nextPRandom <= .25) {
			deadProjectile.setImg("img/projectile/yellow.png");
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -10, "img/projectile/yellow.png", 1, canvas);
		} else {
			deadProjectile.setImg("img/projectile/green.png");
			t = new Projectile(base.getX()+(base.getWidth()/2)-5, base.getY(), 10, 10, 0, -10, "img/projectile/green.png", 1, canvas);
		}
		t.allowMovability();
		fired.add(t);
	}
	public void reset() {
		pig.removeFromCanvas();
		pig.interrupt();
		pig = new Pig(0, 0, 400, 400, 3, 0, new Color(0xff0000), new Color(0x000000), new Color(0xffffff), canvas);
		scor.setScore(0);
		size.setSlide(50);
	}
	public void onMouseDrag(Location p) {
		if (size.contains(p)) {
			size.drag(p);
			if (size.val()>oldSize) {
				oldSize = size.val();
				pig.grow(0.1);
			} else if (size.val()<oldSize) {
				oldSize = size.val();
				pig.shrink(0.1);
			}
		}
	}
	public void onMousePress(Location p) {
		//
	}
	public void onMouseMove(Location p) {
		if (p.getX() <= canvas.getWidth()-base.getWidth()) {
			base.moveTo(p.getX(), 0);
			deadProjectile.moveTo(base.getX()+(base.getWidth()/2)-5, base.getY());
		}
	}
}
