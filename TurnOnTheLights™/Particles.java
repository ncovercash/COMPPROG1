
import objectdraw.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import javax.imageio.*;
public class Particles extends ActiveObject {
	Particle[] pOuts, pIDs;
	public Particles(double centerX, double centerY, double pWidth, double dx, double dy, int pOut, int pOutSets, int pOutLife, int pInDirection, int pDirectionLife, int[] direction, Color[] colors, DrawingCanvas c) {
		pOuts = new Particle[pOut];
		pIDs = new Particle[pInDirection];
		this.direction = direction;
		this.pInDirection;
		run();
		if (pOut % pOutSets != 0) {
			System.out.println("invalid sets of outward burst particles");
			System.exit(1);
		}
		int ii = 0;
		for (int a=0;a < pOutSets;a++) {
			for (int i=0;i < pOut/pOutSets;i++) {
				System.out.println(0+((360/(pOut/pOutSets))*(i%(pOut/pOutSets)))); // angle
				double angle = (0+((360/(pOut/pOutSets))*(i%(pOut/pOutSets))));
				pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dxdyFromAngle(angle)[0], dxdyFromAngle(angle)[1], pOutLife, c);
				ii++;
			}
			pause(1000);
		}
	}
	public void start() {
		int ii = 0;
		for (int a=0;a < pInDirection/direction.length;a++) {
			for (int b=0;b < direction.length;b++) {
				pIDs[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dxdyFromAngle(new RandomIntGenerator(direction[b]-2, direction[b]+2))[0], dxdyFromAngle(new RandomIntGenerator(direction[b]-2, direction[b]+2))[1], pDirectionLife, c);
			}
		}
	}
	public static double[] dxdyFromAngle(double ang) {
		return new double[] {3*(Math.cos((-Math.toRadians(ang+90)))), 3*(Math.sin((-Math.toRadians(ang+90))))};
	}
}