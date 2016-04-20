
import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Particles extends ActiveObject {
	Particle[] pOuts, pIDs;
	int[] direction;
	int pInDirection, pDirectionLife;
	double centerX, centerY, pWidth;
	DrawingCanvas c;
	Color[] colors;
	public Particles(double centerX, double centerY, double pWidth, double dx, double dy, int pOut, int pOutSets, int pOutLife, int pInDirection, int pDirectionLife, int[] direction, Color[] colors, DrawingCanvas c) {
		pOuts = new Particle[pOut];
		pIDs = new Particle[pInDirection];
		this.c = c;
		this.direction = direction;
		this.pInDirection = pInDirection;
		this.centerX = centerX;
		this.centerY = centerY;
		this.pWidth = pWidth;
		this.colors = colors;
		this.pDirectionLife = pDirectionLife;
		start();
		if (pOut % pOutSets != 0) {
			System.out.println("invalid sets of outward burst particles");
			System.exit(1);
		}
		int ii = 0;
		for (int a=0;a < pOutSets;a++) {
			for (int i=0;i < pOut/pOutSets;i++) {
				double angle = (0+((360/(pOut/pOutSets))*(i%(pOut/pOutSets))));
				pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dxdyFromAngle(angle)[0]/1.5, dxdyFromAngle(angle)[1]/1.5, pOutLife, c);
				ii++;
			}
			pause(1000);
		}
	}
	public void run() {
		int ii = 0;
		if (direction.length != 0) {
			for (int a=0;a < pInDirection/direction.length;a++) {
				for (int b=0;b < direction.length;b++) {
					pIDs[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dxdyFromAngle(new RandomIntGenerator(direction[b]-8, direction[b]+8).nextValue())[0], dxdyFromAngle(new RandomIntGenerator(direction[b]-2, direction[b]+2).nextValue())[1], pDirectionLife, c);
				}
			}
		}
	}
	public static double[] dxdyFromAngle(double ang) {
		return new double[] {2*(Math.cos((-Math.toRadians(ang+90)))), 2*(Math.sin((-Math.toRadians(ang+90))))};
	}
}