

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
		if (pOut % pOutSets != 0) {
			System.out.println("invalid sets of outward burst particles");
			System.exit(1);
		}
		int ii = 0;
		for (int a=0;a < pOutSets;a++) {
			for (int i=0;i < pOut/pOutSets;i++) {
				System.out.println(0+((360/(pOut/pOutSets))*(i%(pOut/pOutSets)))); // angle
				double angle = (0+((360/(pOut/pOutSets))*(i%(pOut/pOutSets))));
				switch ((int)angle) {
					case 0:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy-2, pOutLife, c);
						break;
					case 5:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 10:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 15:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 20:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 25:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 30:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 35:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 40:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 45:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx+1, dy-1, pOutLife, c);
						break;
					case 50:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 55:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 60:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 65:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 70:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 75:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 80:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 85:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 90:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx+2, dy, pOutLife, c);
						break;
					case 95:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 100:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 105:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 110:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 115:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 120:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 125:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 130:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 135:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx+1, dy+1, pOutLife, c);
						break;
					case 140:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 145:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 150:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 155:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 160:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 165:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 170:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 175:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 180:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy+2, pOutLife, c);
						break;
					case 185:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 190:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 195:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 200:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 205:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 210:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 215:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 220:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 225:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx-1, dy+1, pOutLife, c);
						break;
					case 230:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 235:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 240:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 245:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 250:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 255:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 260:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 265:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 270:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx-2, dy, pOutLife, c);
						break;
					case 275:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 280:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 285:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 290:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 295:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 300:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 305:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 310:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 315:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx-1, dy-1, pOutLife, c);
						break;
					case 320:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 325:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 330:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 335:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 340:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 345:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 350:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					case 355:
						pOuts[ii] = new Particle(centerX-pWidth/2, centerY-pWidth/2, pWidth, colors[new RandomIntGenerator(0, colors.length-1).nextValue()], dx, dy, pOutLife, c);
						break;
					default:
						System.out.println("tell developer to add angle "+angle+" or add yourself");
						System.exit(1);
				}
				ii++;
			}
			pause(1000);
		}
	}
}