package ProcessingGame.src;

import processing.core.*;

public class LivingBeing {
	Applet m;
	PImage img;
	int x;
	int y;

	public LivingBeing(Applet app, int xx, int yy, String image) {
		m = app;
		x = xx;
		y = yy;
		try {
			img = m.loadImage(image);
		} catch ( Exception e) {
			System.out.println("Couldn't find image " + image);
			System.exit(-1);
		}
	}

}
