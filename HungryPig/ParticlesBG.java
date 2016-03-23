
import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class ParticlesBG extends ActiveObject {
	double centerX;
	double centerY;
	double pWidth;
	double dx;
	double dy;
	int pOut;
	int pOutSets;
	int pOutLife;
	int pInDirection;
	int pDirectionLife;
	int[] direction;
	Color[] colors;
	DrawingCanvas c;
	public ParticlesBG(double centerX, double centerY, double pWidth, double dx, double dy, int pOut, int pOutSets, int pOutLife, int pInDirection, int pDirectionLife, int[] direction, Color[] colors, DrawingCanvas c) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.pWidth = pWidth;
		this.dx = dx;
		this.dy = dy;
		this.pOut = pOut;
		this.pOutSets = pOutSets;
		this.pOutLife = pOutLife;
		this.pInDirection = pInDirection;
		this.pDirectionLife = pDirectionLife;
		this.direction = direction;
		this.colors = colors;
		this.c = c;
		start();
	}
	public void run() {
		new Particles(centerX, centerY, pWidth, dx, dy, pOut, pOutSets, pOutLife, pInDirection, pDirectionLife, direction, colors, c);
	}
	public void stopExec() {
		interrupt();
	}
}